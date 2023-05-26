<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
  <head><title>icc test rankings..</title></head>
  
  <body>
  <div class="container">
  <h1>Test Rankings</h1>
  <a href="rankings" class="btn btn-success"> Home </a>
  
  
  <a href="odi" class="btn btn-success">ODI</a> <a href="t20" class="btn btn-success">T20</a>
  <table class="table">
     <thead>
     	<tr>
      		<th>Team Name</th>
     		<th>Matches</th>
     		<th>Points</th>
     		<th>Rating</th>
     		<th>Update</th>
     	</tr>
     </thead>
     <tbody>
        <c:forEach items="${list}" var="rank" >
        <tr>
          <td>${rank.name}</td>
          <td>${rank.matches}</td>
          <td>${rank.points}</td>
          <td>${rank.rating}</td>
          <td><a href="update?id=${rank.id}" class="btn btn-success">Update</a></td>
        </tr>
        </c:forEach>
     </tbody>
  </table>
  <a href="addteam" class="btn btn-success">Add Team</a>
 </div>
  <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
  </body>

</html>