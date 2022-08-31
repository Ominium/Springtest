package kopo.poly.persistance.mapper;


import kopo.poly.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IUserMapper {
    int InsertUserInfo(UserDTO pDTO) throws Exception;

    List<UserDTO> getUserList() throws Exception;
}
