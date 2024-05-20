function onMenuItemClick(items, that){
    items.removeClass("menuItemActive");
    that.addClass("menuItemActive")
    const val = that.attr("value");
    if (val === "user"){
        if (curPageName !== "user"){
            window.location.href = "/user.html";
        }
    }
    else if (val === "main"){
        if (curPageName !== "main"){
            window.location.href = "/index.html";
        }
    }
    else {
        if (curPageName !== "message"){
            window.location.href = "/message.html";
        }
    }
}