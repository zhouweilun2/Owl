let currentPage = 1;
let totalPage = 1;
let searchFun = null;

function initPager(func){
    searchFun = func;

    $('.prePageBtn').click(function () {
        if (currentPage <= 1){
            return;
        }
        currentPage--;
        $(".curPageNum").text(currentPage);
        searchFun(currentPage);
    });

    $('.nextPageBtn').click(function () {
        if (currentPage >= totalPage){
            return;
        }
        currentPage++;
        $(".curPageNum").text(currentPage);
        searchFun(currentPage);
    });
}

function onSearchSuc(newTotalPage){
    totalPage = newTotalPage;
    $(".totalPageNum").text(totalPage);
}