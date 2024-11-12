package cc.moreluck.myxxxjob.job.zlmediakit;

import cc.moreluck.myxxxjob.common.api.ApiResponse;
import cc.moreluck.myxxxjob.third.alist.AListProp;
import cc.moreluck.myxxxjob.third.alist.request.FsGetRequest;
import cc.moreluck.myxxxjob.third.alist.request.FsUploadRequest;
import cc.moreluck.myxxxjob.third.alist.response.FsGetResponse;
import cc.moreluck.myxxxjob.third.alist.service.remote.AListApiService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.File;


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


    @XxlJob(value = "uploadZlmCreateFileJobHandler")
    public ReturnT<String> uploadZlmCreateFile(String param) {
        //路径 /序列号/日日期/*.mp4
        File root = new File(aListProp.getFilePath());
        File[] files = root.listFiles();
        if (files == null || files.length == 0) {
            log.info("{}：无上传的文件", root.getAbsolutePath());
            return ReturnT.SUCCESS;
        }
        for (File fe : files) {
            if (fe.isDirectory()) {
                File[] fes = fe.listFiles();
                if (fes == null || fes.length == 0) {
                    log.info("路径：{}：无上传的文件", fe.getAbsolutePath());
                    return ReturnT.SUCCESS;
                }
                for (File file : fes) {
                    if (file.isDirectory()) {
                        File[] fls = file.listFiles();
                        if (fls == null || fls.length == 0) {
                            log.info("路径：{}：没有上传的文件", file.getAbsolutePath());
                            continue;
                        }
                        for (File fl : fls) {
                            FsGetRequest request = buildFsGetRequest(file.getName() + fl.getName());
                            ApiResponse<FsGetResponse> fsGetResponseApiResponse = aListApiService.fsGet(request);
                            FsGetResponse data = fsGetResponseApiResponse.getData();
                            if (data == null) {
                                FsUploadRequest fsUploadRequest = new FsUploadRequest();
                                fsUploadRequest.setFilePath(fl.getAbsolutePath());
                                aListApiService.fsPut(fsUploadRequest);
                            }
                        }

                    }
                }
            }
        }

        return ReturnT.SUCCESS;
    }


    @XxlJob(value = "removeHaveUploadedFileJobHandler")
    public ReturnT<String> removeHaveUploadedFile(String param) {

        File root = new File(aListProp.getFilePath());
        return ReturnT.SUCCESS;
    }


    public FsGetRequest buildFsGetRequest(String fileName) {
        FsGetRequest request = new FsGetRequest();
        request.setPath(aListProp.getFilePath() + fileName);
        request.setPage(1);
        request.setPerPage(10);
        request.setPassword("");
        request.setRefresh(false);
        return request;
    }

    public FsUploadRequest buildFsPutRequest(String fileAbsPath) {
        FsUploadRequest request = new FsUploadRequest();
        request.setFilePath(fileAbsPath);
        return request;
    }

}
