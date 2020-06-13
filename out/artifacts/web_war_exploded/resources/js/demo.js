function printInputValueToConsole() {
    let inputValue = $("#data-input").val();
    console.log(inputValue);
}

function printSomeDataToConsole() {
    console.log("Random Data");

}

function checkPassword() {
    let password = $(`#password`).val();
    if (password.length === 0) {
        return "*You not entered password"
    }

    // console.log(password);
}

function checkLogin() {
    let login = $(`#login`).val();
    if (login.length === 0) {
        return "*You not entered login";
    }

}


function replaceWithInputData() {
    let inputValue = $("#data-input").val();
    $("#displayed-data").text(inputValue);
}

function sendInputDataToServer() {
    let username=$("#username").val();
    console.log(username);
    let password=$("#password").val();
    $.ajax({
        url: '/login',
        method: 'POST',
        data: JSON.stringify({
            login:username,
            password:password
        })

    }).done(data=> {
        console.log(data);
        if(data==null)
        $("#displayed-data").text("Wrong login or password. Try again");

    });
}