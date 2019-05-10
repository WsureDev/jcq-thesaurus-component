package top.wsure.dao;

import top.wsure.entity.Groups;

public interface GroupsMapper {
    int deleteByPrimaryKey(Integer groupId);

    int insert(Groups record);

    int insertSelective(Groups record);

    Groups selectByPrimaryKey(Integer groupId);

    int updateByPrimaryKeySelective(Groups record);

    int updateByPrimaryKey(Groups record);
}