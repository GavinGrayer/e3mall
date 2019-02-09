package cn.e3mall.freemarker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreeMarkerTest {
	
	@Test
	public void testFreeMarker() throws Exception{
		//1、创建一个模板文件
		//2、创建一个Configuration对象
		Configuration configuration = new Configuration(Configuration.getVersion());
		//3、设置模板文件保存的目录
		configuration.setDirectoryForTemplateLoading(new File("G:/template-mars2/e3-item-web/src/main/webapp/WEB-INF/ftl"));
		//4、模板文件的编码格式，一般就是utf-8
		configuration.setDefaultEncoding("utf-8");
		//5、加载一个模板文件，创建一个模板对象。
		Template template = configuration.getTemplate("student.ftl");
		//6、创建一个数据集。可以是pojo也可以是map。推荐使用map
		Map data = new HashMap<>();
		data.put("hello", "hello freemarker!");
		//创建一个pojo对象
		Student student = new Student(1, "小明", 18, "2131");
		data.put("student", student);
		
		//添加一个List
		List<Student> students = new ArrayList<Student>();
		for(int i=0;i<10;i++){
			
			students.add(new Student(i, "小明"+i, 18+i, "111"));
		}
		data.put("students", students);
		
		//添加date类型
		data.put("date", new Date());
		
		//添加null值
		data.put("val", 123);
		
		//7、创建一个Writer对象，指定输出文件的路径及文件名。
		//Writer out = new FileWriter(new File("H:/hello.txt"));
		Writer out = new FileWriter(new File("H:/student.html"));
		//8、生成静态页面
		template.process(data, out);
		//9、关闭流
		out.close();
	}
	
}
