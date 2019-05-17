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

    public boolean hasTable(long groupId){
        return tableMapper.hasTable(tableName(groupId));
    }

    public boolean createNewGroup(long groupId){
        tableMapper.createNewGroup(tableName(groupId));
        return hasTable(groupId);
    }

    public int copyLexicon(long fromGroupId,long toGroupId){
        return tableMapper.copyLexicon(new HashMap<String, String>(){
            {
                put("fromGroupId",tableName(fromGroupId));
                put("toGroupId",tableName(toGroupId));
            }
        });
    }

    public int deleteLexicon(long groupId){
        tableMapper.deleteLexicon(tableName(groupId));
        tableMapper.resetSequence(tableName(groupId));
    }

    private String tableName(long groupId){
        return GROUP_PRE+groupId;
    }
}
