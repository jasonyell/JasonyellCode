package com.yell.springmvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *
 */
@Controller
public class FileController {
    /**
     * 单文件上传
     * @param request
     * @param file
     * @return
     */
    @RequestMapping("uploadFile")
    public String uploadFile(HttpServletRequest request, @RequestParam("file") MultipartFile file) {

//        //转换Request对象
//        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
//        //得到上传的文件对象
//        MultipartFile multipartFile = multipartHttpServletRequest.getFile(""); //参数值对应的表单元素（文件域）的name
        saveFile(request, file);
        return "result";
    }

    /**
     * 多文件上传
     *  @RequestParam("files") 中的值 和相应jsp(upload.jsp)中 name 值一致
     * @param request
     * @param files
     * @return
     */
    @RequestMapping("uploadFiles")
    public String uploadFiles(HttpServletRequest request, @RequestParam("files") List<MultipartFile> files) {

        // 判断集合是否存在并且长度大于0
        if (files != null && files.size() > 0) {
            for (MultipartFile file : files) {
                saveFile(request, file);
            }
        }
        return "result";
    }



    /**
     * 上传文件，保存文件到执行目录
     * @param request
     * @param file
     */
    public void saveFile(HttpServletRequest request, MultipartFile file) {
        // 判断文件是否存在
        if (!file.isEmpty()) {
            try {
                // 得到项目的真实路径
                String path = request.getServletContext().getRealPath("/");
                // 设置文件存放的路径 （放置在项目的 upload 目录下）
                File uploadFile = new File(path + "/upload");
                // 判断文件目录是否存在
                if (!uploadFile.exists()) {
                    // 新建目录
                    uploadFile.mkdir();
                }
                //得到上传文件的文件名
                String originalFilename = file.getOriginalFilename();
                // 得到上传文件的后缀
                String suff = originalFilename.substring(originalFilename.lastIndexOf("."));
                // 通过系统时间戳设置随机不重复的文件名
                String fileName = System.currentTimeMillis() + suff;
                //上传文件(转存文件到指定文件目录)
                file.transferTo(new File(uploadFile, fileName));

                request.setAttribute("msg", "文件上传成功");
            } catch (IOException e) {
                e.printStackTrace();
                request.setAttribute("msg", "上传文件失败");
            }
        } else {
            request.setAttribute("msg", "未选择上传文件");
        }
    }
}
