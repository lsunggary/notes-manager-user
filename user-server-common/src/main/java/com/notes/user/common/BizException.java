package com.notes.user.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BizException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private String errCode;
    private String errMsg;

    public BizException() {super();}

    public BizException(String message) {
        this.errMsg = message;
    }

    public BizException(String code, String message) {
        this.errCode = code;
        this.errMsg = message;
    }
}
