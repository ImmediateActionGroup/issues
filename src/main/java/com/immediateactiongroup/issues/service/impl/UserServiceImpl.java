package com.immediateactiongroup.issues.service.impl;

import com.immediateactiongroup.issues.commons.exception.BusinessException;
import com.immediateactiongroup.issues.commons.exception.ExceptionEnum;
import com.immediateactiongroup.issues.dto.AddUserDTO;
import com.immediateactiongroup.issues.dto.UserDTO;
import com.immediateactiongroup.issues.dto.validate.UserUpdateDTO;
import com.immediateactiongroup.issues.model.Role;
import com.immediateactiongroup.issues.model.User;
import com.immediateactiongroup.issues.model.repository.RoleRepository;
import com.immediateactiongroup.issues.model.repository.UserRepository;
import com.immediateactiongroup.issues.service.UserService;
import com.immediateactiongroup.issues.utils.DateUtils;
import com.immediateactiongroup.issues.utils.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/9/3 下午10:17
 */
@Service("userService")
@Slf4j
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDTO querySingleUserById(Long userId) {
       User user = userRepository.findById(userId);
        if(Objects.isNull(user)){
            return null;
        }
       return UserDTO.builder()
               .id(user.getId())
               .username(user.getUsername())
               .nickname(user.getNickname())
               .enable(user.getEnable())
               .createTime(user.getCreateTime())
               .lastLoginTime(user.getLastLoginTime())
               .lastModifyTime(user.getLastModifyTime())
               .build();
    }

    @Override
    public UserDTO querySingleUserByUsername(String username) {
        // TODO: 2017/11/8 wheather validate the username
        User user = userRepository.findByUsername(username);
        if(Objects.isNull(user)){
            return null;
        }
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .nickname(user.getNickname())
                .enable(user.getEnable())
                .createTime(user.getCreateTime())
                .lastLoginTime(user.getLastLoginTime())
                .lastModifyTime(user.getLastModifyTime())
                .build();
    }

    @Override
    public void changeUserPassword(Long userId, String oldPassword, String newPassword) throws BusinessException {
        User waitUpdateUser = userRepository.findById(userId);

        if(waitUpdateUser == null){
            throw new BusinessException(ExceptionEnum.USER_NOT_EXIST);
        }

        final String encodeOldPassword = SecurityUtils.encode(oldPassword);

        if(!waitUpdateUser.getPassword().equals(encodeOldPassword)){
            throw new BusinessException(ExceptionEnum.USER_OLDPWD_ERROR);
        }
        waitUpdateUser.setLastModifyTime(DateUtils.getNow());
        userRepository.save(waitUpdateUser);
    }

    @Override
    public void changeUserPassword(Long userId, String newPassword) throws BusinessException {
        User waitUpdateUser = userRepository.findById(userId);

        if(waitUpdateUser == null){
            throw new BusinessException(ExceptionEnum.USER_NOT_EXIST);
        }

        waitUpdateUser.setPassword(SecurityUtils.encode(newPassword));
        waitUpdateUser.setLastModifyTime(DateUtils.getNow());
        userRepository.save(waitUpdateUser);
    }

    @Override
    public UserDTO updateUserInfo(UserUpdateDTO userUpdateDTO) throws BusinessException {
        User waitUpdateUser = userRepository.findById(userUpdateDTO.getId());

        if(waitUpdateUser == null){
            throw new BusinessException(ExceptionEnum.USER_NOT_EXIST);
        }

        waitUpdateUser.setNickname(userUpdateDTO.getNickname());
        waitUpdateUser.setLastModifyTime(DateUtils.getNow());
        waitUpdateUser = userRepository.save(waitUpdateUser);

        return UserDTO.build(waitUpdateUser.getId(),
                waitUpdateUser.getNickname(),
                waitUpdateUser.getUsername(),
                waitUpdateUser.getEnable(),
                waitUpdateUser.getCreateTime(),
                waitUpdateUser.getLastModifyTime(),
                waitUpdateUser.getLastLoginTime());
    }

    @Override
    public UserDTO addUser(AddUserDTO addUserDTO) throws BusinessException{
        // step1: check the username is repeat
        UserDTO existUser = querySingleUserByUsername(addUserDTO.getUsername());
        if(Objects.nonNull(existUser)){
            log.error("添加用户出错, 用户名为：{}的用户已经存在", addUserDTO.getUsername());
            throw new BusinessException(ExceptionEnum.USER_IS_EXIST);
        }
        // step2: 对密码进行加密操作
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String encodePwd = encoder.encode(addUserDTO.getPassword());
        Role role = roleRepository.findByName(addUserDTO.getRoleEnum().name());
        // step3: add the user to database
        User user = new User(addUserDTO.getUsername(), encodePwd, role);
        user = userRepository.save(user);
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
        Long userId = userRepository.existUserById(id);
        if(userId != null){
            LOGGER.info("删除用户 id 为" + id + " 用户存在，删除用户");
            userRepository.delete(id);
        }else {
            LOGGER.error("删除用户出错: id 为" + id + "的用户不存在，抛出异常");
            throw new BusinessException(ExceptionEnum.USER_NOT_EXIST);
        }
    }

    @Override
    public List<UserDTO> queryAll() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();
        for(User user : users){
            userDTOS.add(new UserDTO(user));
        }
        return userDTOS;
    }
}
