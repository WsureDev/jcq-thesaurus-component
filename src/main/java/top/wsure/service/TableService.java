package top.wsure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wsure.dao.TableMapper;

import java.util.HashMap;

@Service
public class TableService {
    final public static String GROUP_PRE = "group_";

    @Autowired
    private TableMapper tableMapper;

    public boolean hasTable(String name){
        return tableMapper.hasTable(name);
    }

    public boolean hasTable(Long groupId){
        return tableMapper.hasTable(tableName(groupId));
    }

    public boolean createNewGroup(Long groupId){
        tableMapper.createNewGroup(tableName(groupId));
        return hasTable(groupId);
    }

    public int copyLexicon(Long fromGroupId,Long toGroupId){
        return tableMapper.copyLexicon(new HashMap<String, String>(){
            {
                put("fromGroupId",tableName(fromGroupId));
                put("toGroupId",tableName(toGroupId));
            }
        });
    }

    public int deleteLexicon(Long groupId){
        tableMapper.deleteLexicon(tableName(groupId));
        return tableMapper.resetSequence(tableName(groupId));
    }

    private String tableName(Long groupId){
        return GROUP_PRE+groupId;
    }
}
