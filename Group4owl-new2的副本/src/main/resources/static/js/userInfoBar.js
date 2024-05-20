function initUserInfoBar(){
    const userName = sessionStorage.getItem('username');
    const userType = sessionStorage.getItem('user_type');
    console.log(userName)
    $(".userInfoBarUserName").text(userName);
    $(".userInfoBarUserType").text(userType);
    $(".logoutBtn").click(function () {
        sessionStorage.removeItem('userId')
        sessionStorage.removeItem('username')
        sessionStorage.removeItem('user_type')
        window.location.href = "/index.html";
    });
}