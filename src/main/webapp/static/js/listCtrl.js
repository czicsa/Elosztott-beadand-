app.controller("listCtrl",['$scope', '$http', '$window', 'api', function($scope, $http, $window, api) {
    var init = function () {
        api.getCars().then(
            // successful
            function(response) {
                $scope.cars = response.data;
            },
            // unsuccessful
            function(response) {
                alert("Hiba történt!");
            });;
    };

    $scope.newCar = function () {
        $window.location.href = "/newcar";
    };

    $scope.modifyCar = function (car) {
        $window.location.href = "/modifycar?carId=" + car.id;
    };

    init();
}]);