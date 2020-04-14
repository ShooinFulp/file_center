package com.fred.filecenter.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.fred.filecenter.enums.exceptioncode.BusinessErrorCode;
import com.fred.filecenter.exception.FileCenterException;
import com.fred.filecenter.framework.model.BizResult;
import com.fred.filecenter.response.UploadResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

/**
 * 〈功能概述〉
 *
 * @author: fuliping
 * @date: 2020/4/13 11:57 下午
 */
@Service
@Slf4j
public class UploadService {

    @Value("${spring.servlet.multipart.location}")
    private String fileTempPath;

    public BizResult<UploadResponse> uploadFile(MultipartFile file){
        if (file.isEmpty()) {
            throw FileCenterException.create(BusinessErrorCode.File_IS_NULL);
        }

        String fileName = file.getOriginalFilename();
        String rawFileName = StrUtil.subBefore(fileName, ".", true);
        String fileType = StrUtil.subAfter(fileName, ".", true);
        String localFilePath = StrUtil.appendIfMissing(fileTempPath, "/") + rawFileName + "-" + DateUtil.current(false) + "." + fileType;

        try {
            file.transferTo(new File(localFilePath));
        } catch (IOException e) {
            log.error("【文件上传】失败，绝对路径：{}", localFilePath);
            throw  FileCenterException.create(BusinessErrorCode.FILE_UPDATE_ERROR,e.getMessage());
        }

        log.info("【文件上传成功】绝对路径：{}",localFilePath);
        return  BizResult.success(new UploadResponse(fileName,localFilePath));
    }
}
