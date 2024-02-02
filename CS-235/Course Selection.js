
var course = [
['CS','CS125'],
['CS','CS135'],
['CS','CS215'],
['CS','CS245'],
['DS','DS100'],
['DS','DS230'],
['DS','DS315'],
['MTH','MTH135'],
['MTH','MTH145'],
['MTH','MTH215'],
['STA','STA100'],
['STA','STA110'],
['STA','STA310']


];
function buildSubjects() {
	var subjList = document.getElementById("Subjects")
	subjList.length  = 0;
	var used = {};
	for (var i = 0; i < course.length; i++){
		var subj = course[i][0];
		if (used[subj] != subj){
			opt = new Option(subj); 
			subjList.add(opt, null);
			used[subj] = subj;
		}
	}
	setModel();
}


function setClass(){
	var ClassList = document.getElementById("Class")
	ClassList.length = 0;
	Subject = document.getElementById("Subjects").value;
	for (var i = 0; i < course.length; i++){
		if (Subject == course[i][0]){
			opt = new Option(course[i][1]); 
			ClassList.add(opt, null);
		}
	}
}

document.getElementById("Subjects").onchange = setClass