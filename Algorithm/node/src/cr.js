var im = require('imagemagick');
require('child_process').spawn(command, args=[], [options]);
im.resize({
    srcPath: 'youtube.png',
    dstPath: 'node-small.png',
    width: 256
 }, function(err, stdout, stderr) {
    if(err) throw err
    console.log('resized image to fit within 256 x 256px');
 });