angular.module('app')
.constant('PANEL_NAMES_ENDPOINT', '/api/panel-main')
    .factory('Note')
.service('PanelService', function($resource, PANEL_ENDPOINT) {
    this.getAllNames = () => $resource(PANEL_ENDPOINT).query();
});