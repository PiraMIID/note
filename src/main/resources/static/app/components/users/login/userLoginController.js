angular.module('app')
    .constant('LOGIN_ENDPOINT', '/login')
    .service('AuthenticationService', function($http, LOGIN_ENDPOINT) {
        console.log('1');
        // delete $http.defaults.headers.post.Authorization;
        this.authenticate = function(credentials, successCallback) {
            console.log('3');
            var authHeader = {Authorization: 'Basic ' + btoa(credentials.username+':'+credentials.password)};
            var config = {headers: authHeader};
            $http
                .post(LOGIN_ENDPOINT, {}, config)
                .then(function success(value) {
                    console.log('value:');
                    console.log(value)
                    $http.defaults.headers.post.Authorization = authHeader.Authorization;
                    successCallback();
                }, function error(reason) {
                    console.log('Login error');
                    console.log(reason);
                });
        }
        this.logout = function(successCallback) {
            delete $http.defaults.headers.post.Authorization;
            successCallback();
        }
    })
    .controller('AuthenticationController', function($http, $rootScope, $location, AuthenticationService) {
        console.log('2');
        var vm = this;
        vm.credentials = {};
        var loginSuccess = function() {
            console.log('Wtaj przyjacielu mojej kozy! xd')
            $rootScope.authenticated = true;

        }
        console.log('22');
        vm.login = function() {
            console.log('sprawdz urzytkownika')
            AuthenticationService.authenticate(vm.credentials, loginSuccess);
        }
        // var logoutSuccess = function() {
        //     $rootScope.authenticated = false;
        //     $location.path('/');
        // }
        // vm.logout = function() {
        //     AuthenticationService.logout(logoutSuccess);
        //     delete $http.defaults.headers.post.Authorization;
        //     $rootScope.authenticated = false;
        //     console.log('logout');
        // }
        console.log('23');


    });
