package ptt.android.utils.log;

import android.util.Log;

import ptt.android.utils.BuildConfig;

/**
 * Created by PTT on 2018. 07. 05
 */
public class MyLog {
    public static void v(String msg) {
        Logger(Log.VERBOSE, msg);
    }

    public static void d(String msg) {
        Logger(Log.DEBUG, msg);
    }

    public static void i(int i) {
        Logger(Log.INFO, "" + i);
    }

    public static void i(String msg) {
        Logger(Log.INFO, msg);
    }

    public static void w(String msg) {
        Logger(Log.WARN, msg);
    }

    public static void e(String msg) {
        Logger(Log.ERROR, msg);
    }

    private static void Logger(int priority, String msg) {
        if (BuildConfig.IS_DEBUG) {
            StringBuilder msgBuilder = new StringBuilder();
            msgBuilder.append("[").append(Thread.currentThread().getStackTrace()[4].getMethodName())
                    .append("()").append("]").append(" :: ").append(msg)
                    .append(" (").append(Thread.currentThread().getStackTrace()[4].getFileName()).append(":")
                    .append(Thread.currentThread().getStackTrace()[4].getLineNumber()).append(")");

            Log.println(priority, Thread.currentThread().getStackTrace()[4].getFileName().replace(".java", ""), msgBuilder.toString());
        }
    }

}
