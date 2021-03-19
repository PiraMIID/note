angular.module('app')
    .constant('LOGIN_ENDPOINT', '/login')
    .service('AuthenticationService', function(value, $http, LOGIN_ENDPOINT) {
        this.authenticate = function(credentials, successCallback) {
            var authHeader = {Authorization: 'Basic ' + btoa(credentials.username+':'+credentials.password)};
            var config = {headers: authHeader};
            // var value = value;
            $http
                .post(LOGIN_ENDPOINT, {}, config)
                .then(function success(value) {
                    $http.defaults.headers.post.Authorization = authHeader.Authorization;
                    successCallback("sight");
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
        var vm = this;
        vm.credentials = {};
        var loginSuccess = function() {
            $rootScope.authenticated = true;
            $location.path('/new');
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

