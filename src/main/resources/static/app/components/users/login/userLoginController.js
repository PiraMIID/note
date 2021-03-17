angular.module('app')
    .controller('AuthenticationController', function ($rootScope, $location, AuthenticationService) {
        var vm = this;
        vm.credentials = {};
        var loginSuccess = function () {
            // $rootScope.authenticated = true;
            $location.path('/asset/list');
        }
        vm.login = function () {
            AuthenticationService.authenticate(vm.credentials, loginSuccess);
        }
    //todo: put AuthenticationService.logout(logoutSuccess); fix problem with logout
        var logoutSuccess = function () {
           AuthenticationService.logout(logoutSuccess);
           $rootScope.authenticated = false;
           $location.path('/');}

           vm.logout = function () {
            AuthenticationService.logout(logoutSuccess);
        }
    });


// angular.module('app');
// .controller('AuthenticationController', function ($rootScope, $location, AuthenticationService) {
//     var vm = this;
//     vm.credentials = {};
//     var loginSuccess = function () {
//         $rootScope.authenticated = false;
//         $location.path('/asset/list');
//     }
//     vm.login = function () {
//         AuthenticationService.authenticate(vm.credentials, loginSuccess);
//     }
//     //todo: put AuthenticationService.logout(logoutSuccess); fix problem with logout
//     var logoutSuccess = function () {
//         AuthenticationService.logout(logoutSuccess);
//         $rootScope.authenticated = true;
//         $location.path('/');
//     }
//     vm.logout = function () {
//         AuthenticationService.logout(logoutSuccess);
//     }
// });
