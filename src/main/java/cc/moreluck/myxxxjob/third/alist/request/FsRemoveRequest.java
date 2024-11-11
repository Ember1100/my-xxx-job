package cc.moreluck.myxxxjob.third.alist.request;

import lombok.Data;

import java.util.List;

/**
 * @author huangqi
 * @date 2024/11/11 17:31
 * @description: 删除文件或文件夹请求参数
 */
@Data
public class FsRemoveRequest {

    private List<String> names;

    private String dir;

}
