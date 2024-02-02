document.getElementById("p3").innerHTML = "Steve";

document.getElementById("roll").onclick = function(){
	var num = Math.floor(Math.random()*10);
	document.getElementById("p3").innerHTML=num;
};