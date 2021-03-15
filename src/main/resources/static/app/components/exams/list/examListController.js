angular.module('app')
.controller('ExamListController', function (ExamService) {
    const vm = this;
    vm.exams = ExamService.getAll();
    vm.search = text => {
        vm.exams = ExamService.getAll({text})
    }
});