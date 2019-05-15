package top.wsure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wsure.dao.SettingMapper;
import top.wsure.entity.Setting;

import java.util.List;

@Service
public class SettingService {
    @Autowired
    private SettingMapper settingMapper;

    public int insert(Setting record){
        return settingMapper.insert(record);
    }

    public List<Setting> querySettings(){
        return settingMapper.querySettings();
    }

}
