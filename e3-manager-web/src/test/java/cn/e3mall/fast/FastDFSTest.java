package cn.e3mall.fast;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import xn.e3mall.common.utils.FastDFSClient;

public class FastDFSTest {
	@Test
	public void testUpload() throws FileNotFoundException, IOException, MyException{
		//创建一个配置文件，文件名任意，内容就是tracker服务器地址
		//使用全局对象加载配置文件
		ClientGlobal.init("G:/template-mars2/e3-manager-web/src/main/resources/conf/client.conf");
		//创建一个TrackClient对象
		TrackerClient trackerClient = new TrackerClient();
		//通过TrackerClent获得一个TrackServer对象
		TrackerServer trackerServer = trackerClient.getConnection();
		//创建一个StrongeServer的引用，可以是null
		StorageServer storageServer=null;		
		//创建一个StorageClient，参数需要TrackServer和StrongeServer
		StorageClient storageClient = new StorageClient(trackerServer,storageServer);
		//使用StorageClient上传文件
		String[] upload_file = storageClient.upload_file("C:/Users/23651/Pictures/myweixin.png", "png", null);
		for (String string : upload_file) {
			System.out.println(string);
		}
	}
	
	@Test
	public void testFastDFSClient() throws Exception{
		FastDFSClient fastDFSClient = new FastDFSClient("G:/template-mars2/e3-manager-web/src/main/resources/conf/client.conf");
		String string = fastDFSClient.uploadFile("C:/Users/23651/Pictures/2.png");
		System.out.println(string);
	}
	
	
}
