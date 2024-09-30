package com.aston.home.lab.userservicelab.integration;

import com.aston.home.lab.userservicelab.domain.dto.AccountDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "app-billservice", url = "http://app-billservice:8190")
public interface BillServiceFeignClient {

    @GetMapping("/app/v1/account/user/{userId}")
    List<AccountDTO> getUserAccountsById(@PathVariable("userId") String id);

}
