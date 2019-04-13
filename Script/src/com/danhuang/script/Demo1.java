package com.danhuang.script;

import java.io.FileReader;
import java.net.URL;
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * 测试脚本引擎执行JavaScript代码
 * 
 * @author danhuang
 *
 */
public class Demo1 {
	public static void main(String[] args) throws Exception {
		//获得脚本引擎对象
		ScriptEngineManager sem = new ScriptEngineManager();
		//获得脚本引擎 
		ScriptEngine engine = sem.getEngineByName("javascript");
		//定义变量，存储到引擎上下文中
		engine.put("msg", "蛋黄 is good man");
		String str = "var user = {name:'蛋黄',age:18,schools:['清华大学','北京大学']};";
		str += "print(user.name);";
		
		//执行脚本
		engine.eval(str);
		engine.eval("msg = '改了就改了吧';");
		
		System.out.println(engine.get("msg"));
		System.out.println("####################");
		
		//定义函数
		engine.eval("function add(a,b){var sum = a + b;return sum;}");
		//取得调用接口
		Invocable jsInvoke = (Invocable) engine;
		//执行脚本中定义的方法
		Object result = jsInvoke.invokeFunction("add",new Object[] {13,20});
		System.out.println(result);
		
		//导入其他的java包，使用其他包中的java类,若需要深入了解细节，可以详细学习Rhino的语法
		String jsCode = "var list=java.util.Arrays.asList([\"清华大学\",\"北京大学\"]);";
		engine.eval(jsCode);
		List<String> list = (List<String>)engine.get("list");
		System.out.println(list);
		
		//执行一个js文件（我们将a.js置于项目的src下即可）
		URL url = Demo1.class.getClassLoader().getResource("a.js");
		FileReader fr = new FileReader(url.getPath());
		engine.eval(fr);
		fr.close();//由于只是测试，所以比较不规范。实际应用要try——catch——finally
		
	}
}
