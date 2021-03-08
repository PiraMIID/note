angular.module('app')
.config(function ($routeProvider) {

    $routeProvider
        .when('/user-create', {
            templateUrl: 'app/components/users/create/userCreate.html',
            controller: 'UserCreateController',
            controllerAs: 'ctrl'

        })

        .when('/user-login', {
            templateUrl: 'app/components/users/login/userLogin.html',
            controller: 'UserLoginController',
            controllerAs: 'ctrl'
        })
        .when('/note-create', {
            templateUrl: 'app/components/note/create/noteCreate.html',
            controller: 'NoteCreateController',
            controllerAs: 'ctrl'
        })

        .otherwise({
            redirectTo: '/exams'
        });
});