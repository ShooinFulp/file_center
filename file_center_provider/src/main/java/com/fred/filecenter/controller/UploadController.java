package com.fred.filecenter.controller;

import com.fred.filecenter.framework.model.BizResult;
import com.fred.filecenter.response.UploadResponse;
import com.fred.filecenter.service.UploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


/**
 * 〈文件上传〉
 *
 * @author: fuliping
 * @date: 2020/4/13 11:57 下午
 */
@Slf4j
@RestController
@RequestMapping("file_center/")
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @PostMapping(value = "upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public BizResult<UploadResponse> uploadFIle(@RequestParam("file") MultipartFile file) {
        return uploadService.uploadFile(file);
    }
}
