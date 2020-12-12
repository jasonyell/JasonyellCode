package jasonyell.service;

import jasonyell.mapper.MemberMapper;
import jasonyell.model.Award;
import jasonyell.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberMapper memberMapper;

    public List<Member> query(Member member) {
        return memberMapper.selectByCondition(member);
    }
}
