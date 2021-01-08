function quantityValidate(){
    var quantity = document.forms["product-form"]["quantity"].value;


    if(quantity===''){
        document.getElementById("quantity").style.backgroundColor = "red";
        document.getElementById("quantity-err").innerHTML = "Pole Ilość Sztuk nie może być puste";
        return false;
    }else if(quantity<0){
        document.getElementById("quantity").style.backgroundColor = "red";
        document.getElementById("quantity-err").innerHTML = "Ilość Sztuk nie może być liczbą ujemną";
        return false;
    }else{
        document.getElementById("quantity").style.backgroundColor = "white";
        document.getElementById("quantity-err").innerHTML = "";
        return true;
    }
}

function quantityAndNameValidate(){
    var quantity = document.forms["product-form"]["quantity"].value;
    var name = document.forms["product-form"]["name"].value;
    var flag = true;


    if(!lengthValidate(name)){
        document.getElementById("name").style.backgroundColor = "red";
        document.getElementById("name-err").innerHTML = "Nazwa musi być długości 5 lub więcej.";
        flag = false;
    }else{
        document.getElementById("name").style.backgroundColor = "white";
        document.getElementById("name-err").innerHTML = "";
    }

    if(quantity===''){
        document.getElementById("quantity").style.backgroundColor = "red";
        document.getElementById("quantity-err").innerHTML = "Pole Ilość Sztuk nie może być puste";
        flag = false;
    }else if(quantity<0){
        document.getElementById("quantity").style.backgroundColor = "red";
        document.getElementById("quantity-err").innerHTML = "Ilość Sztuk nie może być liczbą ujemną";
        flag = false;
    }else{
        document.getElementById("quantity").style.backgroundColor = "white";
        document.getElementById("quantity-err").innerHTML = "";
    }


    return flag;
}

function lengthValidate(text){
    var regex = new RegExp(/[\sA-Za-z0-9._-]{5}.*/);

    return regex.test(text);
}