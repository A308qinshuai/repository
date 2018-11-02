package com.danche.admin.service.impl;

import com.danche.admin.service.FtpService;
import com.danche.mapper.DancImageMapper;
import com.danche.mapper.DancVnumberMapper;
import com.danche.pojo.DancImage;
import com.danche.pojo.DancImageExample;
import com.danche.pojo.DancVnumber;
import com.danche.pojo.DancVnumberExample;
import com.danche.pojogongju.PictureResult;
import com.danche.pojogongju.TaotaoResult;
import com.danche.utils.FtpUtil;
import com.danche.utils.IDUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

/**
 * Created by liuzhen on 2018/4/2.
 */
@Service
public class FtpServiceImpl  implements FtpService{

    @Value("${FTP_ADDRESS}")
    private String FTP_ADDRESS;
    @Value("${FTP_RORT}")
    private Integer FTP_RORT;
    @Value("${FTP_USERNAME}")
    private String FTP_USERNAME;
    @Value("${FTP_PASSWORD}")
    private String FTP_PASSWORD;
    @Value("${FTP_BASE_PATH}")
    private String FTP_BASE_PATH;
    @Value("${IMAGE_BASE_URL}")
    private String IMAGE_BASE_URL;
    @Autowired
    private DancImageMapper dancImageMapper;
    @Autowired
    private DancVnumberMapper dancVnumberMapper;

    @Override
    public PictureResult uploadImage(MultipartFile uploadFile){
        try {
        //判断上传图片是否为空
        if (null == uploadFile || uploadFile.isEmpty()) {
            return PictureResult.error("上传图片为空");
        }
        //取文件扩展名
        String originalFilename = uploadFile.getOriginalFilename();
        String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
        //生成新文件名
        //可以使用uuid生成新文件名。
        //UUID.randomUUID()
        //可以是时间+随机数生成文件名IDUtils.genImageName()
        String imageName = "daohang";
        //把图片上传到ftp服务器（图片服务器）
        //需要把ftp的参数配置到配置文件中
        //文件在服务器的存放路径，应该使用日期分隔的目录结构dateTime.toString("/yyyy/MM/dd")
        DateTime dateTime = new DateTime();
        String filePath = "daohang";

            boolean uu = FtpUtil.uploadFile(FTP_ADDRESS, FTP_RORT, FTP_USERNAME, FTP_PASSWORD,
                    FTP_BASE_PATH, filePath, imageName + ext, uploadFile.getInputStream());
            if(uu){
                return PictureResult.ok(IMAGE_BASE_URL + "/" +filePath + "/" + imageName + ext);
            }else {
                return PictureResult.error("文件上传失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return PictureResult.error("文件上传失败");
        }
        //返回结果，生成一个可以访问到图片的url返回
    }

    @Override
    public  TaotaoResult saveimage(DancImage dancImage){
        try {
        Date date = new Date();
        dancImage.setCreated(date);
        dancImage.setStatus(0);
        dancImageMapper.insert(dancImage);
        return  TaotaoResult.ok();
        }catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(500, "提交失败");
        }
    }

    @Override
    public TaotaoResult imageshuow(){
        DancImageExample example = new DancImageExample();
        DancImageExample.Criteria criteria = example.createCriteria();
        List<DancImage> dancImages = dancImageMapper.selectByExample(example);
        return  TaotaoResult.ok(dancImages);
    }

    @Override
    public PictureResult uploadFile(MultipartFile uploadFile){
        try {
        //判断上传图片是否为空
        if (null == uploadFile || uploadFile.isEmpty()) {
            return PictureResult.error("上传文件为空");
        }
        //取文件扩展名
        String originalFilename = uploadFile.getOriginalFilename();
        String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
        //生成新文件名
        //可以使用uuid生成新文件名。
        //UUID.randomUUID()
        //可以是时间+随机数生成文件名IDUtils.genImageName()
        String imageName = "xiaoyuandanche";
        //把图片上传到ftp服务器（图片服务器）
        //需要把ftp的参数配置到配置文件中
        //文件在服务器的存放路径，应该使用日期分隔的目录结构dateTime.toString("/yyyy/MM/dd")
        DateTime dateTime = new DateTime();
        String filePath = "dancheapp";


            boolean uu = FtpUtil.uploadFile(FTP_ADDRESS, FTP_RORT, FTP_USERNAME, FTP_PASSWORD,
                    FTP_BASE_PATH, filePath, imageName + ext, uploadFile.getInputStream());
            if(uu){
                return PictureResult.ok(IMAGE_BASE_URL + "/" +filePath + "/" + imageName + ext);
            }else {
                return PictureResult.error("文件上传失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return PictureResult.error("文件上传失败");
        }
        //返回结果，生成一个可以访问到图片的url返回


    }

    @Override
    public  TaotaoResult savefile(DancVnumber dancVnumber){
        try {
            Date date = new Date();
            dancVnumber.setCreated(date);
            dancVnumber.setStatus("0");
            dancVnumberMapper.insert(dancVnumber);
            return  TaotaoResult.ok();
        }catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(500, "提交失败");
        }
    }

    @Override
    public TaotaoResult fileshuow(){
        DancVnumberExample example = new DancVnumberExample();
        DancVnumberExample.Criteria criteria = example.createCriteria();
        List<DancVnumber> dancFile = dancVnumberMapper.selectByExample(example);
        return  TaotaoResult.ok(dancFile);
    }
}
