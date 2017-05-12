(function(){
  
    angular.module("myApp").constant("baseUrl", "http://localhost:8089/SpringWithAngularjs/book/");
    
    angular.module("myApp").factory("BookSvc", function($resource, baseUrl){
      return $resource(baseUrl+":id", {}, { update: {method: "PUT", isArray: false}});
    });
})();



