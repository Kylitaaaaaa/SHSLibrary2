<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    
    <!-- include the stylesheets -->
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="bootstrap/css/bootstrap-theme.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

    <!-- include the javascript -->
    <script src="bootstrap/jquery/jquery.js"></script>
    <script src="bootstrap/js/bootstrap.js"></script>
    <script src='jquery-1.0.1/jquery.js'></script>

    <link rel="stylesheet" href="css/app_header.css">
    <link rel="stylesheet" href="css/app_body.css">
    <link rel="stylesheet" href="css/ui_searchbox.css">
    <link rel="stylesheet" href="css/meetings.css">
    
    <script src='js/jquery.js'></script>
    <script>
    $(document).ready(function() {
		 
		 $(".book-reserve-link").click(function() {
			 var mrId = $(this).attr("id");
			 //$("."+mrId).text("successfully reserved");
			 $.ajax({
		            url:'postAjax',
		            data:{"parameterToPost":"reserveBook","bookId" : mrId},
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
		 $(".book-review-link").click(function() {
			 var mrId = $(this).attr("name");
			 var review = $("#reviewInput"+mrId).val();
			 $.ajax({
		            url:'postAjax',
		            data:{"parameterToPost":"reviewBook","bookId" : mrId,"reviewContent" : review, "reviewDate":"2017-07-06"},
		            type:'post',
		            success:function(response){
		            	console.log("success getting response: " + response);
		            	if(response == "true")
		            		$(".review"+mrId).text("successfully reviewed");
		            	else
		            		$(".review"+mrId).text("review failed");
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
            <a class="-logo js-gps-track ">
                <div class="custom-logo" style="font-size: 16px;">SHS</div>
                <div class="custom-logo">Library</div>
            </a>

            <nav class="navigation" role="navigation" aria-label="site navigation">
                <ol class="-list">
                    <li class="-item">
                        <a id="nav-announcements" class="text-success -link js-gps-track"
                           ">Meeting Rooms</a>
                    </li>
                </ol>
            </nav>

            <div id = "empty-div">

            </div>

            <form id="search" class="searchbar" autocomplete="off" role="search" action="search" method="GET">
                    <svg viewBox="0 0 18 18" width="18" height="18" role="icon"><path fill-rule="evenodd" d="M12.864 11.32h-.813l-.288-.277A6.66 6.66 0 0 0 13.38 6.69a6.69 6.69 0 1 0-6.69 6.69 6.66 6.66 0 0 0 4.354-1.617l.278.288v.813L16.467 18 18 16.467l-5.136-5.146zm-6.174 0a4.625 4.625 0 0 1-4.632-4.63A4.625 4.625 0 0 1 6.69 2.058a4.625 4.625 0 0 1 4.63 4.632 4.625 4.625 0 0 1-4.63 4.63z"/></svg>
                    <input id = "searchbar-input" type="text" placeholder="Search..." value="" tabindex="1" autocomplete="on" maxlength="240" class="f-input js-search-field"
                          name="searchInput"/>
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


<div style="padding-bottom: 60px;">
    <!-- padding added to adjust-->
</div>


<div class="u-main-container">
    <div style="width: 80%">
        <h5>Search Results for "${searchInput }"</h5>

        <div class="u-article-container">
        <form >
            <select name="filter">
  <option value="Author">Author</option>
  <option value="Title">Title</option>
  <option value="Publisher">Publisher</option>
</select></form>
            
            <c:forEach items="${books}" var="book">
        		
        			<div class="search-info responsive-image">
                <h3><a class="aa">${book.title }</a></h3>
                <span class="span">${book.author }</span>
                <p class="pp" >${book.year} ${book.publisher}</p>
                <button id = "${book.bookId }" class="book-reserve-link btn-link text-success">Reserve</button>
                <p class="${book.bookId }"></p>
                <input class="book-review-input" type="text" placeholder="write a review" value="" tabindex="1" autocomplete="on" maxlength="240" class="f-input js-search-field"
                          id="reviewInput${book.bookId}"/>
                <button name="${book.bookId }" class="book-review-link btn-link text-success">Review</button>
                <p class="review${book.bookId}"></p>
                <hr>
            </div>
        	
        	</c:forEach>
            
        </div>
    </div>
</div>





</body>
</html>