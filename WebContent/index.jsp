<!DOCTYPE html>
<html ng-app="myApp">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>CRUD with Angular JS</title>

  <link href="http://bootswatch.com/cosmo/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="style.css">
</head>

<body>
  <div class="container" ng-controller="CoversCtrl">

    <div class="page-header">
      <h1>Book Cart	</h1>
      <button class="btn btn-default" ng-click="openDialog()">Add New Book</button>
    </div>
    <div class="table-responsive">
      <table class="table table-striped table-hover">
      <thead>
        <tr>
          <th>Name</th>
          <th>ISBN NO</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        <tr ng-repeat="book in books">
          <td>{{ book.name }}</td>
          <td>{{ book.isbn }}</td>
          <td>
            <button type="button" class="btn btn-danger" ng-click="removeBook(book)">Delete</button>
            <button type="button" class="btn btn-info" ng-click="editDialog(book)">Edit</button>
          </td>
        </tr>
      </tbody>
    </table>    
    </div>

  </div>
<%-- <script src="${pageContext.request.contextPath}/app-resources/js/lib/angular.min.js"></script>
    <script src="${pageContext.request.contextPath}/app-resources/js/lib/angular-resource.min.js"></script> --%>
      <script src="https://code.angularjs.org/1.2.26/angular.min.js"></script>
  <script src="https://code.angularjs.org/1.2.26/angular-resource.min.js"></script>
	<script src="${pageContext.request.contextPath}/app-resources/js/app.js"></script>	
	<script src="${pageContext.request.contextPath}/app-resources/js/BookSvc.js"></script>
	
	<script src="${pageContext.request.contextPath}/app-resources/js/ui-bootstrap-custom-tpls-0.10.0.min.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-resources/css/style.css"/>
	 

</body>

</html>