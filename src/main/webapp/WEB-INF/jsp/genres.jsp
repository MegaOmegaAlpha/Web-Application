<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 12.03.2019
  Time: 0:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<main>
    <form>
        <input type="text" name="name" placeholder="Name"/>
        <input type="text" name="rating" placeholder="Rating"/>
        <button type="submit">Search</button>
    </form>
    <a href="/songs/newGenre">Add new genre</a>
    <table border="1">
        <thead>
        <tr>
            <th>Name</th>
            <th>Rating</th>
            <th>Songs</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <%
            /*List<Genre> will be handled*/
        %>
        </tbody>
    </table>
</main>
</body>
</html>
