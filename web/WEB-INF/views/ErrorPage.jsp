
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>

<html>
  <head>
    <title>Application error</title>
  </head>
  <body>
    <br/><br/><br/>
    <h1 align="center"> E R R O R </h1>
    <h1 align="center">${pageContext.errorData.statusCode}</h1>
    <h2 align="center">${pageContext.exception.message}</h2>
  </body>
</html>
