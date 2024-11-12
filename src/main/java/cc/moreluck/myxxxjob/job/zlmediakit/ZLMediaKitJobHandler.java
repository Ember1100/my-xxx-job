package cc.moreluck.myxxxjob.job.zlmediakit;

import cc.moreluck.myxxxjob.common.api.ApiResponse;
import cc.moreluck.myxxxjob.third.alist.AListProp;
import cc.moreluck.myxxxjob.third.alist.enums.AListApiPathEnum;
import cc.moreluck.myxxxjob.third.alist.request.FsSearchRequest;
import cc.moreluck.myxxxjob.third.alist.request.FsUploadRequest;
import cc.moreluck.myxxxjob.third.alist.response.FsSearchResponse;
import cc.moreluck.myxxxjob.third.alist.response.FsUploadResponse;
import cc.moreluck.myxxxjob.third.alist.service.remote.AListApiService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * @author huangqi
 * @date 2024/11/11 17:47
 * @description:
 */

@Slf4j
@Component
@AllArgsConstructor
public class ZLMediaKitJobHandler {

    private AListProp aListProp;

    private AListApiService aListApiService;



    @XxlJob(value = "zLMediaKitJobHandler")
    public ReturnT<String> uploadZlmCreateFile(String param) {


        FsUploadRequest fsUploadRequest = new FsUploadRequest();
        fsUploadRequest.setFilePath("C:\\Users\\Administrator\\Downloads\\模板开发培训视频1.mp4");
        ApiResponse<FsUploadResponse> execute = aListApiService.fsPut(fsUploadRequest);
        System.out.println(execute.getData());
        return ReturnT.SUCCESS;
    }

    public void query(String keyword) {
        FsSearchRequest searchRequest = new FsSearchRequest();
        searchRequest.setParent("[/阿里云盘open](/zlm)");
        searchRequest.setKeywords(keyword);
        searchRequest.setScope(0);
        searchRequest.setPerPage(50);
        searchRequest.setPassword("pwd");
        ApiResponse<FsSearchResponse> execute = aListApiService.fsSearch(searchRequest);
        System.out.println(execute.getData());
    }
}
