package com.zip4j;

import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.ZipOutputStream;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.zip.ZipEntry;

/**
 * @author zl
 */
public class ZipDemo {


    public static void main(String[] args) throws IOException, ZipException {
        ZipDemo zipDemo = new ZipDemo();
        zipDemo.zipWithPass();
        zipDemo.zipWithNoFile();

    }

    public void generatZip() throws IOException, ZipException {
        String sourceFilePath = Objects.requireNonNull(ZipDemo.class.getClassLoader().getResource("")).getPath();
        File sourceFile = new File(sourceFilePath);// xml文件所在文件夹路径
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        ZipOutputStream zos = null;

        if (!sourceFile.exists()) {
            System.out.println("待压缩的文件目录：" + sourceFilePath + "不存在.");
            return;
        }
        String fileName = "zipFile";
        File zipFile = new File(sourceFilePath + "/" + fileName + ".zip");
        if (zipFile.exists()) {
            System.out.println(sourceFilePath + "目录下存在名字为:" + fileName + ".zip" + "打包文件.");
            return;
        }
        File[] sourceFiles = sourceFile.listFiles();
        if (null == sourceFiles || sourceFiles.length < 1) {
            System.out.println("待压缩的文件目录：" + sourceFilePath + "里面不存在文件，无需压缩.");
            return;
        }

        System.out.println(Arrays.toString(sourceFiles));
        fos = new FileOutputStream(zipFile);
        zos = new ZipOutputStream(new BufferedOutputStream(fos));
        byte[] bufs = new byte[1024 * 10];

        try {
            for (File file : sourceFiles) {
                if (file.getName().endsWith(".txt")) {
                    // 创建ZIP实体，并添加进压缩包
                    ZipEntry zipEntry = new ZipEntry(file
                            .getName());
//                    zos.putNextEntry(zipEntry);
                    // 读取待压缩的文件并写进压缩包里
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis, 1024 * 10);
                    int read = 0;
                    while ((read = bis.read(bufs, 0, 1024 * 10)) != -1) {
                        zos.write(bufs, 0, read);
                        zos.flush();
                    }
                }
            }
        } finally {
            zos.flush();
            zos.closeEntry();
            zos.close();
        }

        System.out.println("压缩成功！");

    }

    public void zipWithPass() throws IOException, ZipException {

        String sourceFilePath = Objects.requireNonNull(ZipDemo.class.getClassLoader().getResource("")).getPath();
        File sourceFile = new File(sourceFilePath);

        File zipFile = new File("D:\\temp\\test.zip");
        ArrayList<File> files = new ArrayList<>();
        files.add(new File(sourceFilePath + "test.txt"));
        files.add(new File(sourceFilePath + "test1.txt"));

        //设置压缩文件参数
        ZipParameters parameters = new ZipParameters();
        //设置压缩方法
        parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
        //设置压缩级别
        //DEFLATE_LEVEL_FASTEST     - Lowest compression level but higher speed of compression
        //DEFLATE_LEVEL_FAST        - Low compression level but higher speed of compression
        //DEFLATE_LEVEL_NORMAL  - Optimal balance between compression level/speed
        //DEFLATE_LEVEL_MAXIMUM     - High compression level with a compromise of speed
        //DEFLATE_LEVEL_ULTRA       - Highest compression level but low speed
        parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
        //设置压缩文件加密
        parameters.setEncryptFiles(true);
        //设置加密方法
        parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);
        //设置aes加密强度
        parameters.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);
        //设置密码
        parameters.setPassword("123456");

        FileOutputStream fileOutputStream = null;


        net.lingala.zip4j.io.ZipOutputStream zipOutputStream = null;
            fileOutputStream = new FileOutputStream(zipFile);
            zipOutputStream = new net.lingala.zip4j.io.ZipOutputStream(fileOutputStream);

            //添加文件到压缩文件
            if (zipFile.exists()) {
                zipFile.delete();
            }

            for (File addFile : files) {
                zipOutputStream.putNextEntry(addFile, parameters);

                if (addFile.isDirectory()) {
                    zipOutputStream.closeEntry();
                    continue;
                }

                InputStream inputStream = new ByteArrayInputStream(new byte[1024]);
                byte[] readBuff = new byte[1024 * 10];
                int readLen = -1;
                while ((readLen = inputStream.read(readBuff)) != -1) {
                    zipOutputStream.write(readBuff, 0, readLen);
                }
                zipOutputStream.closeEntry();
                inputStream.close();
            }

            zipOutputStream.finish();
            zipOutputStream.close();


        }


    public void zipWithNoFile() throws IOException, ZipException {

        String sourceFilePath = Objects.requireNonNull(ZipDemo.class.getClassLoader().getResource("")).getPath();
        File sourceFile = new File(sourceFilePath);

        File zipFile = new File("D:\\temp\\test.zip");

        //设置压缩文件参数
        ZipParameters parameters = new ZipParameters();
        //设置压缩方法
        parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
        //设置压缩级别
        //DEFLATE_LEVEL_FASTEST     - Lowest compression level but higher speed of compression
        //DEFLATE_LEVEL_FAST        - Low compression level but higher speed of compression
        //DEFLATE_LEVEL_NORMAL  - Optimal balance between compression level/speed
        //DEFLATE_LEVEL_MAXIMUM     - High compression level with a compromise of speed
        //DEFLATE_LEVEL_ULTRA       - Highest compression level but low speed
        parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
        //设置压缩文件加密
        parameters.setEncryptFiles(true);
        //设置加密方法
        parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);
        //设置aes加密强度
        parameters.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);
        //设置密码
        parameters.setPassword("123456");

        FileOutputStream fileOutputStream = null;


        net.lingala.zip4j.io.ZipOutputStream zipOutputStream = null;
        fileOutputStream = new FileOutputStream(zipFile);
        zipOutputStream = new net.lingala.zip4j.io.ZipOutputStream(fileOutputStream);

        //添加文件到压缩文件
        if (zipFile.exists()) {
            zipFile.delete();
        }

        for (int i=0;i<2;i++) {
//            zipOutputStream.putNextEntry(new File(), parameters);

            InputStream inputStream = new ByteArrayInputStream("this is test".getBytes(StandardCharsets.UTF_8));
            byte[] readBuff = new byte[1024 * 10];
            int readLen = -1;
            while ((readLen = inputStream.read(readBuff)) != -1) {
                byte[] tempByte=Arrays.copyOf(readBuff, readLen);
                zipOutputStream.write(tempByte);
            }
            zipOutputStream.closeEntry();
            inputStream.close();
        }

        zipOutputStream.finish();
        zipOutputStream.close();

//        zipOutputStream.


    }

}
