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

    AUTH_LOGIN("/api/auth/login", "token获取", "POST",true),

    FS_REMOVE("/api/fs/remove", "删除文件或文件夹", "POST",true),

    FS_SEARCH("/api/fs/search", "搜索文件或文件夹", "POST",true),

    FS_PUT("/api/fs/put", "流式上传文件", "PUT",true),

    FS_GET("/api/fs/get", "获取某个文件/目录信息", "POST",true),

    FS_LIST("/api/fs/list", "列出文件目录", "POST",true),

    FS_DIRS("/api/fs/dirs", "获取目录", "POST",true),
    ;


    private final String path;

    private final String name;

    private final String method;

    private final Boolean isLogger;

}
