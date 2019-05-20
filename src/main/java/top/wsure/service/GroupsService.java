package top.wsure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wsure.dao.GroupsMapper;
import top.wsure.entity.Groups;
@Service
public class GroupsService {
    @Autowired
    private GroupsMapper groupsMapper;

    public int deleteByPrimaryKey(Long groupId){
        return groupsMapper.deleteByPrimaryKey(groupId);
    }

    public int insert(Groups record){
        return groupsMapper.insert(record);
    }

    public int insertSelective(Groups record){
        return groupsMapper.insertSelective(record);
    }

    public Groups selectByPrimaryKey(Long groupId){
        return groupsMapper.selectByPrimaryKey(groupId);
    }

    public int updateByPrimaryKeySelective(Groups record){
        return groupsMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Groups record){
        return groupsMapper.updateByPrimaryKey(record);
    }
}
