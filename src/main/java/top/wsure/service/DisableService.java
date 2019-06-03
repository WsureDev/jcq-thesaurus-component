package top.wsure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wsure.dao.DisableMapper;
import top.wsure.entity.Disable;

import java.util.List;

@Service
public class DisableService {
    @Autowired
    private DisableMapper disableMapper;

    public int insert(Disable record){
        return disableMapper.insert(record);
    }

    public int insertSelective(Disable record){
        return disableMapper.insertSelective(record);
    }

    public int delete(Disable disable){
        return disableMapper.delete(disable);
    }

    public List<Disable> queryDisable(Disable disable){
        return disableMapper.queryDisable(disable);
    }

    public Disable selectByQq(Disable disable){
        return disableMapper.selectByQq(disable);
    }
}
