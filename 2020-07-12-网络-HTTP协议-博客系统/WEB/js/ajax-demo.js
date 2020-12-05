// 选择器 (Selector) button 的意思，选择所有的 button 的标签
let  buttonElement = document.querySelector("button");


function onclick(ev){
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
                let tbody = document.querySelector("tbody");    // html 输出的标签
                for(let i in articleList){
                    let article = articleList[i];

                    let html = "<te>" +
                        // 这个中括号的用法，就类似 java 中 map.get("id"); 的用法
                        "<td>"+article["id"]+"</td>"+
                        "<td>"+article["title"]+"</td>"+
                        "<td>"+article["published_at"]+"</td>"+
                        "<td>"+article["author"]["id"]+"</td>"+
                        "<td>"+article["author"]["username"]+"</td>"+
                        "</te>";

                    console.log(html);
                    tbody.innerHTML += html;    // 把拼接好的 HTML，放入标签中
                }


            }
        }
    };
    xhr.send();
}

// 如果在 button 这个标签上，发生了 click（点击）事件， 请执行 onclick 函数
// 每次用户点击 button， 就允许  onclick 方法
buttonElement.addEventListener("click",onclick);