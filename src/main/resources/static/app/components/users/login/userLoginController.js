angular.module('app')
    .constant('LOGIN_ENDPOINT', '/login')
    .service('AuthenticationService', function($http,$rootScope, LOGIN_ENDPOINT) {
        console.log('1');
        // delete $http.defaults.headers.post.Authorization;
        this.authenticate = function(credentials, successCallback, errorCallback) {
            console.log('3');
            var authHeader = {Authorization: 'Basic ' + btoa(credentials.username+':'+credentials.password)};
            var config = {headers: authHeader};
            $http
                .post(LOGIN_ENDPOINT, credentials, config)
                .then(function success(response)  {
                    console.log('value:');
                    console.log(response);
                    // $http.defaults.headers.get.Authorization = authHeader.Authorization;
                    $rootScope.userId = response.data.principal.id;
                    sessionStorage.setItem("user_id", $rootScope.userid);
                    console.log('value:'+ response.data.principal.id);
                    $http.defaults.headers.post.Authorization = authHeader.Authorization;
                    successCallback();
                    localStorage.setItem("JwtToken","xddddddddddddd");
                    console.log($rootScope)
                    sessionStorage.setItem("session_note", $rootScope);
                    sessionStorage.setItem("session_note", $rootScope);

                }, function error(reason) {
                    console.log('Login error');
                    console.log(reason);
                    errorCallback();

                });
        }
        this.logout = function(successCallback) {
            delete $http.defaults.headers.post.Authorization;
            successCallback();
        }
    })
    .controller('AuthenticationController', function($routeParams,$http, $rootScope, $location, AuthenticationService) {

        console.log('2');
        var vm = this;
        vm.msg = '';
        vm.credentials = {};
        var loginSuccess = function() {
            console.log('Wtaj przyjacielu mojej kozy! xd')
            $rootScope.authenticated = true;
            // sessionStorage.setItem("au", $rootScope.userid);
            $rootScope.username = vm.credentials.username;
            sessionStorage.setItem("username", $rootScope.username);
            console.log($rootScope.username);

            $location.path('/'+$rootScope.username+'/assets');
        }
        var errorCallback = function () {
            vm.msg = 'WRONG DATA !';
        }
        console.log('22');
        vm.login = function() {
            console.log('sprawdz urzytkownika')
            AuthenticationService.authenticate(vm.credentials, loginSuccess, errorCallback);;

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
