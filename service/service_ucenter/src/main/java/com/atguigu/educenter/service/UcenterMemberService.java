package com.atguigu.educenter.service;

import com.atguigu.educenter.entity.UcenterMember;
import com.atguigu.educenter.entity.vo.RegisterVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author fushengroumeng
 * @since 2022-02-27
 */
public interface UcenterMemberService extends IService<UcenterMember> {

    //登录判断手机号，密码是否正确，返回token值
    public String panDuanuCenterMember(UcenterMember ucenterMember);

    //注册
    public void register(RegisterVo registerVo);

    //根据id查询用户信息
    public UcenterMember getOpenIdMember(String openid);

    Integer countRegisterDay(String day);

}
