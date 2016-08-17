(function() {
  'use strict';

  angular
    .module('movieShubie')
    .controller('YearController', YearController);

  YearController.$inject = ['titleService'];

  function YearController(titleService) {
    var titleVm = this;

    init();

    function init() {
      console.log('in YearController');
      var year = 2014;
      titleService.getByYear(year)
        .then(function(data) {
          titleVm.titles = data;
        })
        .catch(function(error) {
          console.log(error);
        });
    }
  }
})();