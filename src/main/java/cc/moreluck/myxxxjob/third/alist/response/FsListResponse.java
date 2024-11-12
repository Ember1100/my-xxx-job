package cc.moreluck.myxxxjob.third.alist.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * @author huangqi
 * @date 2024/11/12 15:07
 * @description:
 */
@Data
public class FsListResponse {

    /**
     * 内容列表。
     */
    private List<FsGetResponse> content;

    /**
     * 内容总数。
     */
    private int total;

    /**
     * 备注信息。
     */
    private String readme;

    /**
     * 头部信息。
     */
    private String header;

    /**
     * 是否可写标志。
     */
    private boolean write;

    /**
     * 提供者名称。
     */
    private String provider;

}
