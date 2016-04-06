var app = angular.module('pessoaController', []);

app.controller('listarPessoas', function ($scope, $http) {
    $http.get('http://localhost:8080/javaee-angularjs/ws/pessoa/listar').then(function(response) {
        $scope.pessoas = response.data;
    });
});