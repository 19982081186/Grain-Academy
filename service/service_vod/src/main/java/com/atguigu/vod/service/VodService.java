package com.atguigu.vod.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface VodService {

    public String uploadVideoAly(MultipartFile file);

    //删除多个阿里云视频的方法
    void removeMoreAlyVideo(List videoIdList);
}
