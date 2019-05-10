package top.wsure.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@PropertySource("classpath:config.properties")
public class Configs {
    public static Configs configs;

    @Value("${thesaurus.AppId}")
    private String AppId;

    @Value("${thesaurus.master}")
    private Long master;

    public String getAppId() {
        return AppId;
    }

    public Long getMaster() {
        return master;
    }

    @PostConstruct
    public void init(){
        configs = this;

    }
}
