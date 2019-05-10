package top.wsure.entity;

public class Lexicon {
    private Integer wordId;

    private String question;

    private String answer;

    private Integer type;

    private Integer commitTime;

    private Integer commitUser;

    public Integer getWordId() {
        return wordId;
    }

    public void setWordId(Integer wordId) {
        this.wordId = wordId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(Integer commitTime) {
        this.commitTime = commitTime;
    }

    public Integer getCommitUser() {
        return commitUser;
    }

    public void setCommitUser(Integer commitUser) {
        this.commitUser = commitUser;
    }
}