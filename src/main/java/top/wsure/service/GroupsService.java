package top.wsure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wsure.dao.GroupsMapper;
import top.wsure.entity.Groups;
@Service
public class GroupsService {
    @Autowired
    private GroupsMapper groupsMapper;
    @Autowired
    private TableService tableService;

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

    public int setGroup(Groups groups){
        if(!tableService.hasTable(groups.getGroupId()))
        {
            tableService.createNewGroup(groups.getGroupId());
        }
        Groups g = groupsMapper.selectByPrimaryKey(groups.getGroupId());
        int res = 0;
        if(g==null){
            res = groupsMapper.insert(groups);
        } else {
            res = groupsMapper.updateByPrimaryKeySelective(groups);
        }
        return res;
    }
}
