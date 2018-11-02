/*

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import com.danche.mapper.DancOrderMapper;
import com.danche.pojo.DancOrder;
import com.danche.pojo.DancOrderExample;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class TestPageHelper {

	@Test
	public void testPageHelper() {
		//创建一个spring容器
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		//从spring容器中获得Mapper的代理对象
		DancOrderMapper mapper = applicationContext.getBean(DancOrderMapper.class);
		//执行查询，并分页
		DancOrderExample example = new DancOrderExample();
		//分页处理
		PageHelper.startPage(2, 10);
		List<DancOrder> list = mapper.selectByExample(example);
		//取商品列表
		for (DancOrder tbItem : list) {
			System.out.println(tbItem.getId());
		}
		//取分页信息
		PageInfo<DancOrder> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		System.out.println("共有商品："+ total);
		//119.28.239.178
	}

	@Test
	public  void testFtp() throws IOException {
		//1、连接ftp服务器
		FTPClient ftpClient = new FTPClient();
		ftpClient.connect("119.29.239.178", 21);
		//2、登录ftp服务器
		ftpClient.login("ftpusr", "ftpusr");
		//3、读取本地文件
		FileInputStream fileInputStream = new FileInputStream("D:\\svn\\Capture001.png");//(new File("D:\\svn\\Capture001.png"))
//4、上传文件
		//1）指定上传目录
		ftpClient.changeWorkingDirectory("/home/ftpusr/www/image");
		//2）指定文件类型
		ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
		//第一个参数：文件在远程服务器的名称
		//第二个参数：文件流
		ftpClient.storeFile("5.jpg", fileInputStream);
		//5、退出登录
		ftpClient.logout();

	}

		
	
}
*/
