package jasonyell.mapper;

import jasonyell.base.BaseMapper;
import jasonyell.model.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper extends BaseMapper<Member> {
}