package kopo.poly.service.impl;


import kopo.poly.dto.UserDTO;

import kopo.poly.persistance.mapper.IUserMapper;
import kopo.poly.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service("UserService")
public class UserService implements IUserService {
    private final IUserMapper userMapper;
    @Autowired
    public UserService(IUserMapper userMapper){
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDTO> getUserList() throws Exception{
        return userMapper.getUserList();
    }

    @Override
    public int InsertUserInfo(UserDTO pDTO) throws Exception {
        return userMapper.InsertUserInfo(pDTO);
    }
}
