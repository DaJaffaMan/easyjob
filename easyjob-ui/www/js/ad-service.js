angular.module('starter').service('adService', ['$http', function($http){
    return {
        getAdDetailsById: function(adId) {
          return $http.get(window.location.protocol + '//' + window.location.hostname + ':' + window.location.port + '/get/ad/' + adId);
        },

        getAdDetailsByTitle: function(adTitle) {
                  return $http.get(window.location.protocol + '//' + window.location.hostname + ':' + window.location.port + '/get/ad/title/' + adTitle);
                },

        postAdDetails: function(id, email, title, description) {
          return $http.post(window.location.protocol + '//' + window.location.hostname + ':5000' + '/post/ad/' + id + '/' + email + '/' + title + '/' + description);
        }
    };
}]);
