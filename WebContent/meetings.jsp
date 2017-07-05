<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>

    <link rel="stylesheet" href="css/app_header.css">
    <link rel="stylesheet" href="css/meetings.css">
    
    <script type="text/javascript">
    $(document).ready(function() {
		 
		 $(".meeting-link").click(function() {
			 var mrId = $(this).attr("id");
			 
			 $.ajax({
		            url:'postAjax',
		            data:{"parameterToPost":"reserveMeeting","meetingId" : mrId},
		            type:'post',
		            success:function(response){
		            	console.log("success getting response: " + response);
		            	if(response == "true")
		            		$("."+mrId).text("successfully reserved");
		            	else
		            		$("."+mrId).text("reservation failed");
		            }
		         });
		 });
		 
    });
    
    </script>
    
</head>
<body>

<header class="so-header js-so-header _fixed" role = "banner">
    <div class="-container">
        <div class="-main">
            <a [routerLink]="['Home']" class="-logo js-gps-track ">
                <div class="custom-logo" style="font-size: 16px;">SHS</div>
                <div class="custom-logo">Library</div>
            </a>

            <nav class="navigation" role="navigation" aria-label="site navigation">
                <ol class="-list">
                    <li class="-item">
                        <a id="nav-announcements" class="text-success -link js-gps-track"
                           (click)="selectMeetings()">Meeting Rooms</a>
                    </li>
                    <li class="-item">
                        <a id="nav-services" class="text-success -link js-gps-track"
                           data-gps-track="top_nav.click({is_current:false, location:1, destination:1})">Books/Magazines</a>
                    </li>
                </ol>
            </nav>

            <div id = "empty-div">

            </div>

            <form id="search" class="searchbar" autocomplete="off" role="search">
                <svg viewBox="0 0 18 18" width="18" height="18" role="icon"><path fill-rule="evenodd" d="M12.864 11.32h-.813l-.288-.277A6.66 6.66 0 0 0 13.38 6.69a6.69 6.69 0 1 0-6.69 6.69 6.66 6.66 0 0 0 4.354-1.617l.278.288v.813L16.467 18 18 16.467l-5.136-5.146zm-6.174 0a4.625 4.625 0 0 1-4.632-4.63A4.625 4.625 0 0 1 6.69 2.058a4.625 4.625 0 0 1 4.63 4.632 4.625 4.625 0 0 1-4.63 4.63z"/></svg>
                <input id = "searchbar-input" type="text" placeholder="Search..." value="" tabindex="1" autocomplete="on" maxlength="240" class="f-input js-search-field"
                       [(ngModel)] = "inputText" (keyup.enter)="search()"/>
                <button type="submit" class="btn js-search-submit">
                    <svg viewBox="0 0 18 18" width="18" height="18" role="icon"><path fill-rule="evenodd" d="M12.864 11.32h-.813l-.288-.277A6.66 6.66 0 0 0 13.38 6.69a6.69 6.69 0 1 0-6.69 6.69 6.66 6.66 0 0 0 4.354-1.617l.278.288v.813L16.467 18 18 16.467l-5.136-5.146zm-6.174 0a4.625 4.625 0 0 1-4.632-4.63A4.625 4.625 0 0 1 6.69 2.058a4.625 4.625 0 0 1 4.63 4.632 4.625 4.625 0 0 1-4.63 4.63z"/></svg>
                </button>
            </form>
        </div>

        <div class="-actions">
            <nav class="secondary-nav">
                <ol class="-list">
                </ol>
            </nav>
            <div class="-ctas">
                <a href="#" class="logo-link text-success"  data-toggle="modal" data-target="#login-modal">Log In</a>

            </div>
        </div>
    </div>
</header>

<div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
    <div class="modal-dialog" id = "zindex1050">
        <div class="loginmodal-container">
            <p id = "connection-status"></p>

            <div id="openid-buttons">
                <div class="major-provider google-login">
                    <!--<div class="icon-container"><span class="icon" style=""></span></div>-->
                    <div class="text"><span>Google</span></div>
                </div>
            </div>

            <div class="or-container">
                <hr class="or-hr">
                <div id="or">or</div>
            </div>




            <form id="loginForm" action ="loginUser" method = "GET">
                <input type="text" name="user" placeholder="Username">
                <input type="password" name="pass" placeholder="Password">

                <input type = "submit"  name = "process" class="login loginmodal-submit" >Login</button>
            </form>

            <div class="login-help">
                <a href="#">Register</a> - <a href="#">Forgot Password</a>
            </div>
        </div>
    </div>
</div>
<div style="padding-bottom: 60px;">
    <!-- padding added to adjust-->
</div>


<div class="u-main-container">
    <div>
        <h5>Available Meetings</h5>
        
        <form id="viewForm" action="" method = "POST">
       		<input type = "hidden" name = "selected_idea_to_view" id="meeting-to-reserve"/>
        </form>
        
        <div class="u-article-container">
        	<c:forEach items="${meetingRooms}" var="mr">
        		
        			<div class="search-info responsive-image">
                		<h3><a class="aa" >${mr.roomName}</a></h3>
                		<button id = "${mr.meetingRoomId }" class="meeting-link btn-link text-success">Reserve</button>
                		<p class="${mr.meetingRoomId}"></p>
                		<hr>
                	</div>
        	
        	</c:forEach>
        </div>
    </div>
</div>



</body>
</html>