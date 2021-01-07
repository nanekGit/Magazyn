function registerValidate(){
    var login = document.forms["register-form"]["login"].value;
    var pass = document.forms["register-form"]["pass"].value;
    var pass2 = document.forms["register-form"]["pass2"].value;

    //Minimum 5 znaków z zakresów A-Z a-z 0-9, a potem byle co
    var regex = new RegExp(/[A-Za-z0-9._-]{5}.*/);
    var flag = true;


    if(!regex.test(login)){
        document.getElementById("login").style.backgroundColor = "red";
        document.getElementById("login-err").innerHTML = "Login musi być długości 5 lub więcej.";
        flag = false;
    }else{
        document.getElementById("login").style.backgroundColor = "white";
        document.getElementById("login-err").innerHTML = "";
    }


    if(!regex.test(pass)){
        document.getElementById("pass").style.backgroundColor = "red";
        document.getElementById("pass-err").innerHTML = "Hasło musi być długości 5 lub więcej.";
        flag = false;
    }else{
        document.getElementById("pass").style.backgroundColor = "white";
        document.getElementById("pass-err").innerHTML = "";
    }


    if(!regex.test(pass2)){
        document.getElementById("pass2").style.backgroundColor = "red";
        document.getElementById("pass2-err").innerHTML = "Powtórzone Hasło musi być długości 5 lub więcej.";
        flag = false;
    }else{
        document.getElementById("pass2").style.backgroundColor = "white";
        document.getElementById("pass2-err").innerHTML = "";
    }


    if(pass!==pass2){
        document.getElementById("pass").style.backgroundColor = "red";
        document.getElementById("pass2").style.backgroundColor = "red";
        document.getElementById("equal-err").innerHTML = "Powtórzone Hasło i Hasło muszą być takie same.";
        flag = false;
    }else if(flag){
        document.getElementById("pass").style.backgroundColor = "white";
        document.getElementById("pass2").style.backgroundColor = "white";
        document.getElementById("equal-err").innerHTML = "";
    }else{
        document.getElementById("equal-err").innerHTML = "";
    }


    return flag;
}