import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @program: 2020-08-12-网络-HTTP协议-博客系统
 * @description
 * @author: JasonYell
 * @create: 2020-10-12 01:16
 **/
public class FastJSONDemo {
    public static void main(String[] args) {
        JSONObject object = new JSONObject();
        JSONObject author = new JSONObject();

        author.put("id",139);
        author.put("nickname","鲁迅");

        object.put("id", 18);
        object.put("标题", "轮雷峰塔的倒掉");
        object.put("作者", author);
        object.put("published_at", "2020-07-13 18:79:38");



        JSONArray array = new JSONArray();
        //array.add(object);
        array.add(object.clone());
        System.out.println(array.toJSONString());

    }
}
