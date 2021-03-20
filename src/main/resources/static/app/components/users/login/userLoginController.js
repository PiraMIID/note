angular.module('app')
    .constant('LOGIN_ENDPOINT', '/login')
    .service('AuthenticationService', function($http, LOGIN_ENDPOINT) {
        console.log('1');
        this.authenticate = function(credentials) {
            console.log('3');
            var authHeader = {Authorization: 'Basic ' + btoa(credentials.username+':'+credentials.password)};
            var config = {headers: authHeader};
            $http
                .post(LOGIN_ENDPOINT, {}, config)
                .then(function success() {
                    $http.defaults.headers.post.Authorization = authHeader.Authorization;
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
    .controller('AuthenticationController', function($rootScope, $location, AuthenticationService) {
        console.log('2');
        var vm = this;
        vm.credentials = {};
        var loginSuccess = function() {
            $rootScope.authenticated = true;
            $location.path('/');
        }
        vm.login = function() {
            AuthenticationService.authenticate(vm.credentials, loginSuccess);
        }
        var logoutSuccess = function() {
            $rootScope.authenticated = false;
            $location.path('/');
        }
        vm.logout = function() {
            AuthenticationService.logout(logoutSuccess);
        }
    });
