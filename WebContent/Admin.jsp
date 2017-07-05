<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Admin</title>

        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/Admin.css" rel="stylesheet">

        <!-- snackbar -->
        <link href="css/snackbar.min.css" rel=stylesheet>
        <link href="css/material.css" rel=stylesheet>

        <!-- Custom CSS -->
        <style>
        body {
            padding-top: 70px;
            /* Required padding for .navbar-fixed-top. Remove if using .navbar-static-top. Change if height of navigation changes. */
        }
        </style>

    </head>

    <body>
        <!-- jQuery Version 1.11.1 -->
        <script src="js/jquery.js"> </script>

        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.min.js"> </script>

        <!-- snackbar -->
        <script src="js/snackbar.min.js"> </script>

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" id ="logout"href="Controller">Logout</a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container -->
        </nav>

        <!-- Page Content -->
        <div class="container">

            <div id ="libManDiv" class ="libMan">
                    
                <div class='btn-toolbar pull-right'>
                    <div class='btn-group'>
                        <button type='button' id = "addLibMan" class='btn btn-primary'><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>  Add</button>
                    </div>
                </div>
                <h2>Admin</h2>

                <div class="row withPaddingTop">
                    <ul class="nav nav-tabs">

                        <li role="presentation" id ="libManTab" class="active"><a href="#">Library Manager</a></li>
                        <li role="presentation" id ="libStaffTab"><a href="#">Library Staff</a></li>
                        <li role="presentation" id ="profTab"><a href="#">Professors</a></li>
                        <li role="presentation" id ="studentTab"><a href="#">Student</a></li>
                    </ul>
                </div>
                <!-- /.row -->

                <div id="libManTable" class="withPaddingTop libMan">
                    <form id="getAdminManForm" class="navbar-form navbar-left" action ="getAllAdminManager" method = "GET">
                	<input type="hidden" name = "process" id = "getAdminManList"/>
                </form>
                    <table class="table table-hover" >
                        <tr>
                            <th class="col-md-3">ID Number</th>
                            <th class="col-md-4">First Name</th>
                            <th class="col-md-3">Middle Initial</th>
                            <th class="col-md-3">Last Name</th>
                            <th class="col-md-3">Birthday</th>
                        </tr>
                        
                        <c:forEach items="${adminManList}" var="o">
                        <tr>
                        		<td id="${o.idNumber}" > <button type="button" class="btn btn-default">Unlock</button> </td>
	                            <td>${o.idNumber} </td>
	                            <td>${o.firstName} </td>
	                            <td>${o.middleInitial} </td>
	                            <td>${o.lastName} </td>
	                            <td>${o.birthday} </td>
	                        </tr>
                        	
                        </c:forEach>
                    </table>
                </div>
                
                <div id="libStaffTable" class="withPaddingTop libMan">
                    <form id="getAdminManForm" class="navbar-form navbar-left" action ="getAllAdminManager" method = "GET">
                		<input type="hidden" name = "process" id = "getAdminManList"/>
                	</form>
                    <table class="table table-hover" >
                        <tr>
                            <th class="col-md-3">ID Number</th>
                            <th class="col-md-4">First Name</th>
                            <th class="col-md-3">Middle Initial</th>
                            <th class="col-md-3">Last Name</th>
                            <th class="col-md-3">Birthday</th>
                        </tr>
                        
                        <c:forEach items="${adminManList}" var="o">
                        <tr>
                        		<td id="${o.idNumber}" > <button type="button" class="btn btn-default">Unlock</button> </td>
	                            <td>${o.idNumber} </td>
	                            <td>${o.firstName} </td>
	                            <td>${o.middleInitial} </td>
	                            <td>${o.lastName} </td>
	                            <td>${o.birthday} </td>
	                        </tr>
                        	
                        </c:forEach>
                    </table>
                </div>
                
                <div id="libProfTable" class="withPaddingTop libMan">
                    <form id="getAdminManForm" class="navbar-form navbar-left" action ="getAllAdminManager" method = "GET">
                		<input type="hidden" name = "process" id = "getAdminManList"/>
                	</form>
                    <table class="table table-hover" >
                        <tr>
                            <th class="col-md-3">ID Number</th>
                            <th class="col-md-4">First Name</th>
                            <th class="col-md-3">Middle Initial</th>
                            <th class="col-md-3">Last Name</th>
                            <th class="col-md-3">Birthday</th>
                        </tr>
                        
                        <c:forEach items="${adminManList}" var="o">
                        <tr>
                        		<td id="${o.idNumber}" > <button type="button" class="btn btn-default">Unlock</button> </td>
	                            <td>${o.idNumber} </td>
	                            <td>${o.firstName} </td>
	                            <td>${o.middleInitial} </td>
	                            <td>${o.lastName} </td>
	                            <td>${o.birthday} </td>
	                        </tr>
                        	
                        </c:forEach>
                    </table>
                </div>
                
                <div id="libStudentTable" class="withPaddingTop libMan">
                    <form id="getAdminManForm" class="navbar-form navbar-left" action ="getAllAdminManager" method = "GET">
                		<input type="hidden" name = "process" id = "getAdminManList"/>
                	</form>
                    <table class="table table-hover" >
                        <tr>
                            <th class="col-md-3">ID Number</th>
                            <th class="col-md-4">First Name</th>
                            <th class="col-md-3">Middle Initial</th>
                            <th class="col-md-3">Last Name</th>
                            <th class="col-md-3">Birthday</th>
                        </tr>
                        
                        <c:forEach items="${adminManList}" var="o">
                        <tr>
                        		<td id="${o.idNumber}" > <button type="button" class="btn btn-default">Unlock</button> </td>
	                            <td>${o.idNumber} </td>
	                            <td>${o.firstName} </td>
	                            <td>${o.middleInitial} </td>
	                            <td>${o.lastName} </td>
	                            <td>${o.birthday} </td>
	                        </tr>
                        	
                        </c:forEach>
                    </table>
                </div>
                
            </div>

        </div>

        <div class="modal fade" id="addManagerModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="exampleModalLabel">Add Library Manager</h4>
                </div>
                <div class="modal-body" style="margin: 0;">
                	<form action = "Controller" method = "POST">
                    <div class="form-group">
                    	<input type="hidden" name="process" value = "addManager"/>
                    	
                    	<div class="form-group col-xs-12">
                            <input type="text" placeholder ="ID Number" class="form-control" name="id_num">
                        </div>

                        <div class="form-group col-xs-6">
                            <input type="text" placeholder ="First Name" class="form-control" name="first_name">
                        </div>
                       
                        <div class="form-group col-xs-6">
                            <input type="text" placeholder ="Last Name" class="form-control" name="last_name">
                        </div>
                        
                        <div class="form-group col-xs-2">
                            <input type="text" placeholder ="M.I." class="form-control" name="m_initial">
                        </div>
                        
                        <div class="form-group col-xs-12">
                            <input type="text" placeholder ="Mobile Number" class="form-control" name="mobile_number">
                        </div>

                        <div class="form-group col-xs-12">
                        	<input type="text" placeholder ="Email Address" class="form-control" name="email_address">
                        </div>
                        
                        <div class="form-group col-xs-12">
                        	<input type="password" placeholder ="Password" class="form-control" name="password">
                        </div>
                        
                        <div class="form-group col-xs-6">
                            <input type="text" placeholder ="Secret Question" class="form-control" name="secret_question">
                        </div>
                        
                        <div class="form-group col-xs-6">
                            <input type="text" placeholder ="Secret Answer" class="form-control" name="secret_answer">
                        </div>
                        <div class="form-group col-xs-6">
                        	<input type="date" id="myDate" name="birthday">
                        </div>
                        
                        <div class="form-group col-xs-2">
                            <input type="text" placeholder ="AT" class="form-control" name="a_type">
                        </div>
                    </div>
                    
                    <div class="modal-footer">
	                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
	                    <input type="submit" button type="button" id = "submitAddManager" class="btn btn-primary"/>
                	</div>
                	
                    </form>
                </div>
                
                </div>
            </div>
        </div>

        <div class="modal fade" id="addStaffModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="exampleModalLabel">Add Library Staff</h4>
                </div>
                <div class="modal-body" style="margin: 0;">
                    <form action = "Controller" method = "POST">
                    <div class="form-group">

                        <div class="form-group col-xs-6">
                            <input type="text" placeholder ="First Name" class="form-control" id="recipient-name">
                        </div>

                        <div class="form-group col-xs-6">
                            <input type="text" placeholder ="Last Name" class="form-control" id="recipient-name">
                        </div>
                        
                        <div class="form-group col-xs-12">
                            <input type="text" placeholder ="Mobile Number" class="form-control" id="recipient-name">
                        </div>

                        <div class="form-group col-xs-12">
                        <input type="text" placeholder ="Email Address" class="form-control" id="recipient-name">
                        </div>
                    </div>
                    <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                    <input type="submit" button type="button" id = "submitAddStaff" class="btn btn-primary"/>
                </div>
                    </form>
                </div>
                
                </div>
            </div>
        </div>


        <!-- /.container -->

        

        <script>
            $(document).ready(function(){
            	$("#logout").click(function(){
            		console.log("here at logout");
            		document.cookie = 'username=;expires=Thu, 01 Jan 1970 00:00:01 GMT;';
            		
                });
            	
            	
                $("#libManTab").click(function(){
                    $("#libManDiv").show();
                    $("#libStaffTable").hide();
                    $("#libProfTable").hide();
                    $("#libStudentTable").hide();
                    $('#libManTab').tab('show');
                });

                $("#libStaffTab").click(function(){
                	$("#libManDiv").hide();
                    $("#libStaffTable").show();
                    $("#libProfTable").hide();
                    $("#libStudentTable").hide();
                    $('#libStaffTab').tab('show');
                });

                $("#profTab").click(function(){
                	$("#libManDiv").hide();
                    $("#libStaffTable").hide();
                    $("#libProfTable").show();
                    $("#libStudentTable").hide();
                    $('#profTab').tab('show');
                });

                $("#studentTab").click(function(){
                	$("#libManDiv").hide();
                    $("#libStaffTable").hide();
                    $("#libProfTable").hide();
                    $("#libStudentTable").show();
                    $('#studentTab').tab('show');
                });

                $("#addLibMan").click(function(){
                    $('#addManagerModal').modal('show');
                });

                $("#addLibStaff").click(function(){
                    $('#addStaffModal').modal('show');
                });

                $("#submitAddManager").click(function(){
                    $('#addManagerModal').modal('hide');
                    $.snackbar({content: "Successfully Added Manager!"});
                });

                $("#submitAddStaff").click(function(){
                    $('#addStaffModal').modal('hide');
                    $.snackbar({content: "Successfully Added Staff!"});
                });   
                
                $("#submitAddManager").on("click", function() {
                	/* var em = "Scared";
                	$("#hiddeninput").val(em); */
                	console.log("here at click");
                	$("#Controller").submit();
                	
                });
                
                //<form action = "TrialServlet" method = "POST" id = "addManager">
            });
        </script>
    </body>
</html>
