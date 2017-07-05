<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

</head>
<body>

<div class="" id="login-modal" role="dialog" aria-labelledby="myModalLabel">
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
	                    
	                    <input type = "submit"  name = "process" class="login loginmodal-submit" ></button>
	                </form>
                <div class="login-help">
                    <a href="#">Register</a> - <a href="#">Forgot Password</a>
                </div>
            </div>
        </div>
    </div>

</body>
</html>