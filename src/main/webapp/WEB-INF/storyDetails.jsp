
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<style>
.blue-button {
	background: #25A6E1;
	filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#25A6E1',
		endColorstr='#188BC0', GradientType=0);
	padding: 3px 5px;
	color: #fff;
	font-family: 'Helvetica Neue', sans-serif;
	font-size: 12px;
	border-radius: 2px;
	-moz-border-radius: 2px;
	-webkit-border-radius: 4px;
	border: 1px solid #1A87B9
}

table {
	font-family: "Helvetica Neue", Helvetica, sans-serif;
	width: 50%;
}

th {
	background: SteelBlue;
	color: white;
}

td,th {
	border: 1px solid gray;
	width: 25%;
	text-align: left;
	padding: 5px 10px;
}
</style>
</head>
<body>
	<form:form method="post" modelAttribute="story"
		action="${pageContext.request.contextPath}/addStory">
		<table>
			<tr>
				<th colspan="2">Add Story</th>
			</tr>
			<tr>
				<form:hidden path="id" />
				<td><form:label path="title">Story Title:</form:label></td>
				<td><form:input path="title" size="30" maxlength="30"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="author">Author:</form:label></td>
				<td><form:input path="author" size="30" maxlength="30"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="body">Body:</form:label></td>
				<td><form:input path="body" size="30" maxlength="200"></form:input></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" class="blue-button" /></td>
			</tr>
		</table>
	</form:form>
	</br>
	<h3>Story List</h3>
	<c:if test="${!empty listOfStories}">
		<table class="tg">
			<tr>
				<th width="80">Id</th>
				<th width="120">Story Title</th>
				<th width="120">Author</th>
				<th width="120">Body</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
<!-- 				<th width="60">Json</th> -->
<!-- 				<th width="60">Xml</th> -->
			</tr>
			<c:forEach items="${listOfStories}" var="story">
				<tr>
					<td>${story.id}</td>
					<td>${story.title}</td>
					<td>${story.author}</td>
					<td>${story.body}</td>
					<td><a href="<c:url value='/updateStory/${story.id}' />">Edit</a></td>
					<td><a href="<c:url value='/deleteStory/${story.id}' />">Delete</a></td>
<%-- 					<td><a href="<c:url value='/getStoryAsJson/${story.id}' />">Json</a></td> --%>
<%-- 					<td><a href="<c:url value='/getStoryAsXml/${story.id}' />">Xml</a></td> --%>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>
