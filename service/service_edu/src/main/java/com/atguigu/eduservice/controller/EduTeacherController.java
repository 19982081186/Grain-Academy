package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.Result;
import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.entity.vo.TeacherQuery;
import com.atguigu.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author fushengroumeng
 * @since 2022-02-15
 */
@Api(description="讲师管理")
@RestController
@RequestMapping("/eduservice/teacher")
@CrossOrigin  //解决跨域问题
public class EduTeacherController {

    //Service注入
    @Autowired
    private EduTeacherService eduTeacherService;

    //查找所有的讲师列表
    @ApiOperation(value = "所有讲师列表")
    @GetMapping("findAllTeacher")
    public Result findAllTeacher() {
        List<EduTeacher> list = eduTeacherService.list(null);
        return Result.ok().data("items", list);
    }

    //根据id逻辑删除某讲师信息
    @ApiOperation(value = "根据ID删除讲师")
    @DeleteMapping("{id}")
    public Result deleteTeacher(@PathVariable String id) {
        boolean flg = eduTeacherService.removeById(id);
        if (flg) {
            return Result.ok();
        } else {
            return Result.error();
        }
    }

    //分页查询讲师列表
    @ApiOperation(value = "分页查询讲师列表")
    @GetMapping("pageTeacher/{current}/{limit}") //current 当前页     limit 每页记录数
    public Result pageListTeacher(@PathVariable Long current, @PathVariable Long limit) {
        //创建page对象
        Page<EduTeacher> pageTeacher = new Page<>(current, limit);

        //调用方法，底层封装，把分页所有数据封装到pageTeacher对象中
        eduTeacherService.page(pageTeacher, null);

        long total = pageTeacher.getTotal(); //总记录数
        List<EduTeacher> records = pageTeacher.getRecords(); //数据list集合

        return Result.ok().data("total", total).data("rows", records);
    }

    //分页条件查询讲师列表
    @ApiOperation(value = "分页条件查询讲师列表")
    @PostMapping("pageTeacherQuery/{current}/{limit}")    //一定要使用PostMapping，可以携带请求体，GetMapping只能在路径中携带参数
    public Result pageTeacherQuery(@PathVariable Long current, @PathVariable Long limit, @RequestBody(required = false) TeacherQuery teacherQuery) {
        //创建page对象
        Page<EduTeacher> eduTeacherPage = new Page<>(current, limit);
        //创建条件
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        System.out.println(teacherQuery);
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();
        Integer level = teacherQuery.getLevel();
        String name = teacherQuery.getName();
        if (!StringUtils.isEmpty(name)) {
            wrapper.like("name", name);
        }
        if (!StringUtils.isEmpty(level)) {
            wrapper.eq("level", level);
        }
        if (!StringUtils.isEmpty(begin)) {
            wrapper.ge("gmt_create", begin);
        }
        if (!StringUtils.isEmpty(end)) {
            wrapper.ge("gmt_create", end);
        }
        //调用方法，底层封装，把分页所有数据封装到pageTeacher对象中
        eduTeacherService.page(eduTeacherPage, wrapper);

        long total = eduTeacherPage.getTotal();
        List<EduTeacher> records = eduTeacherPage.getRecords();

        return Result.ok().data("total", total).data("rows", records);
    }

    //添加讲师
    @ApiOperation(value = "添加讲师")
    @PostMapping("addTeacher")
    public Result addTeacher(@RequestBody EduTeacher eduTeacher) {
        boolean save = eduTeacherService.save(eduTeacher);
        if (save) {
            return Result.ok();
        } else {
            return Result.error();
        }
    }

    //根据id查询讲师
    @ApiOperation(value = "根据id查询讲师")
    @GetMapping("getTeacher/{id}")
    public Result fingTeacherId(@PathVariable String id) {
        //自定义异常测试
//        try{
//            int i=10/0;
//        }catch (Exception e){
//            throw new CustomException(200,"出现自定义异常");
//        }
        System.out.println(id);
        EduTeacher eduTeacher = eduTeacherService.getById(id);
        return Result.ok().data("teacher", eduTeacher);
    }

    //根据id修改讲师
    @ApiOperation(value = "根据id修改讲师")
    @PostMapping("updateTeacher")
    public Result updateTeacher(@RequestBody EduTeacher eduTeacher) {
        System.out.println(eduTeacher);
        boolean b = eduTeacherService.updateById(eduTeacher);
        if (b) {
            return Result.ok();
        } else {
            return Result.error();
        }
    }
}

