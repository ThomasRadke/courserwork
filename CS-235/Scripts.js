
document.getElementById("p2").innerHTML = "Steve";

document.getElementById("random").onclick = function(){
	var num = Math.floor(Math.random()*10);
	document.getElementById("p2").innerHTML=num;
};

document.getElementById("f2c").onclick=function(){
	var f =document.getElementById("temp").value;
	var result = document.getElementById("p2");
	result.innerHTML =(f-32)/ 1.8;
	
};