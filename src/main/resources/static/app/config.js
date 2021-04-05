// const {decode} = require("iconv-lite");
angular.module('app')
    .config(function ($routeProvider, $httpProvider) {
        $routeProvider
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
                templateUrl: 'app/components/assets/note/edit/editNote.html',
                controller: 'NoteController',
                controllerAs: 'ctrl'
            })
            .when('/note/new', {
                templateUrl: 'app/components/assets/note/create/noteCreate.html',
                controller: 'NoteController',
                controllerAs: 'ctrl'
            })
            .when('/:username/assets', {
                templateUrl: 'app/components/assets/asset/list/assetList.html',
                controller: 'AssetListController',
                controllerAs: 'ctrl'
            })
            .otherwise({
                redirectTo: '/login',
            });
        $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
        $httpProvider.defaults.headers.common["jwt"] =  localStorage.getItem("JwtToken");
        console.log('config');
        // checkToken();

    })
    .run(['$http', '$rootScope',
    function($http, $rootScope) {
        console.log('config1');
        var token = localStorage.getItem("JwtToken");
        if(token) {
            $http.get('./api/token').then(function(resp){
                // $http.defaults.headers.jwt = jwt.token;
                console.log('config12 : ' + token);
                console.log('siema');
            });
        }
    }
]);

//     console.log('im here :D');
//     var jwt = localStorage.getItem('id_token');
//
// $http({
//     method: 'GET',
//     url: 'api/token',
//     params: {token: jwt}
// }).then(function (response) {
//     var config = {header: {authorization: 'Bearer ' + jwt}};
//     console.log('im here :D');
//     $rootScope.userId = response.data.userId;
//     $rootScope.username = response.data.username;
//     $rootScope.authenticated = true;
//     $location.path('/' + $rootScope.username + '/assets');
//
//
// }, function (error) {
//     console.log('error token' + error);
//
// })}
//
// );





