'use strict';

const mysql = require('mysql')

let con = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: 'star8903',
    database: 'test',
    port: 3306
});

con.connect();

module.exports = con;


