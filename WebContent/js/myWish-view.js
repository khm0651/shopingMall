/**
 * http://usejsdoc.org/
 */
var button = document.querySelectorAll("button");

for(var i = 0; i<button.length; i++){
	button[i].addEventListener("click",(e)=>{
		var f = confirm("정말 취소 하시겠습니까?");
		if(f){
			location.href="./deleteWish?pid="+e.target.name;
		}
		
	})
}