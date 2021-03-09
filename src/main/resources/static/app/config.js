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
        .when('/panel-main', {
            templateUrl: 'app/components/panel/main/mainPanel.html',
            controller: 'PanelMainController',
            controllerAs: 'ctrl'
        })
        .when('/panel-edit', {
            templateUrl: 'app/components/panel/edit/editPanel.html',
            controller: 'PanelEditController',
            controllerAs: 'ctrl'
        })
        .when('/panel-main', {
            templateUrl: 'app/components/panel/show/showPanel.html',
            controller: 'PanelMainController',
            controllerAs: 'ctrl'
        })
        .otherwise({
            redirectTo: '/panel-main'
        });
});