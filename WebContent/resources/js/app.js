(function() {
  angular.module("myApp", ['ui.bootstrap','ngResource']);

  angular.module("myApp").controller("CoversCtrl", function($scope, BookSvc, $modal) {
    $scope.books = BookSvc.query();
    
    $scope.openDialog = function() {
      var modalInstance = $modal.open({
        templateUrl: 'addbook.html',
        controller: ModalInstanceCtrl
      });

      modalInstance.result.then(function (newBook) {
        $scope.books.push(newBook);
      }, function () {
        console.log('Modal dismissed at: ' + new Date());
      });

    };
    
    $scope.editDialog = function(book){
      var modalInstance = $modal.open({
        templateUrl: 'editbook.html',
        controller: EditBookCtrl,
        resolve: {
        oldBook: function () {
          return book;
        }
       }
      });

      // modalInstance.result.then(function (newBook) {

      //   $scope.books.push(newBook);
      // }, function () {
      //   console.log('Modal dismissed at: ' + new Date());
      // });
    }
    
    $scope.removeBook = function(book) {
      BookSvc.remove(book, function(res) {
        $scope.books.splice($scope.books.indexOf(book), 1);
      });

    };
  });
  
  var ModalInstanceCtrl = function ($scope, $modalInstance, BookSvc) {

  $scope.addBook = function (formData) {

    BookSvc.save(formData, function(res){
      $modalInstance.close(res); 
    });
   
  };

  $scope.cancel = function () {
    $modalInstance.dismiss('cancel');
  };
};

  var EditBookCtrl = function ($scope, $modalInstance, oldBook, BookSvc) {
  $scope.formData = oldBook;

  $scope.updateBook = function(){
	 /*  var postingsResource = $resource('http://localhost:8080/SpringWithAngularjs/person/:id', { id: '3'});
       postingsResource.delete();*/
       
  BookSvc.update(JSON.stringify($scope.formData), function(res){
    $modalInstance.close(res); 
  });
   
  };


  $scope.cancel = function () {
    $modalInstance.dismiss('cancel');
  };
};
  
})();