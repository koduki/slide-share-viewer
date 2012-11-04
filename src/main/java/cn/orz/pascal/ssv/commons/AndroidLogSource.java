package cn.orz.pascal.ssv.commons;

import android.util.Log;

/**
 * Created with IntelliJ IDEA.
 * User: koduki
 * Date: 12/11/04
 * Time: 15:28
 * To change this template use File | Settings | File Templates.
 */
public class AndroidLogSource implements LogSource {
    public static final int TARGET_METHOD_DEPTH = 3;

    @Override
    public int i(String tag, String msg) {
        return Log.i(tag, msg);
    }

    @Override
    public int getTargetMethodDepth() {
        return TARGET_METHOD_DEPTH;
    }
}
