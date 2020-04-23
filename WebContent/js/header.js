/**
 * http://usejsdoc.org/
 */
var searchMore = document.querySelector('.search-more');
var bestItemMore = document.querySelector(".best-item-more");
var searchList =document.querySelector(".search-list");
var itemTitle = document.querySelectorAll(".item-title");
var div = document.createElement("div");
var i =0;
var searchClickFlag=false;


searchMore.addEventListener('click',e=>{
    if(!searchClickFlag){
        bestItemMore.classList.add('search-more-show');
        searchClickFlag=true;
    }else{
        bestItemMore.classList.remove('search-more-show');
        searchClickFlag=false;
    }
})