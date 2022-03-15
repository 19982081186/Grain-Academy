package com.atguigu.staservice.controller;


import com.atguigu.commonutils.Result;
import com.atguigu.staservice.service.StatisticsDailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 网站统计日数据 前端控制器
 * </p>
 *
 * @author fushengroumeng
 * @since 2022-03-07
 */
@RestController
@RequestMapping("/staservice/statistics-daily")
public class StatisticsDailyController {

    @Autowired
    private StatisticsDailyService staService;

    //统计某一天注册人数,生成统计数据
    @PostMapping("registerCount/{day}")
    public Result registerCount(@PathVariable String day) {
        staService.registerCount(day);
        return Result.ok();
    }

    //图表显示，返回两部分数据，日期json数组，数量json数组
    @GetMapping("showData/{type}/{begin}/{end}")
    public Result showData(@PathVariable String type, @PathVariable String begin,
                           @PathVariable String end) {
        Map<String,Object> map = staService.getShowData(type,begin,end);
        return Result.ok().data(map);
    }


}

