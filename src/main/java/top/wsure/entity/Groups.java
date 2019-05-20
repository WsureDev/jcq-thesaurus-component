package top.wsure.entity;

public class Groups {
    private Long groupId;

    private Integer enable;

    private Integer editerLevel;

    private Integer welcomeEnable;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Integer getEditerLevel() {
        return editerLevel;
    }

    public void setEditerLevel(Integer editerLevel) {
        this.editerLevel = editerLevel;
    }

    public Integer getWelcomeEnable() {
        return welcomeEnable;
    }

    public void setWelcomeEnable(Integer welcomeEnable) {
        this.welcomeEnable = welcomeEnable;
    }
}