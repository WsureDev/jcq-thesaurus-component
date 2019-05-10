package top.wsure.dao;

import top.wsure.entity.Lexicon;

public interface LexiconMapper {
    int deleteByPrimaryKey(Integer wordId);

    int insert(Lexicon record);

    int insertSelective(Lexicon record);

    Lexicon selectByPrimaryKey(Integer wordId);

    int updateByPrimaryKeySelective(Lexicon record);

    int updateByPrimaryKey(Lexicon record);
}