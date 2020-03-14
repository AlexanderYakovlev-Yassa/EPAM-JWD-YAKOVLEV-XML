
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page errorPage="ErrorPage.jsp"%>

<html>
  <head>
    <title>XML parser</title>
  </head>
  <body>
    <p align="right">Java Web Development course Task XML parser and WEB</p><br/>
    <h1 align="center">XML parser</h1><br/>
    <h3 align="center">Choose an XML file and pick the way you want to parse it:</h3><br/>

    <form name="Simple" action="start" method="post" enctype="multipart/form-data">
        <p align="center">XML file: </p>
        <p align="center"><input type="file" name="sourceFile" /></p>
        <p align="center">Parser type:
        <input type="radio" name="parserType" value="DOM" checked /> DOM,
        <input type="radio" name="parserType" value="SAX"  /> SAX,
        <input type="radio" name="parserType" value="StAX"  /> StAX. </p><br/>
        <p align="center"><input type="submit" name="button" value="Распарсить"/></p>
    </form>
  </body>
</html>
<%-- <form method="post" action="multiPartServlet" enctype="multipart/form-data"> --%>