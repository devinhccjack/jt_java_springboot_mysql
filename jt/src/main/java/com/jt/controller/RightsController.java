package com.jt.controller;

import com.jt.pojo.Rights;
import com.jt.service.RightsService;
import com.jt.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/rights")
public class RightsController {

    @Autowired
    private RightsService rightsService;

    /**
     * url: 请求路径 /rights/getRightsList
     * 参数: 无
     * 类型: GET
     * 响应数据: SysResult对象(rightsList数据返回)
     */
    @GetMapping("/getRightsList")
    public SysResult getRightsList(){

        List<Rights> list = rightsService.getRightsList();
        return SysResult.success(list);
    }

}
