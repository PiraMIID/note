angular.module('app')
    .controller('UserCreateController',function (User) {
        const vm = this;
        vm.$scope.user = User;
});