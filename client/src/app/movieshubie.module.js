// Code goes here

(function() {
  'use strict';

  angular
    .module('movieShubie', ['ngRoute'])
    .config(moduleConfig)
    .run(moduleRun);

  moduleRun.$inject = [];

  function moduleRun() {
    console.log('App Initiated');
  }

  moduleConfig.$inject = ['$routeProvider'];

  function moduleConfig($routeProvider) {
    $routeProvider.when('/titles', {
        templateUrl: 'titles-grid.tmpl.html',
        controller: 'TitleListController',
        controllerAs: 'titleVm'
      })
      .when('/login', {
        templateUrl: 'login.tmpl.html',
        controller: 'LoginController',
        controllerAs: 'loginVm'
      })
      .when('/title-detail/:id', {
        templateUrl: 'title-detail.tmpl.html',
        controller: 'TitleDetailController',
        controllerAs: 'titleDetailVm'
      })
      .when('/movies', {
        templateUrl: 'titles-grid.tmpl.html',
        controller: 'MovieListController',
        controllerAs: 'titleVm'
      })
      .when('/series', {
        templateUrl: 'titles-grid.tmpl.html',
        controller: 'SeriesListController',
        controllerAs: 'titleVm'
      })
      .when('/rating', {
        templateUrl: 'titles-grid.tmpl.html',
        controller: 'RatingController',
        controllerAs: 'titleVm'
      })
      .when('/year', {
        templateUrl: 'titles-grid.tmpl.html',
        controller: 'YearController',
        controllerAs: 'titleVm'
      })
      .when('/user', {
        templateUrl: 'user.tmpl.html',
        controller: 'UserController',
        controllerAs: 'userVm'
      })
      .otherwise({
        redirectTo: "/login" //change to default
      });
  }

})();