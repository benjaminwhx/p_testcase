package com.jd.bt.mock;

import java.io.File;

/**
 * User: 吴海旭
 * Date: 2016-11-26
 * Time: 下午8:21
 */
public class MockVo {

    public boolean callInternalInstance(String path) {
        File file = new File(path);
        return file.exists();
    }

    public boolean callArguementInstance(File file) {
        return file.exists();
    }

    public final boolean isAlive() {
        return false;
    }

    public static boolean isMan() {
        return false;
    }

    public boolean callPrivateMethod() {
        return isPublic();
    }

    private boolean isPublic() {
        return false;
    }

    public boolean callSystemFinalMethod(String str) {
        return str.isEmpty();
    }

    public String callSystemStaticMethod(String str) {
        return System.getProperty(str);
    }
}
