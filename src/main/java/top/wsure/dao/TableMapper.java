package top.wsure.dao;

import java.util.Map;

public interface TableMapper {
    boolean hasTable(String name);

    int createNewGroup(String groupId);

    int copyLexicon(Map<String,String> groups);

    int deleteLexicon(String groupId);

    int resetSequence(String groupId);
}
