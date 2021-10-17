<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Create company</title>
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
      <h1>Create company</h1>
      <form action="#" class="modal-form">
        <label class="modal-field">
          Enter name
          <input type="text" name="name" class="modal-input" required />
        </label>
        <label class="modal-field">
          Enter ID
          <input type="text" name="id" class="modal-input" />
        </label>
        <button type="submit" class="modal-submit-btn btn">Create!</button>
      </form>
    </main>
  </body>
</html>
