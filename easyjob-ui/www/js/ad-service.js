angular.module('starter').service('adService', ['$http', function($http) {

    $defaultUrl = window.location.protocol + '//' + window.location.hostname + ':5000';

    return {
        getAdDetailsById: function(adId) {
            return $http.get($defaultUrl + '/get/ad/' + adId);
        },

        getAdDetailsByTitle: function(adTitle) {
            return $http.get($defaultUrl + '/get/ad/title/' + adTitle);
        },

        getAdDetailsByCategory: function(adCategory) {
          return $http.get($defaultUrl + '/get/ad/category/' + adCategory)
        },

        postAdDetails: function(email, title, description, fee, lat, lon) {
            return $http.post($defaultUrl + '/post/ad/' + email + '/' + title + '/' + description + '/' + fee + '/' + lat + '/' + lon);
        }
    };
}]);
