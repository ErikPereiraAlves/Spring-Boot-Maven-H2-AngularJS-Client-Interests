var app = angular.module('bank',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: '<a class="vglnk" href="http://localhost:8080/bank" rel="nofollow"><span>http</span><span>://</span><span>localhost</span><span>:</span><span>8080</span><span>/</span><span>bank</span></a>',
    PRODUCT_SERVICE_API : '<a class="vglnk" href="http://localhost:8080/bank/api/v1/users/" rel="nofollow"><span>http</span><span>://</span><span>localhost</span><span>:</span><span>8080</span><span>/</span><span>bank</span><span>/</span><span>api</span><span>/</span><span>v1</span><span>/</span><span>users<span>/</span></a>'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('users', {
                url: '/users',
                templateUrl: 'users.html',
                controller:'UserController',
                controllerAs:'ctrl',
                resolve: {
                    users: function ($q, userService) {
                        console.log('Load all users');
                        var deferred = $q.defer();
                        userService.loadAllUsers().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });



        $urlRouterProvider.otherwise('/');
    }]);