angular.module('starter').service('adService', ['$http', function($http){
    return {
        getAdDetails: function(adId) {
          return $http.get(window.location.protocol + '//' + window.location.hostname + ':' + window.location.port + '/get/ad/' + adId);
        },

        postAdDetails: function(id, email, title, description) {
          return $http.post(window.location.protocol + '//' + window.location.hostname + ':5000' + '/post/ad/' + id + '/' + email + '/' + title + '/' + description);
        }
    };
}]);
