package com.fred.filecenter.exception;

import cn.hutool.core.util.StrUtil;
import com.fred.filecenter.enums.exceptioncode.AppCode;
import com.fred.filecenter.enums.exceptioncode.SystemErrorCode;
import lombok.*;


/**
 * 〈功能概述〉<br>
 *
 * @className: WimiException
 * @package: com.fred.wimi.wimiproduct.api.exception
 * @author: admin
 * @date: 2020/4/3 16:16
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter(AccessLevel.PRIVATE)
public class FileCenterException extends RuntimeException {

    private AppCode appCode = SystemErrorCode.SYSTEM_UNKOWN_EXCEPTION;

    private FileCenterException(String message, AppCode appErrorCode) {
        super(message);
        this.appCode = appErrorCode;
    }

    private static FileCenterException of(String message, AppCode appCode) {
        return new FileCenterException(message, appCode);
    }

    public static FileCenterException create(@lombok.NonNull AppCode appCode) {
        return FileCenterException.of(appCode.getMessage(), appCode);
    }

    public static FileCenterException create(@lombok.NonNull AppCode appCode, String errorMessage) {
        if (StrUtil.isEmpty(errorMessage)) {
            return FileCenterException.of(appCode.getMessage(), appCode);
        }
        return FileCenterException.of(errorMessage, appCode);
    }
}
