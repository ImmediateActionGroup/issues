package com.immediateactiongroup.issues.service.impl;

import com.immediateactiongroup.issues.commons.enums.BizTagEnum;
import com.immediateactiongroup.issues.service.IdGenerateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author weixueshan
 * @date 2017/12/6 17:18
 */
@Slf4j
@Service
public class BaseService {
    @Autowired
    private IdGenerateService idGenerateService;

    protected Long generateId(BizTagEnum bizTagEnum){
        return idGenerateService.generateId(bizTagEnum);
    }
}
