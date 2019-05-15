package top.wsure;

import com.sobte.cqp.jcq.entity.CQDebug;
import com.sobte.cqp.jcq.entity.ICQVer;
import com.sobte.cqp.jcq.entity.IMsg;
import com.sobte.cqp.jcq.entity.IRequest;
import com.sobte.cqp.jcq.event.JcqAppAbstract;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import top.wsure.component.Configs;
import top.wsure.component.DatebaseUtils;
import top.wsure.config.Option;
import top.wsure.config.RegexString;
import top.wsure.function.Instructions;
import top.wsure.service.SettingService;
import top.wsure.service.TableService;

import javax.swing.*;
import java.io.IOException;

@SpringBootApplication
@MapperScan(basePackages = {"top.wsure.dao","top.wsure.component"})
public class Thesaurus  extends JcqAppAbstract implements ICQVer, IMsg, IRequest {

    // 记住编译后的文件和json也要使用appid做文件名
//    public static final String AppID = Configs.configs.getAppId();//"top.wsure.thesaurus";

    public static void main(String[] args) {
        // CQ此变量为特殊变量，在JCQ启动时实例化赋值给每个插件，而在测试中可以用CQDebug类来代替他
        CQ = new CQDebug();//new CQDebug("应用目录","应用名称") 可以用此构造器初始化应用的目录
        CQ.logInfo("[JCQ] TEST Demo", "测试启动");// 现在就可以用CQ变量来执行任何想要的操作了
        // 要测试主类就先实例化一个主类对象
        Thesaurus thesaurus = new Thesaurus();
        // 下面对主类进行各方法测试,按照JCQ运行过程，模拟实际情况

        thesaurus.privateMsg(0, 10001, 2234567819L, "mssage1", 0);
        thesaurus.startup();// 程序运行开始 调用应用初始化方法
        thesaurus.enable();// 程序初始化完成后，启用应用，让应用正常工作
        // 开始模拟发送消息
        // 模拟私聊消息
        // 开始模拟QQ用户发送消息，以下QQ全部编造，请勿添加
        CQ.logInfo("test",thesaurus.appInfo());
        thesaurus.privateMsg(0, 10001, 2234567819L, "mssage2", 0);
        thesaurus.privateMsg(0, 10001, 2234567819L, "模糊问aad答xxx", 0);
        // 模拟群聊消息
        // 开始模拟群聊消息
        thesaurus.groupMsg(0, 10006, 3456789012L, 3333333334L, "", "菜单", 0);
        // 依次类推，可以根据实际情况修改参数，和方法测试效果
        // 以下是收尾触发函数
        // demo.disable();// 实际过程中程序结束不会触发disable，只有用户关闭了此插件才会触发
        thesaurus.exit();// 最后程序运行结束，调用exit方法
    }

    /**
     * 打包后将不会调用 请不要在此事件中写其他代码
     *
     * @return 返回应用的ApiVer、Appid
     */
    public String appInfo() {
        // 记住编译后的文件和json也要使用appid做文件名
        final String AppID = Configs.configs.getAppId();
        /**
         * 本函数【禁止】处理其他任何代码，以免发生异常情况。
         * 如需执行初始化代码请在 startup 事件中执行（Type=1001）。
         */
        CQ.logInfo("AppId",AppID);
        return CQAPIVER + "," + AppID;
    }

    public int startup() {

        SpringApplication.run(Thesaurus.class);
        CQ.logInfo("Thesaurus","SpringBoot is Start");
        return 0;
    }

    public int exit() {
        return 0;
    }

    public int enable() {
        enable = true;
        return 0;
    }

    public int disable() {
        enable = false;
        return 0;
    }

    /**
     * 私聊消息 (Type=21)<br>
     * 本方法会在酷Q【线程】中被调用。<br>
     *
     * @param subType 子类型，11/来自好友 1/来自在线状态 2/来自群 3/来自讨论组
     * @param msgId   消息ID
     * @param fromQQ  来源QQ
     * @param msg     消息内容
     * @param font    字体
     * @return 返回值*不能*直接返回文本 如果要回复消息，请调用api发送<br>
     * 这里 返回  {@link IMsg#MSG_INTERCEPT MSG_INTERCEPT} - 截断本条消息，不再继续处理<br>
     * 注意：应用优先级设置为"最高"(10000)时，不得使用本返回值<br>
     * 如果不回复消息，交由之后的应用/过滤器处理，这里 返回  {@link IMsg#MSG_IGNORE MSG_IGNORE} - 忽略本条消息
     */
    public int privateMsg(int subType, int msgId, long fromQQ, String msg, int font) {
        // 这里处理消息
        DatebaseUtils datebaseUtils = DatebaseUtils.datebaseUtils;
        if(datebaseUtils == null)
        {
            CQ.logInfo("SpringBoot is not ready","privateMsg:"+msg);
            return MSG_IGNORE;
        }
        TableService tableService = datebaseUtils.getTableService();
        CQ.logInfo("has groups ?",""+tableService.hasTable("groups"));
        CQ.logInfo("masterId",Option.masterId);
        String instructType = Instructions.checkInstruct(msg);
        CQ.logInfo(msg,instructType);
        if(instructType!=null&&Instructions.lexiconType(instructType)>0)
            CQ.logInfo("lexicon",Instructions.msgToLexicon(instructType,msg).toString());

        return MSG_IGNORE;
    }

    public int groupMsg(int i, int i1, long l, long l1, String s, String s1, int i2) {
        return 0;
    }

    public int discussMsg(int i, int i1, long l, long l1, String s, int i2) {
        return 0;
    }

    public int groupUpload(int i, int i1, long l, long l1, String s) {
        return 0;
    }

    public int groupAdmin(int i, int i1, long l, long l1) {
        return 0;
    }

    public int groupMemberDecrease(int i, int i1, long l, long l1, long l2) {
        return 0;
    }

    public int groupMemberIncrease(int i, int i1, long l, long l1, long l2) {
        return 0;
    }

    public int friendAdd(int i, int i1, long l) {
        return 0;
    }

    public int requestAddFriend(int i, int i1, long l, String s, String s1) {
        return 0;
    }

    public int requestAddGroup(int i, int i1, long l, long l1, String s, String s1) {
        return 0;
    }

    /**
     * 本函数会在JCQ【线程】中被调用。
     *
     * @return 固定返回0
     */
    public int menuA() throws IOException {
        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler http://www.baidu.com");
        return 0;
    }

    /**
     * 本函数会在酷Q【线程】中被调用。
     *
     * @return 固定返回0
     */
    public int menuB() {
        JOptionPane.showMessageDialog(null, "这是测试菜单B，可以在这里加载窗口");
        return 0;
    }
}
