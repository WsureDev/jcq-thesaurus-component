package top.wsure.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface TableMapper {
    boolean hasTable(String name);

    int createNewGroup(@Param("tableName") String tableName);

    int copyLexicon(Map<String,String> groups);

    int deleteLexicon(String groupId);

    int resetSequence(String groupId);
}
