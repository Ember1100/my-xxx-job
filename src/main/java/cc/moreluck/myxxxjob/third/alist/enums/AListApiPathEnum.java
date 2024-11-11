package cc.moreluck.myxxxjob.third.alist.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author huangqi
 * @date 2024/11/11 16:47
 * @description:
 */
@Getter
@AllArgsConstructor
public enum AListApiPathEnum {

    CREDIT_APPLY("/api/auth/login", "token获取", "POST",true),

    FS_REMOVE("/api/fs/remove", "删除文件或文件夹", "POST",true),

    FS_PUT("/api/fs/put", "流式上传文件", "PUT",true),
    ;


    private final String path;

    private final String name;

    private final String method;

    private final Boolean isLogger;

}
