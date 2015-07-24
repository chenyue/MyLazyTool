package com.CY.CYLogTool;
import android.util.Log;
/**
 * 由于我懒，觉得log的写法特麻烦，所以老是懒于写log输出，导致老是一遍遍测试
 * 浪费了很多时间，有的时候一打出log就很简单了，所以搞了这个util来解决自己懒于
 * 写log的问题
 * @author CY
 *
 */
public class CYLogUtils {

    public static StringBuffer rawLog(Class<?> class1, Object...objects) {
        String result = dealInput(objects);
        printLogD(class1.getName(), result);
        return new StringBuffer(result);
    }

    public static StringBuffer fullLog(Class<?> class1, Object...objects) {
        String result = dealFullInput(objects);
        printLogD(class1.getName(), result);
        return new StringBuffer(result);
    }

    public static StringBuffer rawLogE(Class<?> class1, Object...objects) {
        String result = dealInput(objects);
        printLogE(class1.getName(), result);
        return new StringBuffer(result);
    }

    public static StringBuffer fullLogE(Class<?> class1, Object...objects) {
        String result = dealFullInput(objects);
        printLogE(class1.getName(), result);
        return new StringBuffer(result);
    }

    private static String dealFullInput(Object[] objects) {
        int count = objects.length;
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < count; i += 2) {
            if (objects[i] == null || objects[i - 1] == null) {
                continue;
            }
            sb.append(objects[i - 1].toString() + ": " + objects[i].toString() + ", ");
        }
        // 去掉最后的","和空格
        String s = (String) sb.subSequence(0, (sb.length() - 2));

        return s;
    }

    private static String dealInput(Object[] objects) {
        int count = objects.length;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < count; i++) {
            if (objects[i] == null) {
                continue;
            }
            sb.append(i + ": " + objects[i].toString() + ", ");
        }
        // 去掉最后的","和空格
        String s = (String) sb.subSequence(0, (sb.length() - 2));

        return s;
    }

    private static void printLogD(String name, String result) {
        Log.d(name, result);
    }

    private static void printLogE(String name, String result) {
        Log.e(name, result);
    }
}
