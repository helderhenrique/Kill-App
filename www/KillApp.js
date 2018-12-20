module.exports = {
    checkAppKilled: function(successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, systemAlertWindowPermissionName, "checkAppKilled", []);
    }
};
