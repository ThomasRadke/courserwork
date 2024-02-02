function add(x,y){
	return x+y
}

var myfunc = function(x,y) {return x+y}

doccument.write(myfunc(4,5));

function isPythagoreanTriple(a,b,c){
	var square = function(x) {return x*x};
	
	return square(a) + square(b) == square(c);
}

alert(isPythagoreanTriple(3,4,5));
alert(isPythagoreanTriple(3,4,5));

var five = function(){return 5};
var next = function(curr){return 1 + curr()}
var ans = next(five);
alert(ans);

function boxVolume(dims){
	var w = dims.width  ||1;
	var h = dims.height ||1;
	var d = dims.depth  ||4;
	return w * h * d;
}
alert(boxVolume({width:3,height:2}+);
alert(boxVolume({width:3,height:2,depth:6}));
