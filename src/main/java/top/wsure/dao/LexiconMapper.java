package top.wsure.dao;

import top.wsure.entity.Lexicon;
import top.wsure.entity.LexiconDto;

import java.util.List;

public interface LexiconMapper {
    int deleteByPrimaryKey(LexiconDto record);

    int insert(LexiconDto record);

    int insertSelective(LexiconDto record);

    LexiconDto selectByPrimaryKey(LexiconDto record);

    int updateByPrimaryKeySelective(LexiconDto record);

    int updateByPrimaryKey(LexiconDto record);

    List<Lexicon> selectByQuestion(LexiconDto record);

    List<Lexicon> queryLexicon(LexiconDto record);
}