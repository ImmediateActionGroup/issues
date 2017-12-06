package com.immediateactiongroup.issues.service;

import com.immediateactiongroup.issues.commons.enums.BizTagEnum;

/**
 * @author weixueshan
 * @date 2017/11/29 17:36
 */
public interface IdGenerateService {

    Long generateId(BizTagEnum bizTagEnum);
}
