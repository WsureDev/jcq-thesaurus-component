package top.wsure.entity;

public class Setting {
    private Integer config;

    private Integer masterId;

    private String masterEmail;

    private String robotEmail;

    private String robotPassword;

    private String exactKey;

    private String vagueKey;

    private String regexKey;

    private String answerKey;

    private String deleteKey;

    private String queryKey;

    private String globalKey;

    public Integer getConfig() {
        return config;
    }

    public void setConfig(Integer config) {
        this.config = config;
    }

    public Integer getMasterId() {
        return masterId;
    }

    public void setMasterId(Integer masterId) {
        this.masterId = masterId;
    }

    public String getMasterEmail() {
        return masterEmail;
    }

    public void setMasterEmail(String masterEmail) {
        this.masterEmail = masterEmail == null ? null : masterEmail.trim();
    }

    public String getRobotEmail() {
        return robotEmail;
    }

    public void setRobotEmail(String robotEmail) {
        this.robotEmail = robotEmail == null ? null : robotEmail.trim();
    }

    public String getRobotPassword() {
        return robotPassword;
    }

    public void setRobotPassword(String robotPassword) {
        this.robotPassword = robotPassword == null ? null : robotPassword.trim();
    }

    public String getExactKey() {
        return exactKey;
    }

    public void setExactKey(String exactKey) {
        this.exactKey = exactKey == null ? null : exactKey.trim();
    }

    public String getVagueKey() {
        return vagueKey;
    }

    public void setVagueKey(String vagueKey) {
        this.vagueKey = vagueKey == null ? null : vagueKey.trim();
    }

    public String getRegexKey() {
        return regexKey;
    }

    public void setRegexKey(String regexKey) {
        this.regexKey = regexKey == null ? null : regexKey.trim();
    }

    public String getAnswerKey() {
        return answerKey;
    }

    public void setAnswerKey(String answerKey) {
        this.answerKey = answerKey == null ? null : answerKey.trim();
    }

    public String getDeleteKey() {
        return deleteKey;
    }

    public void setDeleteKey(String deleteKey) {
        this.deleteKey = deleteKey == null ? null : deleteKey.trim();
    }

    public String getQueryKey() {
        return queryKey;
    }

    public void setQueryKey(String queryKey) {
        this.queryKey = queryKey == null ? null : queryKey.trim();
    }

    public String getGlobalKey() {
        return globalKey;
    }

    public void setGlobalKey(String globalKey) {
        this.globalKey = globalKey == null ? null : globalKey.trim();
    }
}