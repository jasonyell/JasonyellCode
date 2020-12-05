
function onload(ev){
    // 由用户点击 button， 我们发起 ajax
    let xhr = new XMLHttpRequest();
    xhr.open("get","/api/article-list.json");
    // 使用匿名函数
    xhr.onreadystatechange = function (ev) {
        if (xhr.readyState == XMLHttpRequest.DONE) {    // ajax 请求完成时
            if (xhr.status == 200) {                    // http 请求是 200 时

                let articleList = JSON.parse(xhr.responseText);   // 按照 JSON 格式解析
                console.log(articleList);

                // 把得到的结果 放到 html 中
                let articleListElement = document.querySelector("#article-list");    // html 输出的标签

                if(articleList.length > 0){
                    articleListElement.innerHTML = "";

                    for(let i in articleList){
                        let article = articleList[i];

                        let html = "<li>" +
                            // 这个中括号的用法，就类似 java 中 map.get("id"); 的用法
                            "<a href=\"/article?id=" + article["id"] + "\">" +
                            article["title"] +
                            "</a>" + article["published_at"] + " </li>";

                        console.log(html);
                        articleListElement.innerHTML += html;    // 把拼接好的 HTML，放入标签中
                    }

                }
            }
        }
    };
    xhr.send();
}

window.onload(onload);