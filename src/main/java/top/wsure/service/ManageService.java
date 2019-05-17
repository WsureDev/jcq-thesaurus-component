package top.wsure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wsure.dao.ManageMapper;
import top.wsure.entity.Manage;

@Service
public class ManageService {
    @Autowired
    private ManageMapper manageMapper;

    public int deleteByPrimaryKey(Integer manageId){
        return manageMapper.deleteByPrimaryKey(manageId);
    }

    public int insert(Manage record){
        return manageMapper.insert(record);
    }

    public int insertSelective(Manage record){
        return manageMapper.insertSelective(record);
    }

    public Manage selectByPrimaryKey(Integer manageId){
        return manageMapper.selectByPrimaryKey(manageId);
    }

    public int updateByPrimaryKeySelective(Manage record){
        return manageMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Manage record){
        return manageMapper.updateByPrimaryKey(record);
    }
}
