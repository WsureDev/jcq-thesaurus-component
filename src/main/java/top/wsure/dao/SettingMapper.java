package top.wsure.dao;

import top.wsure.entity.Setting;

public interface SettingMapper {
    int insert(Setting record);

    int insertSelective(Setting record);

    Setting querySetting();
}