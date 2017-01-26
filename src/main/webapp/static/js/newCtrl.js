app.controller("newCtrl", ['$scope', '$http', '$window', '$mdToast', '$timeout', 'api', function($scope, $http, $window, $mdToast, $timeout, api) {
    var init = function () {

    };

    $scope.car = {
        type : "",
        numberOfWheels : 0,
        isNew : false,
        vehicleType : "car"
    };
    
    $scope.save = function () {
        api.newCar($scope.car).then(
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
            function(response) {
                $mdToast.show(
                    $mdToast.simple()
                        .textContent(response.status == 400 ? 'Validációs hiba történt!' : 'Hiba történt!')
                        .hideDelay(1000)
                );
            });
    }
    init();
}]);