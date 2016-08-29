var app = angular.module('javaeeAngular', [])
    .controller('PessoaController', ['$scope', '$http', PessoaController]);

function PessoaController($scope, $http) {
    iniciarPessoa();
    listar($scope, $http);

    $scope.salvar = function() {
        $http.post('http://localhost:8080/javaee-angularjs/ws/pessoa/cadastrar', $scope.pessoa)
            .success(function (data) {
                iniciarPessoa();
                listar($scope, $http);
            })
            .error(function(response){
                $scope.erros = response;
            });
    };

    $scope.editar = function(pessoa) {
        $scope.pessoa = pessoa;
    };

    function iniciarPessoa() {
        $scope.pessoa = {nome:'', cpf:''};
    }

    function listar($scope, $http) {
        $http.get('http://localhost:8080/javaee-angularjs/ws/pessoa/listar').then(function(response) {
            $scope.pessoas = response.data;
        });
    };
}

app.filter('cpf', function(){
    return function(cpf){
        return cpf.substr(0, 3) + '.' + cpf.substr(3, 3) + '.' + cpf.substr(6, 3) + '-' + cpf.substr(9,2);
    };
});