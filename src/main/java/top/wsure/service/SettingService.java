package top.wsure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wsure.dao.SettingMapper;
import top.wsure.entity.Setting;

@Service
public class SettingService {
    @Autowired
    private SettingMapper settingMapper;

    public int insert(Setting record){
        return settingMapper.insert(record);
    }

    public int insertSelective(Setting record){
        return settingMapper.insertSelective(record);
    }

    public Setting querySetting(){
        return settingMapper.querySetting();
    }
}
