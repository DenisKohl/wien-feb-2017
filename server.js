var express = require('express');

var app = express();

app.get('/', function (req, res) {
	res.send('<html><head></head><body><h1>Hello World</h1></body></html>');
});
app.get('/json', function (req, res) {
	res.header("Access-Control-Allow-Origin", "*");
	res.header("Access-Control-Allow-Headers", "X-Requested-With");
	setTimeout(function(){
		var obj = { name:"Hans", beruf: "Maurer Meister"};
		json = JSON.stringify(obj);
		res.set("Content-Type", "application/json");
		res.send(json);
	},2000);
	
});

app.get('/form',function(req, res){
	var t = req.query.test;
	console.log(req.route + " param:" + t);
	res.send('<html><head></head><body><h1>'+t+'</h1></body></html>');
});
app.get('/res',function(req, res){
	console.log("Empfange: " + req.body);
	res.send('<html><head></head><body><h3>ergebnis</h3></body></html>');
});


var server = app.listen(30000, function () {
  
  var host = server.address().address
  var port = server.address().port

  console.log("Example app listening at http://%s:%s", host, port)

})