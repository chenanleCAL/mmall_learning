package com.mmall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by chenanle on 2017/12/12.
 */
public interface IFileService {

    String upload(MultipartFile file, String path);
}
