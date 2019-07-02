package top.wsure.service;

import com.sobte.cqp.jcq.message.CQCode;
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
    @Autowired
    private TableService tableService;

    public int deleteByPrimaryKey(LexiconDto record){
        return lexiconMapper.deleteByPrimaryKey(record);
    }

    public int insert(LexiconDto record){
        return lexiconMapper.insert(record);
    }

    public int insertSelective(LexiconDto record){
        if(!tableService.hasTable(record.getTableName()))
        {
            if(!tableService.createNewGroup(record.getTableName()))
                return 0;
        }
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
        List<Lexicon> lexicons = lexiconMapper.selectByQuestion(record);
        List<Lexicon> res = new ArrayList<>();
        for (Lexicon lexicon:lexicons){
            switch (lexicon.getType())
            {
                case 1:
                case 2:
                    res.add(lexicon);break;
                case 3:
                    if(CQCode.decode(record.getQuestion()).matches(CQCode.decode(lexicon.getQuestion()))){
                        res.add(lexicon);
                    }
                    break;
            }

        }
        return res;
    }

    public List<Lexicon> queryLexicon(LexiconDto record){
        return lexiconMapper.queryLexicon(record);
    }
}
