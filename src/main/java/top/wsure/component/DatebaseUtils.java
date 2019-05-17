package top.wsure.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.wsure.config.Option;
import top.wsure.config.RegexString;
import top.wsure.dao.ManageMapper;
import top.wsure.dao.SettingMapper;
import top.wsure.entity.Setting;
import top.wsure.service.ManageService;
import top.wsure.service.SettingService;
import top.wsure.service.TableService;

import javax.annotation.PostConstruct;

import java.lang.reflect.Field;
import java.util.List;

import static com.sobte.cqp.jcq.event.JcqApp.CQ;

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

    @Autowired
    private ManageService manageService;

    public ManageService getManageService() {
        return manageService;
    }

    @PostConstruct
    public void init(){
        datebaseUtils = this;
        CQ.logInfo("DatebaseUtils","init");
        setOption();
    }

    /**
     * 初始化配置关键字
     */
    public void setOption(){
        List<Setting> settings = settingService.querySettings();
        Option option = new Option();
        for (Setting s:settings){
            try {
                Field f = option.getClass().getDeclaredField(s.getKey());
                f.setAccessible(true);
                f.set(option, s.getValue());
            } catch (Exception e) {
                //非法关键字，无法配置到option类中
                CQ.logInfo("catch error key :"+s.getKey(),"value:"+s.getValue());
                continue;
            }
        }

        CQ.logInfo("RegexString",""+RegexString.regexs.size());
    }
}
