/**
 * http://usejsdoc.org/
 */

var Iimg = document.querySelector(".input-img");
var img = document.createElement("img");
img.classList.add("product-img");
var writeImg = document.querySelector(".write-img");

Iimg.onchange = (e)=>{
	var fileReader = new FileReader();
	if(e.target.files[0] != null){
		fileReader.readAsDataURL(e.target.files[0]);
	}else{
		if(document.querySelector(".product-img") != null){
			writeImg.firstElementChild.remove();
		}
	}
	
	fileReader.onload = (e)=>{
		writeImg.append(img);
		img.src = e.target.result;
	}
}