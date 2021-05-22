function changeVisibility(estado){
    if(estado == "Valida"){
        document.getElementById("Categories:registerComm").classList.add("active");
        document.getElementById("Categories:registerCommLabel").classList.add("active");
    }else{
        document.getElementById("Categories:registerComm").classList.remove("active");
        document.getElementById("Categories:registerCommLabel").classList.remove("active");
    }
}