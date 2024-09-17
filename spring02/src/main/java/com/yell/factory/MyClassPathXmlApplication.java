package com.yell.factory;

import com.sun.org.apache.xml.internal.resolver.readers.SAXCatalogReader;
import com.yell.po.MyBean;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.XPath;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 工厂接口 实现类
 *      1，获取解析的配置文件
 *      2. 解析配置文件（dom4j），将解析好的 bean 标签设置到对应的 bean 对象中， 再讲bean对象设置到集合中
 *      3. 得到几何中的 bean 对象，并将对应的id 与其实例化好的 bean 设置到 map 中
 */
public class MyClassPathXmlApplication implements MyFactory {

    private List<MyBean> beanList = null; // 解析好的 bean 标签集合
    private Map<String, Object> beanMap = new HashMap<String, Object>();    // 实例化好的 bean 对象

    /*
        获取配置文件
     */
    // 通过带参构造，传递需要解析的配置文件
    public MyClassPathXmlApplication(String fileName) {

        // 解析配置文件 将结果设置到 List 中
        this.parseXml(fileName);

        // 实例化Bean 对象  将结果设置到 map 中
        this.instanceBean();

    }

    /**
     * 实例化 bean 对象
     *      得到对应 bean 对象中的 id 与 clazz
     *      通过 class 属性值（类路径），得到对应的实例化对象
     *      将 id 和 实例化的对象分别设置到 map 的键值对中
     */
    private void instanceBean() {

        // 判断制定bean对象的集合是否存在
        if (beanList != null && beanList.size() > 0) {
            //遍历
            for (MyBean myBean : beanList) {

                try {
                    // 键
                    String id = myBean.getId();
                    // 值（实例化好的对象 通过class的值得到实例化对象)
                    Object object  = Class.forName(myBean.getClazz()).newInstance();
                    // 设置map
                    beanMap.put(id, object);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    /**
     * 解析 xml文件
     * 引入 dom4j 与 xpath的依赖
     * @param fileName
     */
    private void parseXml(String fileName) {
        // 获取解析器
        SAXReader saxReader = new SAXReader();
        // 得到要解析的配置文件的 url
        URL url = this.getClass().getClassLoader().getResource(fileName);

        try {
            // 解析配置文件，返回 Document 对象
            Document document = saxReader.read(url);
            // 通过 xpath得到 想要解析的标签(beans标签下的所有bean标签)
            XPath xPath = document.createXPath("beans/bean");
            // 通过xpath语法获取要解析的指定元素
            List<Element> elementsList = xPath.selectNodes(document);
            // 判断标签集合是否存在
            if (elementsList != null && elementsList.size() > 0) {
                // 实例化集合
                beanList = new ArrayList<MyBean>();
                // 遍历集合
                for (Element el : elementsList) {
                    // 获取元素的id属性值和 class属性值
                    String id = el.attributeValue("id");
                    String clazz = el.attributeValue("class");
                    // 将 id 和  clazz的 值设置到对应的 bean 对象中
                    MyBean myBean = new MyBean(id, clazz);
                    // 将对应的bean对象设置到集合中
                    beanList.add(myBean);
                }
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }

    /**
     * 通过 id 获取 bean
     * @param id
     * @return
     */
    @Override
    public Object getBean(String id) {
        return beanMap.get(id);
    }

}
