package com.atguigu.educms.controller;


import com.atguigu.commonutils.Result;
import com.atguigu.educms.entity.CrmBanner;
import com.atguigu.educms.service.CrmBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 首页banner表 前端控制器
 * </p>
 *
 * @author fushengroumeng
 * @since 2022-02-26
 */
@RestController
@RequestMapping("/educms/bannerfront")
@CrossOrigin
public class CrmBannerController {
    @Autowired
    private CrmBannerService crmBannerService;

    //查询所有banner
    @GetMapping("getAllBanner")
    public Result getAllBanner() {
        List<CrmBanner> list = crmBannerService.selectAllBanner();
        return Result.ok().data("list",list);
    }
}

