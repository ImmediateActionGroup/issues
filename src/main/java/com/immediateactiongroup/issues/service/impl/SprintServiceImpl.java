package com.immediateactiongroup.issues.service.impl;

import com.immediateactiongroup.issues.dto.SprintDTO;
import com.immediateactiongroup.issues.service.SprintService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/7/31 下午3:38
 */

@Service
@Slf4j
public class SprintServiceImpl implements SprintService {
    @Override
    public List<SprintDTO> queryAllByProjectId(Long projectId) {
        // TODO: 2017/11/8  
        return null;
    }

    @Override
    public SprintDTO querySingleById(Long sprintId) {
        System.out.println("hello, tester");
        // TODO: 2017/11/8  
        return null;
    }
}
