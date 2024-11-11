package cc.moreluck.myxxxjob.common.api;

import java.io.Serializable;

/**
 * @author huangqi
 * @date 2024/11/11 16:30
 * @description:
 */
public interface IResultCode extends Serializable {
    /**
     * 状态码
     *
     * @return string
     */
    String getCode();
    /**
     * 如果是以 RC- 开头,将会从国际化文件里面查找对应的信息
     * 如果不是 RC- 开头,信息将原样输出
     * @return 描述信息或者RC-开头的i18code
     */
    String getMessage();



}