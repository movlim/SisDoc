<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>

<html lang="en">
<head>
		
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1, maximum-scale=1" name="viewport">
<title>Test page</title>

<link href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
<link href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<link href="bootstrap.css" rel="stylesheet">
</head>
	<body>
	
	<div class="wrap">
	<section>
            <div class="container">
                    <table class="table table-hover">
                            <thead>
                                    <tr>
                                            <th>
                                                    #
                                            </th>
                                            <th>
                                                    Name
                                            </th>
                                            <th>
                                                    Phone Number
                                            </th>
                                            <th>
                                                    Profession
                                            </th>
                                    </tr>
                            </thead>
                            <tbody>
                                    <c:forEach items="${persons}" var="person">
                                            <tr>
                                                    <td>
                                                            <c:out value="${person.personId}"/>
                                                    </td>
                                                    <td>
                                                            <c:out value="${person.name}"/>
                                                    </td>
                                                    <td>
                                                            <c:out value="${person.phone}"/>
                                                    </td>
                                                    <td>
                                                            <c:out value="${person.profession}"/>
                                                    </td>
                                                    <td><a href="PersonController?action=edit&personId=<c:out value="${person.personId}"/>">Update</a></td>
                                                    <td><a href="PersonController?action=delete&personId=<c:out value="${person.personId}"/>">Delete</a></td>
                                            </tr>
                                    </c:forEach>
                            </tbody>
                    </table>
            <a href="PersonController?action=insert" role="button" class="btn btn-info btn-lg" data-toggle="modal">Add new person</a>	
            </div>
	</section>	
</div>

<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

</body>
</html>