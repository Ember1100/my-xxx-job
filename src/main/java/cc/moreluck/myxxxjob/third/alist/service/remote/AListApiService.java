package cc.moreluck.myxxxjob.third.alist.service.remote;

import cc.moreluck.myxxxjob.common.api.ApiResponse;
import cc.moreluck.myxxxjob.third.alist.request.FsGetRequest;
import cc.moreluck.myxxxjob.third.alist.request.FsRemoveRequest;
import cc.moreluck.myxxxjob.third.alist.request.FsSearchRequest;
import cc.moreluck.myxxxjob.third.alist.request.FsUploadRequest;
import cc.moreluck.myxxxjob.third.alist.response.*;

/**
 * @author huangqi
 * @date 2024/11/12 15:11
 * @description:
 */
public interface AListApiService {


    ApiResponse<FsSearchResponse>  fsSearch(FsSearchRequest request);

    ApiResponse<FsGetResponse>  fsGet(FsGetRequest request);

    ApiResponse<FsListResponse>  fsList(FsGetRequest request);

    ApiResponse<FsUploadResponse>  fsPut(FsUploadRequest request);

    ApiResponse<String>  fsRemove(FsRemoveRequest request);

    ApiResponse<FsDirsResponse>  fsDirs(FsGetRequest request);
}
