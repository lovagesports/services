var queryParams = {};
location.search.substr(1).split("&").forEach(function(item) {
    queryParams[item.split("=")[0]] = item.split("=")[1]
});

var getQueryParam = function(paramKey) {
    return queryParams[paramKey];
};
