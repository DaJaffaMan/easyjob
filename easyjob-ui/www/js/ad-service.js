angular.module('starter').service('adService', ['$http', function ($http) {

  var defaultUrl = window.location.protocol + '//' + window.location.hostname + ':5000';

  return {
    getAdDetailsById: function (adId) {
      return $http({
        method: 'GET',
        url: defaultUrl + '/get/ad/' + adId
      })
    },

    getAdDetailsByTitle: function (title) {
      return $http({
        method: 'GET',
        url: defaultUrl + '/get/ad/' + title
      });
    },

    postAdDetails: function (email, title, description, fee, lat, lon) {

      var ad = {
        "email": email,
        "title": title,
        "description": description,
        "fee": fee,
        location: {"lat": lat, "lon": lon}
      };

      return $http({
        method: 'POST',
        url: defaultUrl + '/post/ad',
        headers: {"Content-Type": undefined},
        data: JSON.stringify(ad)
      });
    }
  };
}]);
