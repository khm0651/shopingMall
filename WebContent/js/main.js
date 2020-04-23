/**
 * http://usejsdoc.org/
 */

var bestItem = document.querySelectorAll('.best-item');
var newItem = document.querySelectorAll('.new-item');
var body = document.querySelector('body');
var searchClickFlag = false;
var isShowBest = isShowNew = false;

body.style.overflowX="hidden";

document.addEventListener('scroll',e=>{
    
    if(window.scrollY>=100){
    	if(!isShowBest){
    		for(var i=0; i<bestItem.length;i++){
                bestItem[i].classList.add("show");
                bestItem[i].addEventListener("click",sendView);
            }
    		isShowBest=true;
    	}
        
    }
    
    if(window.scrollY>700){
    	if(!isShowNew){

    		for(var i=0; i<newItem.length;i++){
                newItem[i].classList.add("show");
                newItem[i].addEventListener("click",sendView);
            }
    		isShowNew=true;
    	}

    }
})

sendView = (e ) => {
	e.toElement.offsetParent.submit();
}
