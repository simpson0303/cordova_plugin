var exec = require('cordova/exec');
module.exports = {
 	show : function(option) {
        if(!option)option = {"countTime":"10000"};
         cordova.exec(null, null, 'CountDownDialog', 'show', [option]);
     },
     hide : function(success, fail) {
         cordova.exec(success, fail, 'CountDownDialog', 'hide', [ "","" ]);
     }
 };
