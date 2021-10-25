<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Show companies</title>
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/modern-normalize/1.0.0/modern-normalize.min.css"
    />
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link
      href="https://fonts.googleapis.com/css2?family=Raleway:wght@700&family=Roboto:wght@400;500;700;900&display=swap"
      rel="stylesheet"
    />
    <style>
            <%@include file="../css/styles.css" %>
    </style>
  </head>
  <body>
    <c:import url="/view/company/navbarcompany.jsp"/>
	
	<main>
          <h1>List of companies</h1>
		<c:if test="${empty companies}" >	
      <button type="button" class="modal-submit-btn btn" disabled><a class="link" href="${pageContext.request.contextPath}/company/show">Get list!</a></button>
	  </c:if>
	  
	
	<c:if test="${not empty companies}" >	
	<table class="table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>City</th>
          </tr>
        </thead>
        <tbody>
			<c:forEach items="${companies}" var="company">
          <tr>
            <td>${company.id}</td>
            <td><a href="${pageContext.request.contextPath}/company/get?id=${company.id}">${company.name}</a></td>
            <td>${company.city}</td>
          </tr>
		  </c:forEach>
        </tbody>
      </table>
	</c:if>
	
	</main>
  </body>
</html>