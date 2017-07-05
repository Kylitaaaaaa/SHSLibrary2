<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>

    <link rel="stylesheet" href="css/app_header.css">
    <link rel="stylesheet" href="css/meetings.css">
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
                    <!--

                    <li class="-item"><a href="#" class="-link js-help-button" title="Help Center and other resources">
                        <svg viewBox="0 0 18 18" width="18" height="18" role="icon"><path fill-rule="evenodd" d="M9 0a9 9 0 1 0 .001 18.001A9 9 0 0 0 9 0zm.812 13.126c-.02.716-.55 1.157-1.238 1.137-.659-.02-1.177-.49-1.157-1.209.02-.715.566-1.17 1.225-1.15.691.021 1.194.507 1.17 1.222zm1.956-5.114c-.168.237-.546.542-1.02.912l-.527.361c-.257.197-.417.43-.502.695-.044.141-.076.507-.084.752-.004.048-.032.156-.181.156H7.883c-.165 0-.185-.096-.18-.144.023-.667.12-1.218.397-1.66.374-.594 1.426-1.221 1.426-1.221.161-.12.286-.25.382-.39.177-.24.321-.51.321-.8 0-.333-.08-.65-.293-.915-.249-.31-.518-.458-1.036-.458-.51 0-.808.257-1.021.594-.213.338-.177.735-.177 1.097H5.746c0-1.366.357-2.238 1.112-2.752.51-.35 1.162-.502 1.921-.502.996 0 1.788.184 2.487.715.647.49.988 1.181.988 2.113 0 .575-.2 1.057-.486 1.447z" /></svg>
                    </a></li>
                    <li class="-item">
                        <a href="https://stackexchange.com" class="-link js-site-switcher-button js-gps-track" data-gps-track="site_switcher.show" title="A list of all 167 Stack Exchange sites">
                            <svg viewBox="0 0 18 19" width="18" height="19" role="icon"><path fill-rule="evenodd" d="M0 14a2 2 0 0 0 2 2h10v3l3-3h1a2 2 0 0 0 2-2v-2H0v2zM16 0H2a2 2 0 0 0-2 2v2h18V2a2 2 0 0 0-2-2zM0 6h18v4H0V6z" /></svg>
                        </a>
                    </li>
                    -->

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
        <div class="u-article-container">
            <div class="search-info responsive-image">
                <h3><a class="aa" (click)="onSelect(s)">8-D</a></h3>
                <span class="span">9:15-10:45</span>
                <button class="btn-link text-success">Reserve</button>
                <hr>
            </div>
            <div class="search-info responsive-image">
                <h3><a class="aa" (click)="onSelect(s)">7-B</a></h3>
                <span class="span">14:30-16:00</span>
                <button class="btn-link text-success">Reserve</button>
                <hr>
            </div>
        </div>
    </div>
</div>



</body>
</html>