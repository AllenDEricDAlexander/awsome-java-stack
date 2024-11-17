package top.atluofu.ssmp.mybatis;

import org.springframework.stereotype.Repository;
import top.atluofu.ssmp.mybatis.TUser;

@Repository
public interface TUserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);
}