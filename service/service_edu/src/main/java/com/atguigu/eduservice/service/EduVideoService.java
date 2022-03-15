package com.atguigu.eduservice.service;

import com.atguigu.eduservice.entity.EduVideo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author fushengroumeng
 * @since 2022-02-24
 */
public interface EduVideoService extends IService<EduVideo> {

    //根据课程id删除小节
    public void removeVideoByCourseId(String id);

}
