module.exports = {
    checkAppKilled: function(successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "KillApp", "checkAppKilled", []);
    }
};
