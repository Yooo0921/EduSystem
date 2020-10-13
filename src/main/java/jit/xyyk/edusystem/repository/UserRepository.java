package jit.xyyk.edusystem.repository;

import jit.xyyk.edusystem.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
//@Repository
public interface UserRepository {
    public User getInfo(String email);
}
