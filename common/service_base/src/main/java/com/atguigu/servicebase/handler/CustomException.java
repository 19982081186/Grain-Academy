package com.atguigu.servicebase.handler;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 自定义异常处理类
 */
@Data
@AllArgsConstructor  //生成有参数构造方法
@NoArgsConstructor  //生成无参数构造方法
public class CustomException extends RuntimeException{

    @ApiModelProperty(value = "状态码")
    private Integer code;

    @ApiModelProperty(value = "异常信息")
    private String msg;
}
