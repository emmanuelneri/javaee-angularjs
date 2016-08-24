var app = angular.module('pessoaController', []);

app.controller('listarPessoas', function ($scope, $http) {
    $http.get('http://localhost:8080/javaee-angularjs/ws/pessoa/listar').then(function(response) {
        $scope.pessoas = response.data;
    });
});

app.controller('pessoaForm', function($scope, $http) {
    $scope.pessoa = {nome:'', cpf:''};

    $scope.salvar = function() {
        $http.post('http://localhost:8080/javaee-angularjs/ws/pessoa/cadastrar', $scope.pessoa)
        .error(function(response){
            $scope.erros = response;
        })
    }
});

app.filter('cpf', function(){
    return function(cpf){
        return cpf.substr(0, 3) + '.' + cpf.substr(3, 3) + '.' + cpf.substr(6, 3) + '-' + cpf.substr(9,2);
    };
});