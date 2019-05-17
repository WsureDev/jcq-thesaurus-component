package top.wsure.function;


import static top.wsure.function.Instructions.checkInstruct;

public class MsgHandle {

    public static void privateMsgInstruct(int subType, int msgId, long fromQQ, String msg, int font){
        //判断是否是命令
        String instructType = checkInstruct(msg);
        if(instructType==null){
            return;
        }

        //校验权限

        //执行操作


    }

    public static void privateMsgChat(int subType, int msgId, long fromQQ, String msg, int font){
        //
    }


}
