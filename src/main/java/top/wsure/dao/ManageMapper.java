package top.wsure.dao;

import top.wsure.entity.Manage;

public interface ManageMapper {
    int deleteByPrimaryKey(Long manageId);

    int insert(Manage record);

    int insertSelective(Manage record);

    Manage selectByPrimaryKey(Long manageId);

    int updateByPrimaryKeySelective(Manage record);

    int updateByPrimaryKey(Manage record);
}