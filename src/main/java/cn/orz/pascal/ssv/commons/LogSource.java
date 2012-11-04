package cn.orz.pascal.ssv.commons;

import android.util.Log;

/**
 * Created with IntelliJ IDEA.
 * User: koduki
 * Date: 12/11/04
 * Time: 15:26
 * To change this template use File | Settings | File Templates.
 */
public interface LogSource {
    public int i(java.lang.String tag, java.lang.String msg);

    public int getTargetMethodDepth();
}
