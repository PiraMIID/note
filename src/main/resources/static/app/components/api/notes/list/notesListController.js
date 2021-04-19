angular.module('app')
    .constant('ASSETS_ASSIGNMENTS_ENDPOINT','/api/notes')
    .factory('Notes', function($resource,$http,$rootScope,  ASSETS_ASSIGNMENTS_ENDPOINT) {
        return $resource(ASSETS_ASSIGNMENTS_ENDPOINT);
    })
    .service('AssetsService', function (Notes) {
        this.getAll = function () {
            return Notes.query();
        }
    })
    .controller('AssetListController',function ($routeParams,$http, $rootScope, $location, AssetsService) {
        var vm = this;
        console.log('AssetListController');
        vm.notes = AssetsService.getAll();
        console.log('notes = ' + vm.notes);
    });
