(function() {
  'use strict';

  angular
    .module('movieShubie')
    .controller('LoginController', LoginController)

  LoginController.$inject = ['userService', '$routeParams'];

  function LoginController(userService, $routeParams) {
    var loginVm = this;

    init();

    function init() {
      console.log('in login ctrl');
      loginVm.login = true;
      loginVm.signup = false;
      
      userService
        .getUser([$routeParams.email, $routeParams.password])
        .then(function(data){
          loginVm.user = data;
        }, function(error){
            console.log(error);
        });
  
    }
    
  }

})();
