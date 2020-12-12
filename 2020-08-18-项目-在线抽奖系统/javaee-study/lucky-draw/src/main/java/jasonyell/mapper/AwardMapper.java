package jasonyell.mapper;

import jasonyell.base.BaseMapper;
import jasonyell.model.Award;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AwardMapper extends BaseMapper<Award> {


    List<Award> query();
}