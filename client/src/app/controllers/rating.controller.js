(function() {
  'use strict';

  angular
    .module('movieShubie')
    .controller('RatingController', RatingController);

  RatingController.$inject = ['titleService'];

  function RatingController(titleService) {
    var titleVm = this;

    init();

    function init() {
      console.log('in RatingController');

      titleService.getByRating()
        .then(function(data) {
          titleVm.titles = data;
        })
        .catch(function(error) {
          console.log(error);
        });
    }
  }
})();