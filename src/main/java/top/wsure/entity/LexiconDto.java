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
        this.setTableName(tableName);
    }

    @Override
    public String toString() {
        return "LexiconDto{" +
                "tableName='" + tableName + '\'' +
                "wordId=" + getWordId() +
                ", question='" + getQuestion() + '\'' +
                ", answer='" + getAnswer() + '\'' +
                ", type=" + getType() +
                ", commitTime='" + getCommitTime() + '\'' +
                ", commitUser=" + getCommitUser() +
                '}';
    }
}
