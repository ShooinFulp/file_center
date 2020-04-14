package com.fred.filecenter.response;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 〈功能概述〉
 *
 * @author: fuliping
 * @date: 2020/4/14 9:58 下午
 */
@Data
@AllArgsConstructor
public class UploadResponse {
    private String fileName;
    private String filePath;
}
