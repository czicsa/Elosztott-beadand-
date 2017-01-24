app.controller("newCtrl", function($scope, $http, $window) {
    var init = function () {

    };

    $scope.car = {
        type : "",
        numberOfWheels : 0,
        isNew : false,
        vehicleType : "car"
    };
    
    $scope.save = function () {
        $http.post('newcar', $scope.car).then(
            // successful
            function() {
                $window.location.href = "/list";
            },
            // unsuccessful
            function() {
                alert("Hiba történt!");
            });
    }
    init();
});