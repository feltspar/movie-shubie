(function() {
  'use strict';

  angular
    .module('movieShubie')
    .controller('TitleDetailController', TitleDetailController);

  TitleDetailController.$inject = ['titleService', '$routeParams'];

  function TitleDetailController(titleService, $routeParams) {
    var titleDetailVm = this;

    init();
    function init() {
      titleService
        .getTitle($routeParams.id)
        .then(function(data) {
          titleDetailVm.title = data;
        }, function(error) {
          console.log(error);
        });
    }
  }

})();