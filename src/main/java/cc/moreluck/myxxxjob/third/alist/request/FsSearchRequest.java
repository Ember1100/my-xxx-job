package cc.moreluck.myxxxjob.third.alist.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author huangqi
 * @date 2024/11/12 11:15
 * @description: 搜索请求的参数。
 */
@Data
public class FsSearchRequest {
    /**
     * 搜索目录
     */
    private String parent;

    /**
     * 关键词 - 用于搜索的字符串。
     */
    private String keywords;

    /**
     * 搜索类型 - 表示搜索的范围。
     * 0 - 全部
     * 1 - 文件夹
     * 2 - 文件
     */
    private Integer scope;

    /**
     * 页数 - 表示请求的页码。
     * 注意：页码从 1 开始。
     */
    private Integer page;

    /**
     * 每页数目 - 表示每一页的记录数。
     */
    @JsonProperty(value = "per_page")
    private Integer perPage;

    /**
     * 密码 - 用于验证的密码。
     */
    private String password;
}
