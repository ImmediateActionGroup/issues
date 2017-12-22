package com.immediateactiongroup.issues.service;

import com.immediateactiongroup.issues.commons.exception.BusinessException;
import com.immediateactiongroup.issues.dto.IssuesAddDTO;
import com.immediateactiongroup.issues.dto.IssuesDTO;

import java.util.List;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/9/14 下午7:06
 */
public interface IssuesService {
    /**
     * 增加issues
     * @param issuesAddDTO
     * @return
     * @throws BusinessException
     */
    IssuesDTO add(IssuesAddDTO issuesAddDTO) throws BusinessException;

    /**
     * 删除issues by id
     * @param issuesId
     * @throws BusinessException
     */
    void delete(Long issuesId) throws BusinessException;

    /**
     * 删除 issues by ids
     * @param issuesIds
     * @throws BusinessException
     */
    void deleteSome(Long ... issuesIds) throws BusinessException;

    /**
     * 查询issues by id
     * @param issuesId
     * @return
     * @throws BusinessException
     */
    IssuesDTO querySingleById(Long issuesId) throws BusinessException;

    /**
     * 条件查询
     * @return
     * @throws BusinessException
     */
    List<IssuesDTO> queryAllByConditions() throws BusinessException;

}
