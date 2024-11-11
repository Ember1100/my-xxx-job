package cc.moreluck.myxxxjob.common.api;

import com.alibaba.fastjson2.JSON;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


/**
 * @author huangqi
 * @date 2024/11/11 16:29
 * @description:
 */
@Getter
@Setter
public class ApiResponse<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    protected String code;

    protected String message;

    protected T data;

    protected Boolean success;

    protected String requestId;

    protected String serialNo;

    protected ApiResponse() {
    }

    protected ApiResponse(Boolean success, IResultCode resultCode) {
        this(success, resultCode.getCode(), resultCode.getMessage(), null);
    }

    protected ApiResponse(Boolean success, String code, String message) {
        this(success, code, message, null);
    }

    protected ApiResponse(Boolean success, IResultCode resultCode, String message) {
        this(success, resultCode.getCode(), message, null);
    }

    protected ApiResponse(Boolean success, IResultCode resultCode, T data) {
        this(success, resultCode.getCode(), resultCode.getMessage(), data);
    }

    protected ApiResponse(Boolean success, IResultCode resultCode, T data, String message) {
        this(success, resultCode.getCode(), message, data);
    }

    protected ApiResponse(Boolean success, String code, String message, T data) {
        this.message = message;
        this.code = code;
        this.success = success;
        this.data = data;
    }

    public static <T> ApiResponse<T> data(Boolean success, IResultCode resultCode, T data) {
        return new ApiResponse<>(success, resultCode, data);
    }

    public static <T> ApiResponse<T> data(Boolean success, String code, String message, T data) {
        return new ApiResponse<>(success, code, message, data);
    }

    /**
     * 成功
     *
     * @param resultCode
     * @param <T>
     * @return
     */
    public static <T> ApiResponse<T> success(IResultCode resultCode) {
        return new ApiResponse<>(true, resultCode);
    }

    public static <T> ApiResponse<T> success(IResultCode resultCode, T data) {
        return new ApiResponse<>(true, resultCode, data);
    }

    public static <T> ApiResponse<T> success(IResultCode resultCode, T data, String message) {
        return new ApiResponse<>(true, resultCode, data, message);
    }

    public static <T> ApiResponse<T> success(IResultCode resultCode, String message) {
        return new ApiResponse<>(true, resultCode, message);
    }

    public static <T> ApiResponse<T> success(String code, String message, T data) {
        return new ApiResponse<>(true, code, message, data);
    }

    public static <T> ApiResponse<T> success(String code, String message) {
        return new ApiResponse(true, code, message);
    }

    public static <T> ApiResponse<T> fail(String code, String message) {
        return new ApiResponse<>(false, code, message);
    }

    /**
     * 业务失败
     * @param <T>
     * @return
     */
    public static <T> ApiResponse<T> fail(String code, String message, T data) {
        return new ApiResponse<>(false, code, message, data);
    }

    public static <T> ApiResponse<T> fail(IResultCode resultCode) {
        return new ApiResponse<>(false, resultCode);
    }

    public static <T> ApiResponse<T> fail(IResultCode resultCode, String message) {
        return new ApiResponse<>(false, resultCode, message);
    }


    public static <T> ApiResponse<T> fail(IResultCode resultCode, T data) {
        return new ApiResponse<>(false, resultCode, data);
    }


    @Override
    public String toString() {
        return getClass().getSimpleName() + JSON.toJSONString(this);
    }
}
