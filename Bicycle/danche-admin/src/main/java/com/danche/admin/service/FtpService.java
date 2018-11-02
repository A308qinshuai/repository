package com.danche.admin.service;

import com.danche.pojo.DancImage;
import com.danche.pojo.DancVnumber;
import com.danche.pojogongju.PictureResult;
import com.danche.pojogongju.TaotaoResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by liuzhen on 2018/3/14.
 */
public interface FtpService {
    PictureResult uploadImage(MultipartFile uploadFile);
    TaotaoResult saveimage(DancImage dancImage);
    TaotaoResult imageshuow();

    PictureResult uploadFile(MultipartFile uploadFile);
    TaotaoResult savefile(DancVnumber dancVnumber);
    TaotaoResult fileshuow();
}
