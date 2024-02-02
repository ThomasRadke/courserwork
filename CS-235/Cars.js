

var hybrids = [
['Toyota','Prius'],
['Hyundai','Elantra'],
['Toyota','Camry'],
['Toyota','Avalon'],
['Honda','Insight'],
['Honda','Clarity'],
['Hyundai','Ioniq'],
['BMW','Series 5'],
['BMW','330e'],
['Hyundai','Sonata'],
['Lexus','ES']
];

function buildMakes() {
	var makeList = document.getElementById("carMakes")
	makeList.length  = 0;
	var used = {};
	for (var i = 0; i < hybrids.length; i++){
		var make = hybrids[i][0];
		if (used[make] != make){
			opt = new Option(make); 
			makeList.add(opt, null);
			used[make] = make;
		}
	}
	setModel();
}


function setModel(){
	var modelList = document.getElementById("carModels")
	modelList.length = 0;
	make = document.getElementById("carMakes").value;
	for (var i = 0; i < hybrids.length; i++){
		if (make == hybrids[i][0]){
			opt = new Option(hybrids[i][1]); 
			modelList.add(opt, null);
		}
	}
}

document.getElementById("carMakes").onchange = setModel




