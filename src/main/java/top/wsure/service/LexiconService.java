package top.wsure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wsure.dao.LexiconMapper;
import top.wsure.entity.Lexicon;
import top.wsure.entity.LexiconDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class LexiconService {
    @Autowired
    private LexiconMapper lexiconMapper;

    public int deleteByPrimaryKey(LexiconDto record){
        return lexiconMapper.deleteByPrimaryKey(record);
    }

    public int insert(LexiconDto record){
        return lexiconMapper.insert(record);
    }

    public int insertSelective(LexiconDto record){
        System.out.println(record.toString());
        return lexiconMapper.insertSelective(record);
    }

    public LexiconDto selectByPrimaryKey(LexiconDto record){
        return lexiconMapper.selectByPrimaryKey(record);
    }

    public int updateByPrimaryKeySelective(LexiconDto record){
        return lexiconMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(LexiconDto record){
        return lexiconMapper.updateByPrimaryKey(record);
    }

    public List<Lexicon> selectByQuestion(LexiconDto record){
        List<Lexicon> lexicons = selectByQuestion(record);
        if(record.getType().intValue()<3){
            return lexicons;
        }
        List<Lexicon> regexRes = new ArrayList<>();
        for (Lexicon lexicon:lexicons){
            if(record.getQuestion().matches(lexicon.getAnswer())){
                regexRes.add(lexicon);
            }
        }
        return regexRes;
    }

}
