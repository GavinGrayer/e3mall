package cn.e3mall.content.jedis;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import xn.e3mall.common.jedis.JedisClient;

public class JedisClientTest {

	/**
	 * 单机版和集群版无需更改代码，只需修改配置即可
	 * <p>Title: testJedisClient</p>
	 * <p>Description: </p>
	 * @throws Exception
	 */
	@Test
	public void testJedisClient() throws Exception {
		//初始化spring容器
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-redis.xml");
		//从容器中获得JedisClient对象
		JedisClient jedisClient = applicationContext.getBean(JedisClient.class);
		jedisClient.set("mytest", "jedisClient");
		String string = jedisClient.get("mytest");
		System.out.println(string);
		
		
	}
}
