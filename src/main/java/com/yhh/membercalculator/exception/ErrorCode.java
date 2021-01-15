package com.yhh.membercalculator.exception;

/**
 * @author yhh1056
 * @since 2021/01/15
 */
public enum ErrorCode {
    MEMID_NOT_FOUNDED(400, "member.memId", "해당 id가 존재하지 않습니다."),
    MEMCODE_NOT_FOUNDED(401, "member.memCode", "memCode는 반드시 입력되어야 합니다.");

    private final String code;
    private final String message;
    private final int status;

    ErrorCode(final int status, final String code, final String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getCode() {
        return code;
    }

    public int getStatus() {
        return status;
    }
}