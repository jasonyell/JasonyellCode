package jasonyell.service;

import jasonyell.mapper.AwardMapper;
import jasonyell.model.Award;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AwardService {
    @Autowired
    private AwardMapper awardMapper;

    public List<Award> query(Award award) {
        return awardMapper.query();
    }
}
