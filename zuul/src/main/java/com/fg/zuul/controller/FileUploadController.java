package com.fg.zuul.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class FileUploadController {

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        String uploadDir = "E:/test/";
        String originName = file.getOriginalFilename();
        String uploadPath = uploadDir+originName;

        File destDir = new File(uploadDir);
        if (!destDir.exists()) {
            destDir.mkdirs();
        }

        File dest = new File(uploadPath);
        if (dest.exists()) {
            dest.delete();
        }
        file.transferTo(dest);
        System.out.println("文件上传路径：" + uploadPath);

        return uploadPath;
    }
}
