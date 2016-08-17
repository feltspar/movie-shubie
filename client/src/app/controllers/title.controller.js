(function() {
  'use strict';

  angular
    .module('movieShubie')
    .controller('TitleListController', TitleListController);

  TitleListController.$inject = ['titleService'];

  function TitleListController(titleService) {
    var titleVm = this;

    init();

    function init() {
      console.log('in TitleListController');

      titleService.getTitles()
        .then(function(data) {
          titleVm.titles = data;
        })
        .catch(function(error) {
          console.log(error);
        });
    }
  }
})();