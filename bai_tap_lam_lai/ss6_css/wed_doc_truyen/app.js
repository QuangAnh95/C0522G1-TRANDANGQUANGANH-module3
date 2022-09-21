var imgFeature = document.querySelector('.img-feature')
var listImg = document.querySelectorAll('.list-img img')
var prevBtn = document.querySelector('prev')
var prevBtn = document.querySelector('next')
var currenIndex = 0;

listImg.forEach((imgElement,index)=>{

    imgElement.addEventListener('click',e=>{
        currenIndex=index
        imgFeature.src=listImg[index].getAttribute('src')
    })
} )