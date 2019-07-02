package top.wsure.entity;

public class Disable {
    private Long qq;

    private Long groupId;

    private Long commitUser;

    private String commitTime;

    public Disable() {

    }

    public Long getQq() {
        return qq;
    }

    public void setQq(Long qq) {
        this.qq = qq;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getCommitUser() {
        return commitUser;
    }

    public void setCommitUser(Long commitUser) {
        this.commitUser = commitUser;
    }

    public String getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(String commitTime) {
        this.commitTime = commitTime == null ? null : commitTime.trim();
    }

    public Disable(Long qq, Long groupId, Long commitUser) {
        this.qq = qq;
        this.groupId = groupId;
        this.commitUser = commitUser;
    }

    @Override
    public String toString() {
        return "qq:" + qq +
                "\n时间:" + commitTime +
                '\n';
    }
}