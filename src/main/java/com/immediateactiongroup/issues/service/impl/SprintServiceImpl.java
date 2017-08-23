package com.immediateactiongroup.issues.service.impl;

import com.immediateactiongroup.issues.dto.SprintDTO;
import com.immediateactiongroup.issues.service.SprintService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/7/31 下午3:38
 */

@Service
public class SprintServiceImpl implements SprintService {
    @Override
    public List<SprintDTO> queryAllByProjectId(Long projectId) {
        return null;
    }

    @Override
    public SprintDTO queryById(Long sprintId) {
        System.out.println("hello, tester");
        return null;
    }
}
