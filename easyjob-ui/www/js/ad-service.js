angular.module('starter').service('adService', ['$http', function($http){
    return {
        getAdDetails: function(adId) {
          return $http.get(window.location.protocol + '//' + window.location.hostname + ':' + window.location.port + '/get/ad/' + adId);
        },

        postAdDetails: function(adId, email, adTitle, adDescription) {
          return $http.post(window.location.protocol + '//' + window.location.hostname + ':' + window.location.port + '/post/ad/' + adId + '/' + email + '/' + adTitle + '/' + adDescription);
        }
    };
}]);
