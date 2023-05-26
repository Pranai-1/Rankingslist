<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
<head><title>update ranks...</title></head>
<body>

	<div class="container">
	
	<h1>Update the Team
</h1>
	
		
		    <form:form method = "post" modelAttribute="team"> 
    
         <fieldset class="mb-3">
           <form:label path="matches">Matches</form:label>
           <form:input type = "number"  path="matches" required="required"/>
           
    </fieldset>
          <fieldset class="mb-3">
           <form:label path="points">Points</form:label>
           <form:input type = "number"  path="points" required="required"/>
           
    </fieldset>
    <fieldset class="mb-3">
           <form:label path="rating">Rating</form:label>
           <form:input type = "text"  path="rating" required="required"/>
           
    </fieldset>
          <form:input type = "hidden" path = "name" /> 
          <form:input type = "hidden" path = "id" />
          <input type = "submit" class = "btn btn-success"/>
    </form:form>
			</div>
	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>