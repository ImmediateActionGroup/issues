package com.immediateactiongroup.issues.config;

import com.immediateactiongroup.issues.utils.IdWorker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author xueshan.wei
 * @Date 2017/11/18 下午6:51
 */
@Configuration
@Slf4j
public class IdCenterConfig {

    /**
     * ID 中心的id
     */
    @Value("${idcenter.id}")
    private String idStr;
    /**
     * ID中心的开始时间戳
     */
    @Value("${idcenter.start-stmp}")
    private String startStmpStr;

    @Bean
    IdWorker idWorker(){
        long centerid = Long.parseLong(idStr);
        long startStmp = Long.parseLong(startStmpStr);
        log.info("idcenter start, id={}, start-stmp={}", centerid, startStmp);
        return new IdWorker(startStmp, centerid);
    }


}
