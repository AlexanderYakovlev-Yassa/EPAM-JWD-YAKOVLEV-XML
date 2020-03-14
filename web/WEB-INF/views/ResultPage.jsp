
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page errorPage="ErrorPage.jsp"%>

<html>
  <head>
    <title>Result page</title>
      <style>
          table, th, td {
              border: 1px solid black;
              padding: 5px;
          }
          table {
              border-spacing: 0px;
          }
      </style>
  </head>
  <body>
    <p align="right">Java Web Development course Task XML parser and WEB</p><br/>
    <h1 align="center">XML parser</h1>
    <h3 align="center">Result of parsing:</h3>

    <table align="center">
        <tr>
            <th align="left" >Table 1 - Untreated gems</th>
        </tr>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>preciousness</th>
            <th>origin</th>
            <th>value</th>
            <th>color</th>
            <th>purchaseDate</th>
        </tr>

            <c:forEach var = "set" items="${untreatedGemResultSet}" begin = "0" end = "${untreatedGemCount}">
        <tr>
            <td><c:out value = "${set.id}"/></td>
            <td><c:out value = "${set.name}"/></td>
            <td><c:out value = "${set.preciousness}"/></td>
            <td><c:out value = "${set.origin}"/></td>
            <td><c:out value = "${set.value}"/></td>
            <td><c:out value = "${set.color}"/></td>
            <td><c:out value = "${set.purchaseDate.toInstant()}"/></td>
        </tr>
        </c:forEach>

    </table>
    <br/>
    <table align="center">
        <tr>
            <th align="left" >Table 2 - Treated gems</th>
        </tr>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>preciousness</th>
            <th>origin</th>
            <th>value</th>
            <th>color</th>
            <th>translucency</th>
            <th>facetsCount</th>
            <th>purchaseDate</th>
        </tr>

        <c:forEach var = "set" items="${treatedGemResultSet}" begin = "0" end = "${treatedGemCount}">
            <tr>
                <td><c:out value = "${set.id}"/></td>
                <td><c:out value = "${set.name}"/></td>
                <td><c:out value = "${set.preciousness}"/></td>
                <td><c:out value = "${set.origin}"/></td>
                <td><c:out value = "${set.value}"/></td>
                <td><c:out value = "${set.color}"/></td>
                <td><c:out value = "${set.translucency}"/></td>
                <td><c:out value = "${set.facetsCount}"/></td>
                <td><c:out value = "${set.purchaseDate.toInstant()}"/></td>

            </tr>
        </c:forEach>

    </table>

  </body>
</html>