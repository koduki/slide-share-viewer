package cn.orz.pascal.ssv.commons;

import android.util.Log;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: koduki
 * Date: 12/11/04
 * Time: 15:28
 * To change this template use File | Settings | File Templates.
 */
public class StandardLogSource implements LogSource {
    public static final int TARGET_METHOD_DEPTH = 2;

    @Override
    public int i(String tag, String msg) {
        System.out.println(new Date() + ": INFO/" + tag + ": " + msg);
        return 0;
    }

    @Override
    public int getTargetMethodDepth() {
        return TARGET_METHOD_DEPTH;
    }

}
