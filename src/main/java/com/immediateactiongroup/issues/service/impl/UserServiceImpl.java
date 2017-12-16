package com.immediateactiongroup.issues.service.impl;

import com.immediateactiongroup.issues.commons.enums.BizTagEnum;
import com.immediateactiongroup.issues.commons.enums.DeleteFlagEnum;
import com.immediateactiongroup.issues.commons.enums.UserRoleEnum;
import com.immediateactiongroup.issues.commons.exception.BusinessException;
import com.immediateactiongroup.issues.commons.exception.ExceptionEnum;
import com.immediateactiongroup.issues.dto.UserDTO;
import com.immediateactiongroup.issues.dto.validate.UserAddDTO;
import com.immediateactiongroup.issues.dto.validate.UserUpdateDTO;
import com.immediateactiongroup.issues.model.Role;
import com.immediateactiongroup.issues.model.User;
import com.immediateactiongroup.issues.model.UserRoles;
import com.immediateactiongroup.issues.model.dao.UserMapper;
import com.immediateactiongroup.issues.service.RoleService;
import com.immediateactiongroup.issues.service.UserRoleService;
import com.immediateactiongroup.issues.service.UserService;
import com.immediateactiongroup.issues.utils.DateUtils;
import com.immediateactiongroup.issues.utils.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/9/3 下午10:17
 */
@Service("userService")
@Slf4j
public class UserServiceImpl extends BaseService implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private RoleService roleService;

    private Long generateId(){
        return this.generateId(BizTagEnum.USER);
    }
    @Override
    public UserDTO querySingleUserById(Long userId) {
       User user = userMapper.selectByPrimaryKey(userId);
        if(Objects.isNull(user)){
            return null;
        }
       return UserDTO.builder()
               .id(user.getId())
               .username(user.getUsername())
               .nickname(user.getNickname())
               .createTime(user.getCreateTime())
               .lastLoginTime(user.getLastLoginTime())
               .lastModifyTime(user.getLastModifyTime())
               .build();
    }

    @Override
    public User querySingleUser(String username) {
        return userMapper.selectByName(username);
    }

    @Override
    public List<Role> queryUserRoles(Long userId) {
        List<Role> roles = null;
        List<UserRoles> userRoles = userRoleService.queryRolesByUserId(userId);
        if(Objects.nonNull(userRoles)){
            roles = new ArrayList<>();
            for(UserRoles item : userRoles){
                roles.add(roleService.queryById(item.getId()));
            }
        }
        return roles;
    }

    @Override
    public UserDTO querySingleUserByUsername(String username) {
        // TODO: 2017/11/8 wheather validate the username
        User user = userMapper.selectByName(username);
        if(Objects.isNull(user)){
            return null;
        }
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .nickname(user.getNickname())
                .createTime(user.getCreateTime())
                .lastLoginTime(user.getLastLoginTime())
                .lastModifyTime(user.getLastModifyTime())
                .build();
    }

    @Override
    public void changeUserPassword(Long userId, String oldPassword, String newPassword) throws BusinessException {
        User waitUpdateUser = userMapper.selectByPrimaryKey(userId);

        if(waitUpdateUser == null){
            throw new BusinessException(ExceptionEnum.USER_NOT_EXIST);
        }

        final String encodeOldPassword = SecurityUtils.encode(oldPassword);

        if(!waitUpdateUser.getPassword().equals(encodeOldPassword)){
            throw new BusinessException(ExceptionEnum.USER_OLDPWD_ERROR);
        }
        waitUpdateUser.setLastModifyTime(DateUtils.getNow());
        userMapper.updateByPrimaryKey(waitUpdateUser);
    }

    @Override
    public void changeUserPassword(Long userId, String newPassword) throws BusinessException {
        User waitUpdateUser = userMapper.selectByPrimaryKey(userId);

        if(waitUpdateUser == null){
            throw new BusinessException(ExceptionEnum.USER_NOT_EXIST);
        }

        waitUpdateUser.setPassword(SecurityUtils.encode(newPassword));
        waitUpdateUser.setLastModifyTime(DateUtils.getNow());
        userMapper.updateByPrimaryKey(waitUpdateUser);
    }

    @Override
    public UserDTO updateUserInfo(UserUpdateDTO userUpdateDTO) throws BusinessException {
        User waitUpdateUser = userMapper.selectByPrimaryKey(userUpdateDTO.getId());

        if(waitUpdateUser == null){
            throw new BusinessException(ExceptionEnum.USER_NOT_EXIST);
        }

        waitUpdateUser.setNickname(userUpdateDTO.getNickname());
        waitUpdateUser.setLastModifyTime(DateUtils.getNow());
        userMapper.updateByPrimaryKey(waitUpdateUser);

        return UserDTO.build(waitUpdateUser.getId(),
                waitUpdateUser.getNickname(),
                waitUpdateUser.getUsername(),
                1,
                waitUpdateUser.getCreateTime(),
                waitUpdateUser.getLastModifyTime(),
                waitUpdateUser.getLastLoginTime());
    }

    @Override
    public UserDTO addUser(UserAddDTO addUserDTO) throws BusinessException{
        // step1: check the username is repeat
        UserDTO existUser = querySingleUserByUsername(addUserDTO.getUsername());
        if(Objects.nonNull(existUser)){
            log.error("添加用户出错, 用户名为：{}的用户已经存在", addUserDTO.getUsername());
            throw new BusinessException(ExceptionEnum.USER_IS_EXIST);
        }
        // step2: 对密码进行加密操作
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String encodePwd = encoder.encode(addUserDTO.getPassword());
        // step3: add the user to database
//        User user = new User(addUserDTO.getUsername(), encodePwd, role);
        Long id = generateId();
        Date now = DateUtils.getNow();
        User user = User.builder()
                .id(id)
                .username(addUserDTO.getUsername())
                .password(encodePwd)
                .nickname("")
                .deleteFlag(DeleteFlagEnum.DELETE_FALSE.getValue())
                .lastModifyTime(now)
                .createTime(now)
                .build();
        userMapper.insert(user);
        /**
         * 添加角色
         */
        UserRoleEnum roleEnum = UserRoleEnum.index(addUserDTO.getRole());
        userRoleService.addUserRole(id, roleEnum);
        log.info("创建用户成功, {}", user.toString());
        return new UserDTO(user);
    }


    @Override
    public void deleteUsers(Long... ids) throws BusinessException {
        for(Long id : ids){
            deleteUser(id);
        }
    }

    @Override
    public void deleteUser(Long id) throws BusinessException{
        //判断用户是否存在
        userMapper.deleteByPrimaryKey(id);
        /*User user = userMapper.selectByPrimaryKey(id);
        if(userId != null){
            LOGGER.info("删除用户 id 为" + id + " 用户存在，删除用户");
            userRepository.delete(id);
        }else {
            LOGGER.error("删除用户出错: id 为" + id + "的用户不存在，抛出异常");
            throw new BusinessException(ExceptionEnum.USER_NOT_EXIST);
        }*/
    }

    @Override
    public List<UserDTO> queryAll() {
        List<User> users = userMapper.selectAll();
        List<UserDTO> userDTOS = new ArrayList<>();
        for(User user : users){
            userDTOS.add(new UserDTO(user));
        }
        return userDTOS;
    }
}
