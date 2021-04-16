angular.module('app')
.config(function($routeProvider, $httpProvider) {
    $routeProvider
        .when('/', {
            templateUrl: "app/index.html",
            controller: 'HomeController',
            constructor: 'ctrl'
        })
        .when('/signup', {
            templateUrl: 'app/components/users/create/userSignUp.html',
            controller: 'SignupController',
            controllerAs: 'ctrl'
        })
        .when('/login', {
            templateUrl: 'app/components/users/login/userLogin.html',
            controller: 'AuthenticationController',
            controllerAs: 'ctrl'
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

        });
    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
});


