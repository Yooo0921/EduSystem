package jit.xyyk.edusystem.repository;

import jit.xyyk.edusystem.bean.Auser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminRepository {
    public List<Auser> login(Auser auser);
}
