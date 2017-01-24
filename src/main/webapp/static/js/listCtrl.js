app.controller("listCtrl", function($scope, $http, $window) {
    var init = function () {
        $http.get('getCars').then(
            // successful
            function(response) {
                $scope.cars = response.data;
            },
            // unsuccessful
            function(response) {
                alert("Hiba történt!");
            });
    };

    $scope.newCar = function () {
        $window.location.href = "/newcar";
    };

    $scope.modifyCar = function (car) {
        $window.location.href = "/modifycar?carId=" + car.id;
    };

    init();
});