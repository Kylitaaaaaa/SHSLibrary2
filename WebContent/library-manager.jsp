<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    
     <link href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.2/css/materialize.css" rel="stylesheet">
    <script src='jquery-1.0.1/jquery.js'></script>

    <link rel="stylesheet" href="css/app_header.css">
    
    <script src='js/jquery.js'></script>
    <script>
    $(document).ready(function() {
		 
		 
		 
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
                           >Meeting Rooms</a>
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



  <div class="container">
    <div class="row">
      <div class="col s12">
        <ul class="tabs">
          <li class="tab col s3"><a href="#test1">Add Book</a></li>
          <li class="tab col s3"><a class="active" href="#test2">delete book</a></li>
          <li class="tab col s3"><a href="#test3">Edit Book</a></li>
          <li class="tab col s3"><a href="#test4">Override Room</a></li>
        </ul>
      </div>
      <div id="test1" class="col s12">
      	<form action="addBook" method="POST">
      		<input type="text" name="title" placeholder="Title">
      		<input type="text" name="type" placeholder="Type">
	        <input type="text" name="author" placeholder="Author">
	        <input type="text" name="publisher" placeholder="Publisher">
	        <input type="text" name="year" placeholder="Year">
	        <input type="text" name="location" placeholder="Location">
	        <input type="text" name="status" placeholder="Status">
	                    
	        <input type = "submit"  name = "process" class="login loginmodal-submit" ></button>
      	</form>
      </div>
      <div id="test2" class="col s12">
      	<form action="deleteBook" method="POST">
      		
	        <input type="text" name="bookId" placeholder="book id">
	                    
	        <input type = "submit"  name = "process1" class="login loginmodal-submit" ></button>
      	</form>
      </div>
      <div id="test3" class="col s12">
      	<form action="editBook" method="POST">
      		<input type="text" name="bookId" placeholder="Book id">
      		<input type="text" name="title" placeholder="Title">
      		<input type="text" name="type" placeholder="Type">
	        <input type="text" name="author" placeholder="Author">
	        <input type="text" name="publisher" placeholder="Publisher">
	        <input type="text" name="year" placeholder="Year">
	        <input type="text" name="location" placeholder="Location">
	        <input type="text" name="status" placeholder="Status">
	                    
	        <input type = "submit"  name = "process" class="login loginmodal-submit" ></button>
      	</form>
      </div>
      <div id="test4" class="col s12">
      	<form action="override" method="POST">
      		<input type="text" name="room_logId" placeholder="Room log id">
      		<input type="text" name="roomId" placeholder="Room id">
      		<input type="text" name="startTime" placeholder="start time">
	        <input type="text" name="endTime" placeholder="end time">
	        <input type="text" name="reservationDate" placeholder="reservation date">
	        <input type="text" name="dateReserved" placeholder="date reserved">
	        <input type="text" name="status" placeholder="Status">
	                    
	        <input type = "submit"  name = "process" class="login loginmodal-submit" ></button>
      	</form>
      </div>
    </div>
    <!-- Page Content goes here -->
  </div>




<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.2/js/materialize.js"></script>
</body>
</html>