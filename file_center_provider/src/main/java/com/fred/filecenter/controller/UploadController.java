package com.fred.filecenter.controller;

import com.fred.filecenter.enums.exceptioncode.BusinessErrorCode;
import com.fred.filecenter.exception.FileCenterException;
import com.fred.filecenter.framework.model.BizResult;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * 〈功能概述〉
 *
 * @author: fuliping
 * @date: 2020/4/13 11:57 下午
 */
@Controller("file_center/")
public class UploadController {

    @PostMapping(value = "upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public BizResult<String> uploadFIle(@RequestParam("file") MultipartFile file){
        if (file.isEmpty()){
            throw FileCenterException.create(BusinessErrorCode.File_IS_NULL);
        }

        String fileName = file.getOriginalFilename();
        //String rawFileName =

    }
}
