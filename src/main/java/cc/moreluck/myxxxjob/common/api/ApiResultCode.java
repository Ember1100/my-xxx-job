package cc.moreluck.myxxxjob.common.api;

/**
 * @author huangqi
 * @date 2024/11/11 16:31
 * @description:
 */
public enum ApiResultCode implements IResultCode{
    /**
     * 处理成功
     */
    MI_ME_SUCCESS("1000", "成功"),
    /**
     * 米么操作失败异常
     */
    MI_ME_EXCEPTION("1001", "业务异常"),

    /**
     * 矢隆机构响应成功
     */
    SHI_LONG_SUCCESS("0000000", "成功"),
    SHI_REPEAT_CODE("2001008","重复授信"),
    SLJT_REAPPLY_CODE("1999999","网络不给力，请稍后重试"),

    /**
     * 该流水已存在
     */
    SHI_LONG_LEND_APPLY_EXIST("5001001", "该流水已存在"),
    /**
     * 放款失败
     */
    SHI_LONG_LEND_APPLY_FAILURE("1008", "放款失败"),

    /**
     * 授信流水号不存在
     */
    SHI_LONG_CREDIT_NOT_EXIST("2001030","授信流水号不存在"),

    /**
     * 盈峰普惠响应成功
     */
    YFPH_SUCCESS("000000", "SUCCESS"),
    /**
     * 盈峰普惠响应失败
     */
    YFPH_FAIL("999999", "FAIL"),
    /**
     * 借款申请不存在
     */
    YFPH_LOAN_NON_EXIST("200007","借款申请不存在"),
    /**
     * 授信记录不存在
     */
    YFPH_CREDIT_AUTH_NON_EXIST("300013", "授信记录不存在"),
    /**
     * 中科 交易接收成功
     */
    ZK_RECEIVE_SUCCESS("0000", "交易接收成功"),
    ZK_HANDLE_SUCCESS("9999", "交易处理成功"),
    ZK_NO_TRANSACTION("1000", "查无此交易"),
    ZK_HANDLE_FAILURE("9000", "交易处理失败"),

    ZK_HANDLE_TIMEOUT("0100", "交易处理超时"),
    ZK_DUPLICATE_RECORD("1100", "重复记录"),
    ZK_PARAMETER_ERROR("1200", "参数错误"),
    ZK_SYSTEM_ERROR("1300", "系统异常"),
    ZKRJ_HANDLE_FAILURE("9000", "交易处理失败"),
    /**
     * 宜信响应失败
     */
    YIXIN_FAIL("999999", "FAIL"),

    /**
     * 拿粒响应成功
     */
    NALI_SUCCESS("000000", "SUCCESS"),
    /**
     * 拿粒响应失败
     */
    NALI_FAIL("999999", "FAIL"),
    ;
    /**
     * 编码
     */
    String code;
    /**
     * 信息或者i18Code
     */
    String message;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    ApiResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
