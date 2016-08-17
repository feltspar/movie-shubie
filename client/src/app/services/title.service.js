(function() {
  'use strict';

  angular
    .module('movieShubie')
    .service('titleService', titleService);

  titleService.$inject = ['$http', '$q'];

  function titleService($http, $q) {
    var self = this;

    //available functions
    self.getTitles = getTitles;
    self.getTitle = getTitle;
    self.getMovies = getMovies;
    self.getSeries = getSeries;
    self.getByRating = getByRating;
    self.getByYear = getByYear;
    

    function getTitles() {
      return $http.get('http://localhost:8080/spring-rest/api/titles')
        .then(successFn, errorFn);
    }
    
    function getMovies() {
      return $http.get('http://localhost:8080/spring-rest/api/titles/type/movie')
        .then(successFn, errorFn);
    }
    
    function getSeries() {
      return $http.get('http://localhost:8080/spring-rest/api/titles/type/series')
        .then(successFn, errorFn);
    }
    
    function getByRating() {
      return $http.get('http://localhost:8080/spring-rest/api/titles/imdbrating')
        .then(successFn, errorFn);
    }
    
     function getByYear(year) {
      return $http.get('http://localhost:8080/spring-rest/api/titles/year'+year)
        .then(successFn, errorFn);
    }
    
    function getTitle(id){
      return $http.get('http://localhost:8080/spring-rest/api/titles/'+ id)
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