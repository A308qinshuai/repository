package com.danche.admin.controller;

import com.danche.admin.service.FtpService;
import com.danche.pojo.DancImage;
import com.danche.pojo.DancVnumber;
import com.danche.pojogongju.PictureResult;
import com.danche.pojogongju.TaotaoResult;
import com.danche.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by liuzhen on 2018/4/2.
 */
@Controller
public class FtpController {
    @Autowired
    private FtpService ftpService;

    @RequestMapping(value = "/pic/load",method = RequestMethod.POST)
    @ResponseBody
    public String upload(MultipartFile uploadFile) {
        try {
            PictureResult result = ftpService.uploadImage(uploadFile);
            String json = JsonUtils.objectToJson(result);
            return json;
        }catch (Exception e) {
            e.printStackTrace();
            return "上传图片失败，意外错误";
        }
    }

    @RequestMapping(value = "/banben/Fileload",method = RequestMethod.POST)
    @ResponseBody
    public String Fileload(MultipartFile uploadFile) {
        try {
            PictureResult result = ftpService.uploadFile(uploadFile);
            String json = JsonUtils.objectToJson(result);
            return json;
        }catch (Exception e) {
            e.printStackTrace();
            return "上传文件失败，意外错误";
        }
    }

    @RequestMapping(value = "/pic/submit",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult svae(String title,String url,String des,String cid){
        System.out.print(url);
        try{
        DancImage dancImage = new DancImage();
        dancImage.setTitle(title);
        dancImage.setUrl(url);
        dancImage.setDes(des);
        dancImage.setCid(cid);
        TaotaoResult result = ftpService.saveimage(dancImage);
        return result;
        }catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(500, "提交失败");
        }
    }

    @RequestMapping(value = "/banben/submit",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult svaefile(String vnumber,String des,String name){
        try{
            DancVnumber dancVnumber = new DancVnumber();
            dancVnumber.setVnumber(vnumber);
            dancVnumber.setName(name);
            dancVnumber.setDes(des);
            TaotaoResult result = ftpService.savefile(dancVnumber);
            return result;
        }catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(500, "提交失败");
        }
    }

    @RequestMapping("/pic/image")
    @ResponseBody
    public  TaotaoResult imageshows(){
        TaotaoResult result = ftpService.imageshuow();
        return  result;
    }

    @RequestMapping("/banben/file")
    @ResponseBody
    public  TaotaoResult fileshows(){
        TaotaoResult result = ftpService.fileshuow();
        return  result;
    }
}