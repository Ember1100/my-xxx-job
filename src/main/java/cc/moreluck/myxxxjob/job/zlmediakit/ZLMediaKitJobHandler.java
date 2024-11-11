package cc.moreluck.myxxxjob.job.zlmediakit;

import cc.moreluck.myxxxjob.third.alist.service.remote.AListRemoteService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author huangqi
 * @date 2024/11/11 17:47
 * @description:
 */

@Slf4j
@Component
@RequiredArgsConstructor
public class ZLMediaKitJobHandler {


    private AListRemoteService aListRemoteService;

    @Value("${app.zlm.filePath}")
    private String filePath;

    @XxlJob(value = "zLMediaKitJobHandler")
    public ReturnT<String> uploadZlmCreateFile(String param) {


        return ReturnT.SUCCESS;
    }
}
