package com.javase.classloader;

import java.lang.reflect.Method;


/**
 * 自定义从文件系统中加载类到jvm中
 */
public class FileSystemClassLoaderDemo {

	public static void main(String[] args) {
		new FileSystemClassLoaderDemo().testClassIdentity();
	}
	
	public void testClassIdentity() {
		String classDataRootPath = "D:\\temp";
		FileSystemClassLoader fscl1 = new FileSystemClassLoader(classDataRootPath);
		FileSystemClassLoader fscl2 = new FileSystemClassLoader(classDataRootPath);
		//用字节码文件中的包名+类型
		String className = "com.javase.classloader.ClassLoaderTest";
		try {
			Class<?> class1 = fscl1.loadClass(className);
			Object obj1 = class1.newInstance();
//			System.out.println(obj1);
			Class<?> class2 = fscl2.loadClass(className);
			Object obj2 = class2.newInstance();
			Method setSampleMethod = class1.getMethod("test");
			setSampleMethod.invoke(obj1);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
