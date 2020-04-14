package com.fred.filecenter.enums.exceptioncode;

/**
 * 〈业务错误枚举〉<br>
 *
 * @className: BusinessErrorCode
 * @package: com.fred.wimi.wimiproduct.api.enums
 * @author: admin
 * @date: 2020/4/3 16:44
 */

public enum BusinessErrorCode implements AppCode {
    File_IS_NULL(20001,"文件内容为空") ,
    FILE_UPDATE_ERROR(20002,"文件上传失败");

    private int code;
    private String message;

    BusinessErrorCode(int code, String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public void setCode(int code) {
        this.code = code;
    }
}
