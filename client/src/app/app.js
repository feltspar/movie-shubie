// Code goes here

(function() {
  'use strict';

  angular
      .module('movieShubie', ['ngRoute'])
      .config(moduleConfig)
      .run(moduleRun);



  moduleConfig.$inject = ['$routeProvider'];
  function moduleConfig($routeProvider) {
    $routeProvider.when('/movies', {
      templateUrl: 'movie-grid.tmpl.html',
      controller: 'MovieListController',
      controllerAs: 'movieVm'
    })
        .when('/login', {
          templateUrl: 'login.tmpl.html',
          controller: 'LoginController',
          controllerAs: 'loginVm'
        })
        .when('/movie-detail/:id', {
          templateUrl: 'movie-detail.tmpl.html',
          controller: 'MovieDetailController',
          controllerAs: 'movieDetailVm'
        })
        .otherwise({
          redirectTo : "/movies"
        });
  }
    moduleRun.$inject = [ngRoute];
    function moduleRun() {
        console.log('App Initiated');
    }

})();