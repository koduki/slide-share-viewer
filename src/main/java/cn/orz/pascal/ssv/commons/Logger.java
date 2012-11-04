package cn.orz.pascal.ssv.commons;

import android.util.Log;
import com.google.inject.Inject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: koduki
 * Date: 12/11/04
 * Time: 13:37
 * To change this template use File | Settings | File Templates.
 */
public class Logger {
    private Map<Double, Long> logs = new HashMap<Double, Long>();
    @Inject
    private LogSource source;

    public double startTrace() {
        double logId = Math.random();
        logs.put(logId, System.currentTimeMillis());

        return logId;
    }

    public void printTrace(double logId) {
        long start = logs.get(logId);
        long end = System.currentTimeMillis();

        StackTraceElement trace = Thread.currentThread().getStackTrace()[source.getTargetMethodDepth()];
        this.source.i("trace_log", "class " + trace.getClassName() + ", method " + trace.getMethodName() + ", time=" + (end - start) + "ms");

        logs.remove(logId);
    }
}
