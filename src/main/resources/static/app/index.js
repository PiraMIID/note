'use strict';
angular.module('app', ['ngRoute', 'ngResource'])

.controller('app', function($rootScope) {
    $rootScope.authenticatedUser = false;
});

document.getElementById("buttonLogIn").addEventListener('click', event => {
    $rootScope.authenticatedUser = true;
    console.log($rootScope.authenticatedUser);
});
