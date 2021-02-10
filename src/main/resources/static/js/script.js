/**
 * 
 */

document.addEventListener("DOMContentLoaded", function() {
	append(4);
});
function append(num) {
	var something = document.querySelector("#test");
	something.innerHTML = "<input id='MF'></input><br>";
	for(var i = 1; i <= num; i++) {
		var html = "<p><input id='FN" + i +"'></input><input id='LN" + i +"'></input></p>";
		something.innerHTML += html;
	}
}

function hi() {
	
	console.log("whatever i wanna write");
}