package top.wsure.dao;

import top.wsure.entity.Disable;

import java.util.List;

public interface DisableMapper {
    int insert(Disable record);

    int insertSelective(Disable record);

    int delete(Disable disable);

    List<Disable> queryDisable(Disable disable);

    Disable selectByQq(Disable disable);

}