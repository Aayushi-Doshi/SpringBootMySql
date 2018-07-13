<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head><title>Spring Boot CRUD</title>
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>
</head>
<body>

    <h2>HTML Table</h2>

    <table>
      <tr>
          <th>ID</th>
          <td>${list.id}</th>
      </tr>
      <tr>
          <th>First Name</th>
          <td>${list.firstName}</th>
      </tr>
      <tr>
          <th>Last Name</th>
          <td>${list.lastName}</th>
      </tr>
    </table>

    <a href="/" >Back</a>
</body>
</html>
