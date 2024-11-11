package cc.moreluck.myxxxjob.third.alist.request;

import lombok.Data;

/**
 * @author huangqi
 * @date 2024/11/11 17:31
 * @description: 获取Token请求参数
 */
@Data
public class AuthRequest {

    private String username;

    private String password;

}
