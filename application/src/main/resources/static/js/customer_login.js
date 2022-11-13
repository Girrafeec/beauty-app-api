let signInButton = document.getElementById('sign-in-button');

let phoneNumberField = document.getElementById('phone-number-field');
let passwordField = document.getElementById('password-field');

let errorField = document.getElementById('login-error');

let xhr = new XMLHttpRequest();
let loginPageUrl = "http://localhost:8080/app/user/customer/login";
let customerPageUrl = "http://localhost:8080/app/user/customer/id";

signInButton.onclick = function () {
    xhr.open("POST", loginPageUrl, true);
    xhr.setRequestHeader("Content-Type", "application/json");
    var phoneNumber = phoneNumberField.value;
    var password = passwordField.value;
    var data = JSON.stringify({
        "customerPhoneNumber": phoneNumber,
        "customerPassword": password,
   });
    xhr.send(data);
}

xhr.onreadystatechange = function () {
    console.log(xhr.readyState);
    console.log(xhr.status);
    if (xhr.readyState === 4 && xhr.status === 200) {
        var json = JSON.parse(xhr.responseText);
        customerPageUrl = customerPageUrl.replace("id", json.customerId);
        window.location.replace(customerPageUrl);
    }
    if (xhr.readyState === 4 && xhr.status === 400) {
        errorField.innerText = "Invalid data";
    }
};