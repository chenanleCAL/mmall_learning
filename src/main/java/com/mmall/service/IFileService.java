package com.mmall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by chenanle on 2017/12/12.
 */
public interface IFileService {


    /**
     * 后台商品图片的springmvc上传与富文本上传ftp服务器的功能
     *
     * @param file
     * @param path
     * @return
     */
    String upload(MultipartFile file, String path);
}
