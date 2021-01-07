function quantityValidate(){
    var quantity = document.forms["register-form"]["quantity"].value;

    var flag = true;

    if(quantity===''){
        document.getElementById("quantity").style.backgroundColor = "red";
        document.getElementById("quantity-err").innerHTML = "Pole Ilość sztuk nie może być puste";
        flag = false;
    } else if(quantity<0){
        document.getElementById("quantity").style.backgroundColor = "red";
        document.getElementById("quantity-err").innerHTML = "Ilość sztuk nie może być liczbą ujemną";
        flag = false;
    }else{
        document.getElementById("quantity").style.backgroundColor = "white";
        document.getElementById("quantity-err").innerHTML = "";
    }

    return flag;
}

function quantityAndNameValidate(){
    var quantity = document.forms["register-form"]["quantity"].value;
    var name = document.forms["register-form"]["name"].value;

    var regex = new RegExp(/[\sA-Za-z0-9._-]{5}.*/);
    var flag = true;


    if(!regex.test(name)){
        document.getElementById("name").style.backgroundColor = "red";
        document.getElementById("name-err").innerHTML = "Nazwa musi być długości 5 lub więcej.";
        flag = false;
    }else{
        document.getElementById("name").style.backgroundColor = "white";
        document.getElementById("name-err").innerHTML = "";
    }

    if(quantity===''){
        document.getElementById("quantity").style.backgroundColor = "red";
        document.getElementById("quantity-err").innerHTML = "Pole Ilość sztuk nie może być puste";
        flag = false;
    } else if(quantity<0){
        document.getElementById("quantity").style.backgroundColor = "red";
        document.getElementById("quantity-err").innerHTML = "Ilość sztuk nie może być liczbą ujemną";
        flag = false;
    }else{
        document.getElementById("quantity").style.backgroundColor = "white";
        document.getElementById("quantity-err").innerHTML = "";
    }

    return flag;
}