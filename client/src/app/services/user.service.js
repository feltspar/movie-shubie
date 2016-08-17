(function() {
  'use strict';

  angular
    .module('movieShubie')
    .service('userService', userService);

  userService.$inject = ['$http', '$q'];

  function userService($http, $q) {
    var self = this;

    self.getUser = getUser;

    function getUser(emailid, pass) {
      
      return $http.get('http://localhost:8080/spring-rest/api/user')
        .then(successFn, errorFn);
    }
    
     function successFn(response) {
      return response.data; //RESOLVE
    }

    function errorFn(response) {
      return $q.reject(error.status); //REJECT
    }

  }
})();