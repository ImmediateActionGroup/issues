package com.immediateactiongroup.issues.service.impl;

import com.immediateactiongroup.issues.commons.exception.BusinessException;
import com.immediateactiongroup.issues.commons.exception.ExceptionEnum;
import com.immediateactiongroup.issues.dto.AddUserDTO;
import com.immediateactiongroup.issues.dto.UserDTO;
import com.immediateactiongroup.issues.model.Role;
import com.immediateactiongroup.issues.model.User;
import com.immediateactiongroup.issues.model.repository.RoleRepository;
import com.immediateactiongroup.issues.model.repository.UserRepository;
import com.immediateactiongroup.issues.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/9/3 下午10:17
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDTO addUser(AddUserDTO addUserDTO) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String encodePwd = encoder.encode(addUserDTO.getPassword());
        Role role = roleRepository.findByName(addUserDTO.getRoleEnum().name());

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
            LOGGER.debug("[user service] id 为" + id + " 用户存在，删除用户");
            userRepository.delete(id);
        }else {
            LOGGER.debug("[user service] id 为" + id + "  用户不存在，抛出异常");
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
