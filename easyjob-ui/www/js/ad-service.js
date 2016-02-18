angular.module('starter').service('adService', ['$http', function($http){
    return {
        getAdDetailsById: function(adId) {
          return $http.get(window.location.protocol + '//' + window.location.hostname + ':5000' + '/get/ad/' + adId);
        },

        getAdDetailsByTitle: function(adTitle) {
                  return $http.get(window.location.protocol + '//' + window.location.hostname + ':5000' + '/get/ad/title/' + adTitle);
                },

        postAdDetails: function(email, title, description, fee, lat, lon) {
          return $http.post(window.location.protocol + '//' + window.location.hostname + ':5000' + '/post/ad/' + email + '/' + title + '/' + description + '/' + fee + '/'  + lat + '/'  + lon);
        }
    };
}]);
