(function() {
  'use strict';

  angular
    .module('movieShubie')
    .controller('SeriesListController', SeriesListController);

  SeriesListController.$inject = ['titleService'];

  function SeriesListController(titleService) {
    var titleVm = this;

    init();

    function init() {
      console.log('in SeriesListController');

      titleService.getSeries()
        .then(function(data) {
          titleVm.titles = data;
        })
        .catch(function(error) {
          console.log(error);
        });
    }
  }
})();