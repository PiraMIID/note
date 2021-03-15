angular.module('app')
.config(function ($routeProvider, $httpProvider) {
    $routeProvider
        .when('/', {
            templateUrl: "app/index.html",
            controller: 'HomeController',
            constructor: 'ctrl'

        })
        .when('/reject', {
            templateUrl: 'app/components/users/create/userReject.html',
            controller: 'UserCreateController',
            controllerAs: 'ctrl'
        })
        .when('/login', {
            templateUrl: 'app/components/users/login/userLogin.html',
            controller: 'AuthenticationController',
            controllerAs: 'authController'
        })
        .when('/asset/list', {
            templateUrl: 'app/components/panel/main/mainPanel.html',
            controller: 'AssetController',
            controllerAs: 'ctrl'
        })
        .when('/note/edit', {
            templateUrl: 'app/components/note/edit/editNote.html',
            controller: 'NoteController',
            controllerAs: 'ctrl'
        })
        .when('/note/new', {
            templateUrl: 'app/components/note/create/noteCreate.html',
            controller: 'NoteController',
            controllerAs: 'ctrl'
        })
        .otherwise({
            redirectTo: '/login',

        })
    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
})
    .constant('LOGIN_ENDPOINT', '/login')
    .constant('LOGOUT_ENDPOINT', '/logout')
    .constant('HOME_ENDPOINT', '/')
    .controller('App', function ($rootScope) {
        if($rootScope.authenticated) {
            $rootScope.authenticated = false;
        }

    })
    .controller('HomeController',function ($http, $rootScope) {$rootScope.authenticated = false;})
    .service('AuthenticationService', function($http ,LOGIN_ENDPOINT, LOGOUT_ENDPOINT, $rootScope) {
        this.authenticate = function(credentials, successCallback) {
            var authHeader = {Authorization: 'Basic ' + btoa(credentials.username+':'+credentials.password)};
            var config = {headers: authHeader};
            $http
                .post(LOGIN_ENDPOINT, {}, config)
                .then(function success(value) {
                    successCallback();
                    $rootScope.userName = credentials.username;
                    $rootScope.userId = credentials.id;
                    console.log('jestem tu')
                    console.log('jestem tus')
                }, function error(reason) {
                    console.log('Login error');
                    console.log(reason);
                });
        }
        this.logout = function(successCallback) {
            $http.post(LOGOUT_ENDPOINT)
                .then(successCallback());
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
    })
    .controller('HomeController', function($rootScope) {
        var vm = this;
        console.log(vm.authenticated);
        console.log(3+1);
        if (!$rootScope.authenticated.includes) {
            $rootScope.authenticated = false;
        }
    })
;

