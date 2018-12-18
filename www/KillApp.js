var exec = require('cordova/exec');

exports.checkAppKilled = function (arg0, success, error) {
    exec(success, error, 'KillApp', 'checkAppKilled', [arg0]);
};
