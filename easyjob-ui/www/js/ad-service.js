angular.module('starter').service('adService', ['$http', function($http) {
    return {
        getAdDetailsById: function(adId) {
            return $http.get(window.location.protocol + '//' + window.location.hostname + ':5000' + '/get/ad/' + adId);
        },

        getAdDetailsByTitle: function(title) {
            return $http({
                method: 'GET',
                url: window.location.protocol + '//' + window.location.hostname + ':5000' + '/get/ad/' + title,
            });
        },

        postAdDetails: function(email, title, description, fee, lat, lon) {

        var ad = {"email": email, "title": title, "description": description, "fee": fee, location: { "lat": lat, "lon": lon}}

            return $http({
                method: 'POST',
                url: window.location.protocol + '//' + window.location.hostname + ':5000' + '/post/ad',
                headers: {"Content-Type": undefined},
                data: JSON.stringify(ad)
            });
        }
    };
}]);
