package com.atguigu.springcloud.loadBanance;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBanacer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
