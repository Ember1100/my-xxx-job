package cc.moreluck.myxxxjob;

import cc.moreluck.myxxxjob.job.zlmediakit.ZLMediaKitJobHandler;
import cc.moreluck.myxxxjob.third.alist.AListProp;
import cc.moreluck.myxxxjob.third.alist.request.FsGetRequest;
import cc.moreluck.myxxxjob.third.alist.response.FsGetResponse;
import cc.moreluck.myxxxjob.third.alist.service.remote.AListApiService;
import cc.moreluck.myxxxjob.third.alist.service.remote.AListRemoteServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyXxxJobApplicationTests {

    @Autowired
    AListRemoteServiceImpl aListRemoteService;
    @Autowired
    AListApiService aListApiService;
    @Autowired
    AListProp aListProp;
    @Test
    void contextLoads() {
        System.out.println(aListProp);
    }

    @Autowired
    ZLMediaKitJobHandler zlMediaKitJobHandler;

    @Test
    void contextLoadsQuery() throws InterruptedException {
//        zlMediaKitJobHandler.query("模版");
//        zlMediaKitJobHandler.uploadZlmCreateFile("模版");
        new Thread(() -> {
            System.out.println(aListRemoteService.token());
        }).start();

        new Thread(() -> {
            System.out.println(aListRemoteService.token());
        }).start();

        new Thread(() -> {
            System.out.println(aListRemoteService.token());
        }).start();

        Thread.sleep(10000);
    }

    @Test
    void contextLoadsApi() throws InterruptedException {
        FsGetRequest fsGetRequest = new FsGetRequest();
        fsGetRequest.setPath("/阿里云盘open/zlm/模板开发培训视频22.mp4");
        fsGetRequest.setPage(1);
        fsGetRequest.setPerPage(20);
        fsGetRequest.setRefresh(false);
        FsGetResponse data = aListApiService.fsGet(fsGetRequest).getData();
        System.out.println(data);
    }

    @Test
    void upload() {
        zlMediaKitJobHandler.uploadZlmCreateFile("");
    }
}
