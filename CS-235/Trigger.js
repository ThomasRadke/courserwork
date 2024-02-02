
function noSubmit(component){
	var sbmt = document.getElementById("btnSubmit");
	if (component.value  != ""){
		sbmt.disabled = false;	
	}
	else{
		sbmt.disabled = true;
	}
}

document.getElementById("someData").onchange = function(){
	sbmt = document.getElementById("btnSubmit");
	noSubmit(this);
}


