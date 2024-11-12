package cc.moreluck.myxxxjob.third.alist;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author huangqi
 * @date 2024/11/11 17:03
 * @description:
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "app.alist",ignoreUnknownFields = true)
@ToString
public class AListProp {
    private String apiServer;
    private String user;
    private String pwd;
    private String filePath;
}
