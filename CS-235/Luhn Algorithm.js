function Luhn(value){
	
	boolean even = false;
	
	for (var i = value.length - 1; i >= 0; i--){
		var check = value.charAt(n),
			n = parseInt(check, 10);
		
		if (even && n = n*2 > 9){
			n = n - 9;
		}
		check = check + n;
		even = !even;
	}
	return (check % 10) == 0;
}

document.getElementById("CreditCard").onsubmit = function(){
	var result = Luhn(Number);
	if result == true{
		alert("Valid");
	}
	else{
		alert("Invalid");
	}
	return result;
}