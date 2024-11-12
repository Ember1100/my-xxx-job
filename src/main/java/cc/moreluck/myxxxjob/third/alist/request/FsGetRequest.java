package cc.moreluck.myxxxjob.third.alist.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author huangqi
 * @date 2024/11/12 15:04
 * @description:
 */
@Data
public class FsGetRequest {

    private String path;
    private String password;
    private Integer page;
    @JsonProperty(value = "per_page")
    private Integer perPage;
    private Boolean refresh;
}
