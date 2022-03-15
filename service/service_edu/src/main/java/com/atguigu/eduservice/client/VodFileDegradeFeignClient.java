package com.atguigu.eduservice.client;

import com.atguigu.commonutils.Result;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VodFileDegradeFeignClient implements VodClient {

    @Override
    public Result removeAlyVideo(String id) {
        return Result.error().message("time out");
    }

    @Override
    public Result deleteBatch(List<String> videoIdList) {
        return Result.error().message("time out");
    }
}
