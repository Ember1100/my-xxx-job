package cc.moreluck.myxxxjob.third.alist.service.remote;

import cc.moreluck.myxxxjob.common.api.ApiResponse;
import cc.moreluck.myxxxjob.third.alist.enums.AListApiPathEnum;
import org.springframework.lang.Nullable;

import java.io.File;

/**
 * @author huangqi
 * @date 2024/11/11 16:25
 * @description:
 */
public interface AListRemoteService {

    <T> ApiResponse<T> execute(AListApiPathEnum apiPathEnum,Object requestParam, @Nullable Class<T> resultClass);

}
