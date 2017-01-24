var app = angular.module("carApp", ['ngMaterial'], function($locationProvider) {
    $locationProvider.html5Mode({
        enabled: true,
        requireBase: false
    });
}).factory('api', ['$window', '$http', function(win, http) {
    var getCars = function(){
        return http.get('getCars');
    };

    var getCarById = function(id){
        return http.get('getCarById/' + id );
    };

    var newCar = function(car){
        return http.post('newcar', car);
    };

    var modifyCar = function(car) {
        return http.post('modifycar', car);
    };

    return {
        getCars : getCars,
        getCarById : getCarById,
        newCar : newCar,
        modifyCar : modifyCar
    };
}]);


