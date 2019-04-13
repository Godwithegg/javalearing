package com.danhuang.dynamiccompile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class Demo {
	public static void main(String[] args) throws IOException {
		// 通过IO流操作，将字符串存储成一个临时文件，然后通过动态编译方法
		String str = "public class Hi {public static void main(String[] args) {System.out.print(\"牛逼啊\");}}";

		// 获得java编译器
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		int result = compiler.run(null, null, null,
				"D:/github/javalearning/javalearing/DynamicCompile/myjava/HelloWorld.java");
		System.out.println(result == 0 ? "编译成功" : "编译失败");

		// //通过runtime调用执行类
		// Runtime run = Runtime.getRuntime();
		// Process process = run.exec("java -cp D:/github/javalearning/javalearing/DynamicCompile/myjava HelloWorld");
		// InputStream in = process.getInputStream();
		// BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		// String info = "";
		// while((info = reader.readLine()) != null) {
		// System.out.println(info);
		// }

		try {
			URL[] urls = new URL[] { new URL("file:/" + "D:/github/javalearning/javalearing/DynamicCompile/myjava/") };
			URLClassLoader loader = new URLClassLoader(urls);
			Class c = loader.loadClass("HelloWorld");
			Method m =c.getMethod("main", String[].class);
			m.invoke(null, (Object)new String[] {});
							//一个参数一个(Object)new String[] {}
			// new String[] {"aa","bb"}
			//由于可变参数是JDK5.0之后才有，因此上面的代码会编译成m.invoke(null,"aa","bb")，就发生了参数个数不匹配的问题。
			//因此必须加上（Object）转型，才能避免这个问题。
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
