angular.module('app')
    .controller('UserLoginController',function ($scope,$routeParams,UserService) {
        const vm = this;
        vm.user = UserService.getUser();
        $scope.user = vm.user;
    });