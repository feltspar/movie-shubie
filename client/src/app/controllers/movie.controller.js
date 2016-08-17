(function() {
  'use strict';

  angular
    .module('movieShubie')
    .controller('MovieListController', MovieListController);

  MovieListController.$inject = ['titleService'];

  function MovieListController(titleService) {
    var titleVm = this;

    init();

    function init() {
      console.log('in MovieListController');

      titleService.getMovies()
        .then(function(data) {
          titleVm.titles = data;
        })
        .catch(function(error) {
          console.log(error);
        });
    }
  }
})();