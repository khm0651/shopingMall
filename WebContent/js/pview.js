/**
 * http://usejsdoc.org/
 */
var form = document.querySelectorAll('form');

sendView = (e ) => {
	e.toElement.offsetParent.submit();
}

for(var i = 0 ; i<form.length; i++){
	form[i].addEventListener("click",sendView);
}
var timeout = [];

for(let i = 0 ; i<form.length; i++){
	timeout.push(setTimeout(()=>{
		form[i].classList.add("form-show");
	}, 200*i));
}

window.onbeforeunload = function(e){
	for(let i=0; i<form.length; i++){
		clearTimeout(timeout[i]);
	}
	console.log("finish clear");
    
}

