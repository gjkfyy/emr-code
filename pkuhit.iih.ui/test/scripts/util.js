/**
 * common
 */

'use strict';

var fs   = require("fs"),
    path = require('path');

/**
 * create a random  string
 * @param  {Number} customSize string size
 * @return {String}            random string
 */
exports.createRdStr = function (customSize) {
    var date = new Date();
    return date.getTime();
};

/**
 * Wraps the object with an array if its not an array.
 * @param  {Object} objectOrArray the object to wrap, or array.
 * @param  {Object} def           the default value to be returned if objectOrArray is falsy. (default `[]`)
 * @return {Array}                the output array or "def".
 */
exports.asArray = function (objectOrArray, def) {
    if (!objectOrArray) {
        return def || [];
    }
    return Array.isArray(objectOrArray) ? objectOrArray : [objectOrArray];
};

/**
 * checks if the given argument is empty ({} or []).
 * @param  {Object}  objectOrArray the object or array to check.
 * @return {Boolean}               true if empty ({} or []), false otherwise.
 */
exports.isEmpty = function (objectOrArray) {
    return !objectOrArray || (Array.isArray(objectOrArray) ? objectOrArray : Object.keys(objectOrArray)).length === 0;
};

/**
 * test if is empty object
 * @param  {Object}  obj
 * @return {Boolean}
 */
exports.isEmptyObject = exports.isEmpty;

/**
 * test if is object
 * @param  {Object}  obj [description]
 * @return {Boolean}     [description]
 */
exports.isObject = function (obj) {
    return typeof obj === "object";
};

/**
 * replace Json Comments
 * @param  {String} content Json content
 * @return {String}         result
 */
exports.replaceJsonComments = function (content) {
    if (!content) return '';
    return content.replace(/\".+?\"|\'.+?\'/g, function (s) {
        return s.replace(/\/\//g, '@_@');
    }).replace(/\s*?\/\/.*?[\n\r]|[\t\r\n]/g, '').replace(/@_@/g, '//');
};

/**
 * parse JSON
 * @param  {String} content
 * @return {Object}
 */
exports.parseJSON = function (content) {
    content = exports.replaceJsonComments(content);
    try {
        return JSON.parse(content);
    } catch (e) {
        return null;
    }
};

/**
 * read json file sync
 * @param  {String} file file path
 * @return {Object}      json object
 */
exports.readJsonSync = function (file) {
    var content = fs.readFileSync(file, 'utf8');
    return exports.parseJSON(content);
};

/**
 * format date object to string
 * @param  {Object} date date object
 * @param  {String} fmt  format string
 * @return {String}      result string
 * example: dateFormat(new Date(), "yyyy-MM-dd hh:mm:ss")
 */
exports.dateFormat = function (date, fmt) {
    var o = {
        "M+": date.getMonth() + 1, //月份
        "d+": date.getDate(), //日
        "h+": date.getHours(), //小时
        "m+": date.getMinutes(), //分
        "s+": date.getSeconds(), //秒
        "q+": Math.floor((date.getMonth() + 3) / 3), //季度
        "S": date.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (date.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
};

/**
 * sync two object propertys
 * @param  {object}   source     source object
 * @param  {object}   tmpl     tmpl object
 * @param  {function} callback 
 */
exports.syncObject = function (source, tmpl, callback) {
    var syncAble = false, j, i;
    
    for (j in tmpl) {
        if (source[j] === undefined) {
            source[j] = tmpl[j];
            syncAble = true;
        } else {
            if (exports.isObject(source[j])) {
                for (i in tmpl[j]) {
                    if (source[j][i] === undefined) {
                        source[j][i] = tmpl[j][i];
                        syncAble = true;
                    }
                }
            }
        }
    }
    
    return syncAble;
}

/**
 * Clone Object
 * @param  {object} obj source object
 * @return {object}     new object
 */
exports.clone = function (obj) {
    try {
        return JSON.parse(JSON.stringify(obj));
    } catch (e) {
        return null;
    }
}

/**
 * parse version string
 * @param  {string} version version string
 * @return {number}         version num
 */
exports.parseVersion = function (version) {
    var numList = version.split('.'),
        versionNum = 0,
        multiple = 100;

    for (var i = 0; i < 3; i++) {
        if (numList[i] !== undefined) {
            versionNum += numList[i] * multiple;
            multiple = multiple / 10;
        }
    }

    return versionNum;
}