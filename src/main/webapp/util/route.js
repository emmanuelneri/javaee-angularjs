angular.module('javaeeAngular', ['ngRoute', 'ngMessages'])
    .config(function($routeProvider) {

        $routeProvider
            .when('/', {
                templateUrl : '/pages/pessoa.html',
                controller: 'PessoaController'
            })

            .when('/sobre', {
                templateUrl : '/pages/sobre.html'
            })

            .otherwise({
                redirectTo: '/'
            });
});