angular.module('app')
.config(function ($routeProvider, $httpProvider) {
    $routeProvider
        //User
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
        //notes
        .when('/api/notes',  {
            templateUrl: 'app/components/api/notes/list/notesList.html',
            controller: 'NotesListController',
            controllerAs: 'ctrl'
        })
        .when('/api/notes/edit',  {
            templateUrl: 'app/components/api/notes/edit/notesEdit.html',
            controller: 'NotesEditController',
            controllerAs: 'ctrl'
        })
        .when('/api/notes/create',  {
            templateUrl: 'app/components/api/notes/create/notesCreate.html',
            controller: 'NotesCreateController',
            controllerAs: 'ctrl'
        })
        //note
        .when('/api/note',  {
            templateUrl: 'app/components/api/note/list/noteList.html',
            controller: 'NoteListController',
            controllerAs: 'ctrl'
        })
        .when('/api/note/:id/edit',  {
            templateUrl: 'app/components/api/note/edit/noteEdit.html',
            controller: 'NoteEditController',
            controllerAs: 'ctrl'
        })
        .when('/api/note/create',  {
            templateUrl: 'app/components/api/note/create/noteCreate.html',
            controller: 'NoteCreateController',
            controllerAs: 'ctrl'
        })
        //todoo
        .when('/api/todo',  {
            templateUrl: 'app/components/api/todo/list/todoList.html',
            controller: 'todoListController',
            controllerAs: 'ctrl'
        })
        .when('/api/todo/edit',  {
            templateUrl: 'app/components/api/todo/edit/todoEdit.html',
            controller: 'todoEditController',
            controllerAs: 'ctrl'
        })
        .when('/api/todo',  {
            templateUrl: 'app/components/api/todo/create/todoCreate.html',
            controller: 'todoCreateController',
            controllerAs: 'ctrl'
        })
        .when('/api/username',{})
        .otherwise({
            redirectTo: '/login',
        });
    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
    console.log('config');
    var jwt = localStorage.getItem('jwt');

    if(jwt!=null) {
        $httpProvider.defaults.headers.common["Authorization"] = jwt;

    }


})
    .run(function($rootScope) {
        var jwt = localStorage.getItem('jwt');
        if(jwt!==null) {
            console.log('tu jestem ! ');
            $rootScope.authenticated = true;
            $rootScope.username = localStorage.getItem('username');
        }
    });



