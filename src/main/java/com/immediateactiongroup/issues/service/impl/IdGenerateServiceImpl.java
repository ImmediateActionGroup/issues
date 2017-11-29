package com.immediateactiongroup.issues.service.impl;

import com.immediateactiongroup.issues.commons.enums.BizTagEnum;
import com.immediateactiongroup.issues.service.IdGenerateService;
import com.immediateactiongroup.issues.utils.IdWorker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author weixueshan
 * @date 2017/11/29 17:44
 */
@Service
@Slf4j
public class IdGenerateServiceImpl implements IdGenerateService {
    @Autowired
    private IdWorker idWorker;

    @Override
    public Long generateId(BizTagEnum bizTagEnum) {
        return idWorker.nextId(bizTagEnum.getValue());
    }
}
