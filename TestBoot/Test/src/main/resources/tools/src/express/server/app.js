var express = require('express');
var path = require('path');
var con = require('./utils/DB/db.js');

const app = express()
app.set('views', path.join(__dirname, '../views'))
app.set('view engine', 'jsx')
app.engine('jsx', require('express-react-views').createEngine())

app.get('/', (req, res) => {
  res.render('App', {headerTitle: 'HeadTitle', contentTitle: 'ContentTitle'})
})

app.get('/user', function(req, res) { 
  con.query("SELECT * FROM USER", (err, results) => {
    if(err) throw error;
    res.send(results);
  });
});

app.listen(4000)
module.exports = app;
