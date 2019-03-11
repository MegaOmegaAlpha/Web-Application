<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 12.03.2019
  Time: 0:13
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
        <input type="number" name="age" placeholder="Age"/>
        <button type="submit">Search</button>
    </form>
    <a href="/artists/newArtist">Add new artist</a>
    <table border="1">
        <thead>
        <tr>
            <th>Name</th>
            <th>Age</th>
            <th>Songs</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <%
            /*List<Artist> will be handled*/
        %>
        </tbody>
    </table>
</main>
</body>
</html>
