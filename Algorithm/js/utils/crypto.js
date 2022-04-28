const crypto = require('crypto');

console.log(crypto.createHash('sha256').update('test').digest('hex'));
