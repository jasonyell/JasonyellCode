package jasonyell.mapper;

import jasonyell.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Test {

    User query(Integer id);
}
