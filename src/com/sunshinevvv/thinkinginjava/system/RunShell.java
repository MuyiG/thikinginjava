package com.sunshinevvv.thinkinginjava.system;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sunshine on 2017/3/29.
 */
public class RunShell {
    private static final String RUNNING_SHELL_FILE = "ffmpeg";
    private static final String SHELL_FILE_DIR = "/usr/local/Cellar/ffmpeg/3.2.2/bin/";
    private static final String FULL_SHELL = "/usr/local/Cellar/ffmpeg/3.2.2/bin/ffmpeg";
    private static final String SOURCE_FILE = "/Users/sunshine/Documents/test.amr";
    private static final String TARGET_FILE = "/Users/sunshine/Documents/haha.mp3";



    public static void main(String[] args) {
        runShell();
//        runShell2();
    }

    public static void runShell() {
        try {
            // 效果就是：/usr/local/Cellar/ffmpeg/3.2.2/bin/ffmpeg -i ~/Documents/test.amr ~/Documents/haha.mp3
            Process ps = Runtime.getRuntime().exec(new String[]{FULL_SHELL, "-i", SOURCE_FILE, TARGET_FILE});
            ps.waitFor();

            BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            String result = sb.toString();
            System.out.println(result);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void runShell2() {
        ProcessBuilder pb = new ProcessBuilder(RUNNING_SHELL_FILE, "-i", SOURCE_FILE, TARGET_FILE);
        pb.directory(new File(SHELL_FILE_DIR));
        int runningStatus = 0;
        try {
            Process p = pb.start();
            try {
                runningStatus = p.waitFor();
            } catch (InterruptedException e) {
            }

        } catch (IOException e) {
        }
        if (runningStatus != 0) {
        }
        return;
    }

}
