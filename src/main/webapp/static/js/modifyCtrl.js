app.controller("modifyCtrl", function($scope, $http, $window, $location) {
    var init = function () {
        var params = $location.search();
        $http.get('getCarById/' + params.carId ).then(
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
        $http.post('modifycar', $scope.car).then(
            // successful
            function() {
                $window.location.href = "/list";
            },
            // unsuccessful
            function() {
                alert("Hiba történt!");
            });
    };
    init();
});