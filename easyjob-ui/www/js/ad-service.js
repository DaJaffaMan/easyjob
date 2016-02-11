angular.module('starter').service('ad-service', ['$http', function($http){
    return {
        getAdDetails: function(adId) {
          return $http.get(window.location.protocol + '//' + window.location.hostname + ':' + window.location.port + '/get/ad/' + adId);
        }
    };
}]);
