package cc.moreluck.myxxxjob.third.alist.service.remote;

import cc.moreluck.myxxxjob.common.api.ApiResponse;
import cc.moreluck.myxxxjob.third.alist.enums.AListApiPathEnum;
import cc.moreluck.myxxxjob.third.alist.request.FsGetRequest;
import cc.moreluck.myxxxjob.third.alist.request.FsRemoveRequest;
import cc.moreluck.myxxxjob.third.alist.request.FsSearchRequest;
import cc.moreluck.myxxxjob.third.alist.request.FsUploadRequest;
import cc.moreluck.myxxxjob.third.alist.response.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author huangqi
 * @date 2024/11/12 15:12
 * @description:
 */
@Service
@AllArgsConstructor
@Slf4j
public class DefaultAListApiService implements AListApiService{

    AListRemoteService aListRemoteService;

    @Override
    public ApiResponse<FsSearchResponse> fsSearch(FsSearchRequest request) {
        return aListRemoteService.execute(AListApiPathEnum.FS_SEARCH,request, FsSearchResponse.class);
    }

    @Override
    public ApiResponse<FsGetResponse> fsGet(FsGetRequest request) {
        return aListRemoteService.execute(AListApiPathEnum.FS_GET,request, FsGetResponse.class);
    }

    @Override
    public ApiResponse<FsListResponse> fsList(FsGetRequest request) {
        return aListRemoteService.execute(AListApiPathEnum.FS_LIST,request, FsListResponse.class);
    }

    @Override
    public ApiResponse<FsUploadResponse> fsPut(FsUploadRequest request) {
        return aListRemoteService.execute(AListApiPathEnum.FS_PUT,request,FsUploadResponse.class);
    }

    @Override
    public ApiResponse<String> fsRemove(FsRemoveRequest request) {
        return aListRemoteService.execute(AListApiPathEnum.FS_REMOVE,request,String.class);
    }

    @Override
    public ApiResponse<FsDirsResponse> fsDirs(FsGetRequest request) {
        return aListRemoteService.execute(AListApiPathEnum.FS_DIRS,request,FsDirsResponse.class);
    }
}
