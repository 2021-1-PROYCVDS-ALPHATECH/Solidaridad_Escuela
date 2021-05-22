function test(value){
    alert(value);
}
function openPopup(){
    document.getElementById("overlay").classList.add("active");
    if(document.getElementById("sol").value != document.getElementById("user").value){
        document.getElementById("overlay").classList.add("active");
    }
}

document.getElementById("close-popup").addEventListener('click', function(event){
    document.getElementById("overlay").classList.remove("active");
    event.preventDefault();
});