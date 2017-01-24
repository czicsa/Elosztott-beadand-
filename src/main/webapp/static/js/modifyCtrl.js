app.controller("modifyCtrl", ['$scope', '$http', '$window', '$location', '$mdToast', '$timeout', 'api', function($scope, $http, $window, $location, $mdToast, $timeout, api) {
    var init = function () {
        var params = $location.search();
        api.getCarById(params.carId).then(
            // successful
            function(response) {
                $scope.car = response.data;
            },
            // unsuccessful
            function(response) {
                alert("Hiba történt!");
            });
    };

    $scope.save = function () {
        api.modifyCar($scope.car).then(
            // successful
            function() {
                $mdToast.show(
                    $mdToast.simple()
                        .textContent('Sikeres mentés!')
                        .hideDelay(1000)
                );
                $timeout(function() { $window.location.href = "/list";}, 1000);
            },
            // unsuccessful
            function() {
                $mdToast.show(
                    $mdToast.simple()
                        .textContent('Hiba történt!')
                        .hideDelay(1000)
                );
            });
    };
    init();
}]);