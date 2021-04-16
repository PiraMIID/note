angular.module('app')
    .constant('LOGIN_ENDPOINT', '/login')
    .service('AuthenticationService', function($http,$rootScope, LOGIN_ENDPOINT) {
        console.log('1');
        // delete $http.defaults.headers.post.Authorization;
        this.authenticate = function(credentials, successCallback, errorCallback) {
            console.log('3');
            // var authHeader = {Authorization: 'Basic ' + btoa(credentials.username+':'+credentials.password)};
            // var config = {headers: authHeader};
            $http
                .post(LOGIN_ENDPOINT, credentials)
                .then(function success(response)  {
                    console.log('value:');
                    console.log(response);
                    // $http.defaults.headers.get.Authorization = authHeader.Authorization;
                    // $rootScope.userid = response.data.principal.id;
                    // console.log('value:'+ response.data.principal.id);
                    console.log(response.headers().authorization);
                    localStorage.setItem('jwt', response.headers().authorization);
                    $http.defaults.headers.common["Authorization"] = response.headers().authorization;
                    successCallback();

                }, function error(reason) {
                    console.log('Login error');
                    console.log(reason);
                    errorCallback();

                });
        }
        // this.logout = function(lo) {
        //     delete $http.defaults.headers.post.Authorization;
        //     logoutCallback();
        // }
    })
    .controller('AuthenticationController', function($routeParams,$http, $rootScope, $location, AuthenticationService) {
        console.log('2');
        var vm = this;
        vm.msg = '';
        vm.credentials = {};
        var loginSuccess = function() {
            console.log('Wtaj przyjacielu mojej kozy! xd')
            $rootScope.authenticated = true;
            $rootScope.username = vm.credentials.username;
            localStorage.setItem('username', $rootScope.username);
            console.log($rootScope.username);
            $location.path('/'+$rootScope.username+'/assets');
        }
        var errorCallback = function () {
            vm.msg = 'WRONG DATA !';
        }
        console.log('22');
        vm.login = function() {
            console.log('sprawdz urzytkownika')
            AuthenticationService.authenticate(vm.credentials, loginSuccess, errorCallback);

        }
        var logoutSuccess = function() {
            $rootScope.authenticated = false;

        }
        vm.logout = function() {
            AuthenticationService.logout(logoutSuccess);
            // delete $http.defaults.headers.post.Authorization;
            $rootScope.authenticated = false;
            localStorage.clear();
            console.log('im in log out')
            console.log('logout');
        }
        console.log('23');


    });
