package com.jd.bt.rule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

/**
 * User: 吴海旭
 * Date: 2016-11-25
 * Time: 下午5:57
 * TemporaryFolder：在测试之前创建临时文件夹（parentFolder/junit），在结束后销毁
 */
public class TemporaryFolderTest {

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder(new File("C:\\Users\\wuhaixu\\Desktop")) {
        @Override
        protected void after() {
            super.after();
            System.out.println("销毁文件");
        }
    };

    @Test
    public void testTemporaryFolder() throws IOException {
        System.out.println("创建a.txt文件");
        temporaryFolder.newFile("a.txt");
        System.out.println("创建b.txt文件");
        temporaryFolder.newFile("b.txt");
    }
}
