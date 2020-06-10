/**
 * http://usejsdoc.org/
 */
var favForm = document.querySelector(".fav-btn");
var buyForm = document.querySelector(".buy-btn");
var countUp = document.querySelector(".count-btn-up");
var countDown = document.querySelector(".count-btn-down");
var countBox = document.querySelector(".count-box");
var sColor = document.querySelector(".select-color");
var sSize = document.querySelector(".select-size");
var color = document.querySelector(".color");
var size = document.querySelector(".size");
var total = document.querySelector(".total");
var stock = document.querySelector("span");
var write = document.querySelector(".comment-button");
var body = document.querySelector("body");
var exit;
var pid = document.querySelector(".id").innerText;
let deleteComment;
if(document.querySelectorAll(".deleteComment")!= null){
	deleteComment = document.querySelectorAll(".deleteComment");
}
for(let i = 0 ; i<deleteComment.length; i++){
	deleteComment[i].addEventListener("click",e=>{
		e.target.parentElement.submit();
	})
}

sSize.innerText = size.value;
sColor.innerText = color.value;

favForm.addEventListener('click',e=>{
	
	e.target.submit();
})

const MakeComment = (parent) => {
	var form = document.createElement("form");
	var div = document.createElement("div");
	var input = document.createElement("input");
	form.classList.add("input-comment");
	form.action = "./comment";
	form.method = "POST";
	form.acceptCharset="UTF-8";
	div.classList.add("comment-sub-wrapper");
	input.classList.add("write-comment-title");
	input.name="write-comment-title";
	input.placeholder="제목을 입력해주세요.";
	div.append(input);
	var div2 = document.createElement("div");
	div2.classList.add("comment-exit");
	div2.innerText="X";
	div.append(div2);
	form.append(div);
	div = document.createElement("div");
	div.classList.add("comment-sub-wrapper");
	var textarea = document.createElement("textarea");
	textarea.classList.add("write-comment");
	textarea.name="write-comment";
	textarea.placeholder="내용을 입력해주세요";
	input = document.createElement("input");
	input.classList.add("comment-submit");
	input.type="submit";
	input.value="작성 완료";
	div.append(textarea);
	div.append(input);
	form.append(div);
	input = document.createElement("input");
	input.type="hidden";
	input.name="pid";
	input.value=pid;
	form.append(input);
	parent.append(form);
	commentInput=document.querySelector(".input-comment");
	
}
var writeClick = false;

const CloseComment = () =>{
	writeClick = !writeClick;
	if(!writeClick){
		
		commentInput.classList.add("input-close");
		setTimeout(() => {
			body.lastElementChild.remove();
			write.classList.remove("none");
			exit.removeEventListener("click",CloseComment);
			exit =null;
			commentInput=null;
		}, 300);
		
	}
}


write.addEventListener("click",(e)=>{
	writeClick = !writeClick;
	if(writeClick){
		MakeComment(body);
		write.classList.add("none");
		exit=document.querySelector(".comment-exit");
		exit.addEventListener("click",CloseComment);
	}
	
})



buyForm.addEventListener('click',e=>{
	var c = document.querySelector(".color");
	var ic = document.getElementsByName("color")[0];
	var s = document.querySelector(".size");
	var is = document.getElementsByName("size")[0];
	var iCount = document.getElementsByName("count")[0];
	ic.value = c.selectedOptions[0].innerText;
	is.value = s.selectedOptions[0].innerText;
	iCount.value = document.querySelector(".count-box").innerText;
	
	if(parseInt(stock.innerText) - iCount.value <0 ){
		alert("재고가 부족합니다.");
	}else{
		e.target.submit();
	}
	
})

countUp.addEventListener("click",e=>{
	var num = parseInt(countBox.innerText);
	var price = parseInt(document.querySelector(".price").innerText.slice(0,-1));
	countBox.innerText = num+1;
	total.innerText = (price*(num+1)) + " 원";
})

countDown.addEventListener("click",e=>{
	var num = parseInt(countBox.innerText);
	var price = parseInt(document.querySelector(".price").innerText.slice(0,-1));
	countBox.innerText = num-1;
	if(parseInt(countBox.innerText) <=0){
		alert("주문수량은 1개 이상이어야합니다.");
		countBox.innerText = num;
	}else{
		total.innerText = (price*(num-1)) + " 원";
	}
	

})

size.addEventListener("change",e=>{
	sSize.innerText = e.target.value;
})

color.addEventListener("change",e=>{
	sColor.innerText = e.target.value;
})