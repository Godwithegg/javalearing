package com.danhuang.jvm;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import sun.misc.IOUtils;

/**
 * 自定义文件系统类加载器
 * 所有继承ClassLoader并且没有重写getSystemClassLoader方法的类加载器，
 * 通过getSystemClassLoader方法得到的AppClassloader都是同一个AppClassloader实例，类似单例模式。
 * 结论，就是所有通过正常双亲委派模式的类加载器加载的classpath下的和ext下的所有类在方法区都是同一个类，堆中的Class实例也是同一个。
 * @author danhuang
 *
 */
public class FileSystemClassLoader extends ClassLoader{
	
	//com.danhuang.jvm.User --> D:/github/javalearning/javalearing/JVM/ com/danhuang/jvm/User.class
	//以后加载类的加载器都在D:/github/javalearning/javalearing/JVM/里面加载
	private String rootDir;
	public FileSystemClassLoader(String rootDir) {
		this.rootDir = rootDir;
	}
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		Class<?> c = findLoadedClass(name);
		// 应该要先查询有没有加载过这个类，如果已经被加载，则直接返回加载好的类。如果有，则加载新的类
		if (c != null) {
			return c;
		} else {
			try {
				ClassLoader parent = this.getParent();// 获得父类加载器
				parent.loadClass(name);// 让他去加载
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if (c != null) {
				return c;
			} else {
				byte[] classData = getClassData(name);
				if (classData == null) {
					throw new ClassNotFoundException();
				} else {
					c = defineClass(name, classData, 0, classData.length);
				}
			}
		}
		return c;
	}

	private byte[] getClassData(String classname) {// com.danhuang.jvm.User --> D:/github/javalearning/javalearing/JVM/ com/danhuang/jvm/User.class
		String path = rootDir + "/" + classname.replace('.', '/') + ".class";
		// IOUtils,可以使用它将流中的数据转成字节数组
		InputStream is = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		try {
			is = new FileInputStream(path);
			int temp = 0;
			while ((temp = is.read(buffer)) != -1) {
				baos.write(buffer, 0, temp);
			}
			return baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (baos != null) {
				try {
					baos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
