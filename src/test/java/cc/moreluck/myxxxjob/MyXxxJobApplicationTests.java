package cc.moreluck.myxxxjob;

import cc.moreluck.myxxxjob.third.alist.service.remote.AListRemoteServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyXxxJobApplicationTests {

    @Autowired
    AListRemoteServiceImpl aListRemoteService;
    @Test
    void contextLoads() {
        System.out.println(aListRemoteService.token());
    }

}
