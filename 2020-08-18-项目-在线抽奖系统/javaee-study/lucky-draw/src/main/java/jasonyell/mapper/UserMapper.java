package jasonyell.mapper;

import jasonyell.base.BaseMapper;
import jasonyell.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    User login(User user);
}