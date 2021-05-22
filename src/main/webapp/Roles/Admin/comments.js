function changeVisibility(estado){
    if(estado != "Valida"){
        document.getElementById("Categories:Comm").classList.add("active");
        document.getElementById("Categories:CommLabel").classList.add("active");
    }else{
        document.getElementById("Categories:Comm").classList.remove("active");
        document.getElementById("Categories:CommLabel").classList.remove("active");
    }
}