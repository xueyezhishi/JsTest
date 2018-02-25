<!DOCTYPE html>
<html lang="en" ng-app="app">
<head>
    <meta charset="UTF-8">
    <title>Get angular's scope in jQuery</title>
    <script src="<%=request.getContextPath()%>/js/ComJs/jquery-1.9.1.js"></script>
    <script src="<%=request.getContextPath()%>/js/ComJs/angularJs/angular.min.js"></script>
    <script>
    //功能：通过外部调用，获取control中内容
        angular.module('app',[])
                .controller('listController',['$scope', function ($scope) {
                    $scope.list = [1,2,3,4,5];
                    $scope.test = function () {
                        console.log('test');
                    }
                }])

        $(document).on('ready', function () {
            var controllerScope = $('body[ng-controller="listController"]').scope();  // Get controller's scope
            controllerScope.test(); // log 'test'
            function abc(){
                console.log("121") 
            }
        })       
                
        function abc(){
          console.log("121") 
        }
    </script>

</head>
<body ng-controller="listController">
<div >
    <ul>
        <li ng-repeat="item in list"><button>Select {{item}}</button></li>
    </ul>
</div>
</body>
</html>