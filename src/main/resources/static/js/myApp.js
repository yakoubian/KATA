

var app=angular.module("myBanqueApp", []);


app.controller("myBanqueController", function($scope, $http) {
	$scope.compte=null;
	$scope.codeCompte=null;
	$scope.operation={type:"versement", montant:0}
	$scope.pageOperations=[];
	$scope.pageCourante=0;
	$scope.pageSize=3;
	$scope.pages=[];
	$scope.cpte1;
	$scope.cpte2;
	$scope.errorMessage=null;
	
	$scope.chargerCompte=function(){
		$scope.pageCourante=0;
		$http.get("/comptes/"+$scope.codeCompte)
		.success(function(data){
			console.log(data);
			$scope.compte=data;
			$scope.chargerOperations();
		})
		.error(function(data){
			console.log(data);
			$scope.errorMessage=data.message;
			$scope.compte=null;
		})
		;
	};
	
	$scope.chargerOperations=function(){
		$scope.errorMessage=null;
		$http.get("/operations?codeCompte="+$scope.codeCompte+"&page="+$scope.pageCourante+"&size="+$scope.pageSize)
		.success(function(data) {
			console.log(data);
			$scope.pageOperations=data;
			$scope.pages= new Array(data.totalPages)
		});
	};
	
	$scope.goToPage=function(p){
		$scope.pageCourante=p;
		$scope.chargerOperations();
	}
	
	$scope.saveOperation=function(){
		
		var params="";
		if($scope.operation.type=='virement'){
			params="cpte1="+$scope.codeCompte+"&cpte2="+$scope.operation.cpte2+"&montant="+$scope.operation.montant+"&codeEmp=1"
		} else{
			params="code="+$scope.codeCompte+"&montant="+$scope.operation.montant+"&codeEmp=1"
		}
		
		$http({
			method: 'PUT',
			url: $scope.operation.type,
			data: params,
			headers: {'Content-Type': 'application/x-www-form-urlencoded'} 
		})
		.success(function(data){
			$scope.chargerCompte();
			$scope.chargerOperations();
		})
		.error(function(data){
			$scope.errorMessage=data.message;
		})
		;
	};
	
	
	
});
