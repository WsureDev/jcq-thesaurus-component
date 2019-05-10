package top.wsure.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.wsure.dao.SettingMapper;
import top.wsure.service.SettingService;
import top.wsure.service.TableService;

import javax.annotation.PostConstruct;

@Component
public class DatebaseUtils {

    public static DatebaseUtils datebaseUtils;

    @Autowired
    private SettingService settingService;

    public TableService getTableService() {
        return tableService;
    }

    @Autowired
    private TableService tableService;

    public SettingService getSettingService() {
        return settingService;
    }

    @PostConstruct
    public void init(){
        datebaseUtils = this;
    }
}
