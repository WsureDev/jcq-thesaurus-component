package top.wsure.dao;

import top.wsure.entity.Setting;

import java.util.List;

public interface SettingMapper {
    int insert(Setting record);

    int insertSelective(Setting record);

    List<Setting> querySettings();
}