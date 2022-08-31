package kopo.poly.service;

import kopo.poly.dto.UserDTO;

import java.util.List;

public interface IUserService {
    List<UserDTO> getUserList() throws Exception;

    int InsertUserInfo(UserDTO pDTO) throws Exception;
}
