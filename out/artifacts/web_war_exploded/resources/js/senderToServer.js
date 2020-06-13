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

        if(data==null)
            $("#displayed-data").text("Wrong login or password. Try again");
        else {
            //document.cookie="currentUser="+data;
            sessionStorage.setItem('currentUser',data);
            document.location.href="/game-list";

        }
    });
}