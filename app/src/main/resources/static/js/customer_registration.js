let signUpButton = document.getElementById('sign-up-button');

let phoneNumberField = document.getElementById('phone-number-field');
let passwordField = document.getElementById('password-field');
let confirmPasswordField = document.getElementById('confirm-password-field');
let firstNameField = document.getElementById('first-name-field');
let lastNameField = document.getElementById('last-name-field');

let errorField = document.getElementById('registration-error');

let xhr = new XMLHttpRequest();
let registrationUrl = "http://localhost:8080/app/user/customer/registration";
let loginPageUrl = "http://localhost:8080/app/user/customer/login";

signUpButton.onclick = function () {
    xhr.open("POST", registrationUrl, true);
    xhr.setRequestHeader("Content-Type", "application/json");
    var phoneNumber = phoneNumberField.value;
    var password = passwordField.value;
    var firstName = firstNameField.value;
    var lastName = lastNameField.value;
    var data = JSON.stringify({
        "customerPhoneNumber": phoneNumber,
        "customerPassword": password,
        "customerFirstName": firstName,
        "customerLastName": lastName
   });
    xhr.send(data);
}

xhr.onreadystatechange = function () {
    console.log(xhr.readyState);
    console.log(xhr.status);
    if (xhr.readyState === 4 && xhr.status === 200) {
        window.location.replace(loginPageUrl);
    }
    if (xhr.readyState === 4 && xhr.status === 400) {
        errorField.innerText = "User with same phone number already exists";
    }
};