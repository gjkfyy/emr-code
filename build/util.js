'use strict';

var fs   = require("fs"),
    path = require('path');

exports.replaceJsonComments = function (content) {
    if (!content) return '';
    return content.replace(/\".+?\"|\'.+?\'/g, function (s) {
        return s.replace(/\/\//g, '@_@');
    }).replace(/\s*?\/\/.*?[\n\r]|[\t\r\n]/g, '').replace(/@_@/g, '//');
};

exports.parseJSON = function (content) {
    content = exports.replaceJsonComments(content);
    try {
        return JSON.parse(content);
    } catch (e) {
        return null;
    }
}; 

exports.readJsonSync = function (file) {
    var content = fs.readFileSync(file, 'utf8');
    return exports.parseJSON(content);
};

exports.removeDir = function(dir) {
    if(fs.existsSync(dir)) {
        fs.readdirSync(dir).forEach(function(file, index){
            var current = dir + '/' + file;
            if(fs.lstatSync(current).isDirectory()) {
                exports.removeDir(current);
            }
            else {
                fs.unlinkSync(current);
            }
        });
        fs.rmdirSync(dir);
    }
};


function copyFile( src, dst ){
    // 读取目录中的所有文件/目录
    fs.readdir( src, function( err, paths ){
        if( err ){
            throw err;
        }
        paths.forEach(function( path ){
            var _src = src + '/' + path,
                _dst = dst + '/' + path,
                readable, writable;       
            fs.stat( _src, function( err, st ){
                if( err ){
                    throw err;
                }
                // 判断是否为文件
                if( st.isFile() ){
                    // 创建读取流
                    readable = fs.createReadStream( _src );
                    // 创建写入流
                    writable = fs.createWriteStream( _dst );   
                    // 通过管道来传输流
                    readable.pipe( writable );
                }
                // 如果是目录则递归调用自身
                else if( st.isDirectory() ){
                    existsFile( _src, _dst, copyFile );
                }
            });
        });
    });
};

function existsFile( src, dst, callback ){
    fs.exists( dst, function( exists ){
        // 已存在
        if( exists ){
            callback( src, dst );
        }
        // 不存在
        else{
            fs.mkdir( dst, function(){
                callback( src, dst );
            });
        }
    });
};

exports.copy = copyFile;

exports.exists = existsFile;