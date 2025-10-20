package com.easy.springboot.Controller;

import com.easy.springboot.util.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UploadController {

    //用于把前端传进来的图片换个名字存到指定文件夹里面
    //新名字就是newFileName
    //以newFileName传进"D\\mypic"文件中
    @RequestMapping("/upload")
    public Result upload(MultipartFile file) {

        String uuid = UUID.randomUUID().toString().replace("-", "");
        String fileName = file.getOriginalFilename();
        String extension = fileName.substring(fileName.lastIndexOf("."));
        String newFileName = uuid + extension;
        String filePath="D:\\mypic\\"+newFileName;

        try {
            file.transferTo(new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Result.ok("上传成功","api/pic/"+newFileName);

    }

}
