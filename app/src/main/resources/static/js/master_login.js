let signInButton = document.getElementById('sign-in-button');

let phoneNumberField = document.getElementById('phone-number-field');
let passwordField = document.getElementById('password-field');

let errorField = document.getElementById('login-error');

let xhr = new XMLHttpRequest();
let loginPageUrl = "http://localhost:8080/app/user/master/login";
let masterPageUrl = "http://localhost:8080/app/user/master/id";

signInButton.onclick = function () {
    xhr.open("POST", loginPageUrl, true);
    xhr.setRequestHeader("Content-Type", "application/json");
    var phoneNumber = phoneNumberField.value;
    var password = passwordField.value;
    var data = JSON.stringify({
        "masterPhoneNumber": phoneNumber,
        "masterPassword": password,
   });
    xhr.send(data);
}

xhr.onreadystatechange = function () {
    console.log(xhr.readyState);
    console.log(xhr.status);
    if (xhr.readyState === 4 && xhr.status === 200) {
        var json = JSON.parse(xhr.responseText);
        masterPageUrl = masterPageUrl.replace("id", json.masterId);
        window.location.replace(masterPageUrl);
    }
    if (xhr.readyState === 4 && xhr.status === 400) {
        errorField.innerText = "Invalid data";
    }
};