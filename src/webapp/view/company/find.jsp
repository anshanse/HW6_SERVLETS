<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Find company</title>
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
      <h1>Find company by ID</h1>
      <form action="#" class="modal-form">
        <label class="modal-field">
          Enter company ID
          <input type="text" name="${companyId}" class="modal-input" required pattern="/d+"/>
        </label>
        <button type="submit" class="modal-submit-btn btn" disabled><a class="link" href="${pageContext.request.contextPath}/company/find">Search!</button>
		
		<div class="results">
	  <c:if test="${not empty company}" >	
	  
	  <a href="${pageContext.request.contextPath}/company/get?id=${company.id}">${company.name}</a>
		
		</c:if>
		${message}
	</div>
      </form>
    </main>
  </body>
</html>
