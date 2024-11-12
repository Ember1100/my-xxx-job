package cc.moreluck.myxxxjob.third.alist.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.OffsetDateTime;

/**
 * @author huangqi
 * @date 2024/11/12 15:55
 * @description:
 */
@Data
public class FsGetResponse {

    /**
     * 文件或目录的名称。
     */
    private String name;

    /**
     * 文件大小（字节）。
     */
    private long size;

    /**
     * 是否为目录的标志。
     */
    @JsonProperty(value = "is_dir")
    private boolean isDir;

    /**
     * 最后修改时间。
     */
    private OffsetDateTime modified;

    /**
     * 创建时间。
     */
    private OffsetDateTime created;

    /**
     * 签名信息。
     */
    private String sign;

    /**
     * 缩略图链接。
     */
    private String thumb;

    /**
     * 文件类型标识。
     */
    private int type;

    /**
     * 哈希信息。
     */
    private String hashinfo;

    /**
     * 哈希信息（可选）。
     */
    @JsonProperty(value = "hash_info")
    private String hashInfo;
}
