function chechLogin(){
    const userId = sessionStorage.getItem("userId");
    console.log(userId)
    if (!userId){
        window.location.href = "/logins.html";
    }
}