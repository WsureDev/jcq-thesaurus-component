package top.wsure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wsure.dao.TableMapper;

@Service
public class TableService {

    @Autowired
    private TableMapper tableMapper;

    public boolean hasTable(String name){
        return tableMapper.hasTable(name);
    }
}
