angular.module('app')
    .constant('ASSETS_ASSIGNMENTS_ENDPOINT','/:username/assets')
    .factory('Assets', function($resource,  ASSETS_ASSIGNMENTS_ENDPOINT) {
        return $resource(ASSETS_ASSIGNMENTS_ENDPOINT);
    })
    .service('AssetsService', function (Assets) {
        this.getAll = function () {
            return Assets.query();
        }
    })
.controller('AssetListController',function (AssetsService) {
        var vm = this;
        vm.assets = AssetsService.getAll();
});
