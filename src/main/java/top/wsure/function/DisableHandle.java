package top.wsure.function;

import top.wsure.component.DatebaseUtils;
import top.wsure.entity.Disable;
import top.wsure.service.DisableService;

import static com.sobte.cqp.jcq.event.JcqApp.CQ;

public class DisableHandle {
    static DatebaseUtils datebaseUtils = DatebaseUtils.datebaseUtils;

    public static void banMemberIfLifted(Disable disable){
        if(isDisableMember(disable)){
            CQ.logInfo("管理员解禁黑名单人员",disable.getQq()+"");
            CQ.setGroupBan(disable.getGroupId(),disable.getQq(),60*60*24*30);
        }
    }

    public static void delMsgIfBan(Disable disable,int msgId){
        if(isDisableMember(disable)){
            CQ.logInfo("黑名单人员发言",disable.getQq()+"");
            CQ.deleteMsg(msgId);
            CQ.setGroupBan(disable.getGroupId(),disable.getQq(),60*60*24*30);
        }
    }

    public static boolean isDisableMember(Disable disable){
        DisableService disableService = datebaseUtils.getDisableService();
        Disable d =disableService.selectByQq(disable);

        if(d!=null){
            return true;
        }
        return false;
    }

}
