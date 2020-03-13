package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.result.CommonResult;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {


    @Autowired
    private PaymentService paymentService;


    @Value("${server.port}")
    private String sercerPort;


    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){

        int result = paymentService.create(payment);
        if(result <= 0){
            return new CommonResult(400,"插入数据失败,server port:" + sercerPort,null);
        }
        return new CommonResult(200,"插入数据成功,server port:" + sercerPort,result);
    }


    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){

        Payment payment = paymentService.getPaymentById(id);
        if(payment == null){
            return new CommonResult(400,"查询失败,server port:" + sercerPort,null);
        }
        return new CommonResult(200,"查询成功,server port:" + sercerPort,payment);
    }

    /**
     * ribbo 手写负载均衡算法测试
     * @return
     */
    @GetMapping(value = "/payment/lb")
    public String paymentLB(){
        return sercerPort;
    }




}
