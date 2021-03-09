// angular.module('app')
// .constant('USER_ENDPOINT', '/api/users/:id')
// .constant('USER_ASSIGNMENTS_ENDPOINT', '/api/users/:id/assignments')
// .factory('User', function($resource, USER_ENDPOINT, USER_ASSIGNMENTS_ENDPOINT) {
//     return $resource(USER_ENDPOINT, { id: '@_id' }, {
//         update: {
//             method: 'PUT'
//         },
//         getAssignments: {
//             method: 'GET',
//             url: USER_ASSIGNMENTS_ENDPOINT,
//             params: {id: '@id'},
//             isArray: true
//         }
//     });
// })
// .service('UserService', function(Exam) {
//     this.getAll = params => Exam.query(params);
//     this.get = index => Exam.get({id: index});
//     this.getAssignments = index => Exam.getAssignments({id: index});
//     this.save = user => user.$save();
//     this.update = user => user.$update({id: user.id})
// });