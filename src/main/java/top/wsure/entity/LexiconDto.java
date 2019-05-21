package top.wsure.entity;

public class LexiconDto extends Lexicon {
    private String tableName;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public LexiconDto(Lexicon lexicon,String tableName) {
        this.setAnswer(lexicon.getAnswer());
        this.setQuestion(lexicon.getQuestion());
        this.setType(lexicon.getType());
        this.setCommitTime(lexicon.getCommitTime());
        this.setCommitUser(lexicon.getCommitUser());
        this.setWordId(lexicon.getWordId());
        this.tableName = tableName;
    }
}
