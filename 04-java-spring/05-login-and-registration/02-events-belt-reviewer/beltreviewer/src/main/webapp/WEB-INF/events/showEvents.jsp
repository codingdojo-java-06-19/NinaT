<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Events</title>
</head>
	<body>
		<div class="container">
			<h1>Welcome, Ninja</h1>
			<a class="right-link" href="/logout">Logout</a>
			<p>Here are some of the events in your state:</p>
			<table class="tablestyle">
				<tr>
					<th>Name</th>
					<th>Date</th>
					<th>Location</th>
					<th>Host</th>
					<th>Action/Status</th>
				</tr>
				<tr>
					<td><a href="/">Cooking Lesson</a></td>
					<td>November 30, 2018</td>
					<td>Los Angeles</td>
					<td>Kevin</td>
					<td><a href="/">Join</a></td>
				</tr>
				<tr>
					<td></td>
				</tr>
			</table>
			<p>Here are some of the events in other states:</p>
			<table class="tablestyle">
				<tr>
					<th>Name</th>
					<th>Date</th>
					<th>Location</th>
					<th>Host</th>
					<th>Action/Status</th>
				</tr>
				<tr>
					<td><a href="/">Cooking Lesson</a></td>
					<td>November 30, 2018</td>
					<td>Los Angeles</td>
					<td>Kevin</td>
					<td><a href="/">Join</a></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</table>
			<form action="/" method="POST" autocomplete="off">
				<div class="row">
					<div class="col-25">
						<label for="name"></label>
					</div>
					<div class="col-75">
						<input type="text" name="name"/>
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label for="date"></label>
					</div>
					<div class="col-75">
						<input type="date" name="date"/>
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label for="location"></label>
					</div>
					<div class="col-75">
						<input type="text" name="location"/>
					</div>
				</div>
				<div class="row">
					<input type="submit" value="Create Event"/>
				</div>
			</form>
		</div>
	</body>
</html>