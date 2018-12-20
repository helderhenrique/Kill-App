module.exports = {
    checkAppKilled: function(args, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "KillApp", "checkAppKilled", [args]);
    }
};
