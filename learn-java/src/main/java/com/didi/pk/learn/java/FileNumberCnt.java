package com.didi.pk.learn.java;

import java.io.File;

/**
 * @author pengkai
 * @date 2019-11-22
 */
public class FileNumberCnt {
    public static int cntFiles(File file) {
        if (file.isDirectory()) {
            File[] sub = file.listFiles();
            int sum = 0;
            for (File f : sub) {
                int num = cntFiles(f);
                sum += num;
            }
            return sum;
        } else if (file.isFile()) {
            if (isJavaFile(file)) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    public static int cntStudiedFiles(File file) {
        if (file.isDirectory()) {
            File[] sub = file.listFiles();
            int sum = 0;
            for (File f : sub) {
                int num = cntStudiedFiles(f);
                sum += num;
            }
            return sum;
        } else if (file.isFile()) {
            return cntOfFile(file);
        } else {
            return 0;
        }
    }

    private static boolean isJavaFile(File f) {
        boolean java = f.getName().endsWith(".java");
        boolean test = f.getName().contains("test") || f.getName().contains("Test") || f.getAbsolutePath().contains("test");
        boolean others = f.getAbsolutePath().contains("demo") || f.getAbsolutePath().contains("benchmark") || f.getName().equalsIgnoreCase("package-info.java")||f.getAbsolutePath().equals("microbench");
        return java && !test && !others;
    }

    private static int cntOfFile(File f) {
        String[] tmp = f.getName().split("\\.");
        String[] tmp2 = tmp[0].split("_");
        try {
            if (tmp2.length > 1) {
                return Integer.parseInt(tmp2[1]);
            } else {
                return 1;
            }
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        int studied = cntStudiedFiles(new File("/Users/didi/SumlimeProjects/source-code-study/lucene"));
        int all = cntFiles(new File("/Users/didi/workspace/study/netty"));
        System.out.println("studied:" + studied + ",all:" + all + ",process:" + ((float)studied) / all);
    }

}
