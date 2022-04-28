var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function (req, res, next) {
  res.render('index', { title: 'Express' });
});

router.get('/api', function (req, res) {
  res.status(200).json({
    success: true
  });
});

router.get('/post',function(req,res){
  const message=req.body.message;
  res.status(200).json(
    {
      "message":message
    }
  )
})

module.exports = router;
