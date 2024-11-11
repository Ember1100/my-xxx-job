package cc.moreluck.myxxxjob.third.alist.service.remote;

import cc.moreluck.myxxxjob.common.api.ApiResponse;
import cc.moreluck.myxxxjob.third.alist.AListProp;
import cc.moreluck.myxxxjob.third.alist.enums.AListApiPathEnum;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONReader;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.io.IOException;



/**
 * @author huangqi
 * @date 2024/11/11 16:27
 * @description:
 */
@Service
@AllArgsConstructor
@Slf4j
public class AListRemoteServiceImpl implements AListRemoteService{

    private AListProp aListProp;

    private static final class InstanceHolder {
        private static final OkHttpClient INSTANCE = new OkHttpClient.Builder()
                .build();
    }

    public static OkHttpClient getInstance() {
        // 使用双重检查锁定（Double-Check Locking）
        return InstanceHolder.INSTANCE;
    }

    private final static MediaType MEDIA_TYPE = MediaType.parse("application/json");
    private  static String TOKEN = "";


    @Override
    public <T> ApiResponse<T> execute(AListApiPathEnum apiPathEnum, Object requestParam, @Nullable Class<T> resultClass) {
        String param = JSON.toJSONString(requestParam);
        log.info("alist 接口请求报文: {}", param);
        RequestBody body = RequestBody.create(MEDIA_TYPE, param);
        Request request = new Request.Builder()
                .url(aListProp.getApiServer() + apiPathEnum.getPath())
                .method(apiPathEnum.getMethod(), body)
                .addHeader("Authorization",TOKEN)
                .addHeader("Content-Type", "application/json")
                .build();
       try {
           Response response = InstanceHolder.INSTANCE.newCall(request).execute();

           String responseStr = new String(response.body().bytes());
           return parseApiResponse(apiPathEnum,responseStr,resultClass);

       } catch (IOException e) {
           throw new RuntimeException(e);
       }
    }

    private <T> ApiResponse<T> parseApiResponse(AListApiPathEnum apiPathEnum, String responseStr, Class<T> resultClass) {
        Assert.hasLength(responseStr,"响应结果为空");
        JSONObject jsonObject = JSON.parseObject(responseStr);

        String code = jsonObject.getString("code");
        String msg = jsonObject.getString("msg");

        String data = jsonObject.getString("data");
        Assert.hasText(data,"body 为空");

        T responseData = JSON.parseObject(data, resultClass, JSONReader.Feature.SupportSmartMatch);

        if (apiPathEnum.getIsLogger()) {
            log.info("接口 = 【{}】,响应 code = {}, msg = {}, data={}",
                    apiPathEnum.getName(), code, msg, responseData);
        }

        // 200-交互成功
        if (!"200".equals(code)) {
            log.warn("接口 = 【{}】,错误响应 = 【{}】", apiPathEnum.getName(), responseStr);
            return ApiResponse.fail(code, msg);
        }
        return  ApiResponse.success(code, msg, responseData);
    }

    public String getToken(){
        return "ok";
    }
}
