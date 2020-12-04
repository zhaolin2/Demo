package com.javase.io.nio;

import java.io.File;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Description:
 * @Author: zl
 * @date: 2020/11/21
 */
public class PathDemo {
    public static void main(String[] args) {
        Path path = Paths.get("G:\\", "云服务器\\apache-skywalking-apm-bin\\webapp\\webapp.yml");

        show("toString", path);
        show("Exists", Files.exists(path));
        show("RegularFile", Files.isRegularFile(path));
        show("Directory", Files.isDirectory(path));
        show("Absolute", path.isAbsolute());
        show("FileName", path.getFileName());
        show("Parent", path.getParent());
        show("Root", path.getRoot());
        System.out.println("******************");

        //索引从0开始
        show("getNameByIndex",path.getName(0));

        URI u = path.toUri();
        System.out.println("URI: " + u);
        Path puri = Paths.get(u);
        System.out.println(Files.exists(puri));
        File f = path.toFile();
        System.out.println(f);

        path.getParent().resolve("..");
    }

    static void show(String id, Object p) {
        System.out.println(id + ": " + p);
    }

    public static void partsOfPaths () {
        System.out.println(System.getProperty("os.name"));
        Path p = Paths.get("G:\\\", \"云服务器\\apache-skywalking-apm-bin\\webapp\\webapp.yml").toAbsolutePath();

        //遍历不包含根路径 只有startwith才会检测根路径
        for(int i = 0; i < p.getNameCount(); i++) {
            System.out.println(p.getName(i));
        }
        //false  因为endwith只包含路径 不包含文件信息
        System.out.println("ends with '.java': " +
                p.endsWith(".java"));
        for(Path pp : p) {
            System.out.print(pp + ": ");
            System.out.print(p.startsWith(pp) + " : ");
            System.out.println(p.endsWith(pp));
        }


        System.out.println("Starts with " + p.getRoot() + " " + p.startsWith(p.getRoot()));
    }
}
