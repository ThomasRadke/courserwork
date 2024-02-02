function notBlank(id, message){
	field = document.getElementById(id)
	if (field.value == ""){
		alert(message +" is required")
		return false;
	}
return true;
}	

document.getElementById("MailingList").onsubmit = function(){
	var result = true;
	result = result && notBlank("fname", "First Name")
	result = result && notBlank("lname", "Last Name")
	result = result && notBlank("Phone", "Phone")
	result = result && notBlank("email", "email")
	
	return result;
}