package pkuhit.iih.version;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.DateFormat;
import java.util.Date;

//import org.apache.commons.lang.time.DateUtils;

public class LoggerManager {

	private static String path = "log.txt";

	public static void log(Object newStr) {
		// 先读取原有文件内容，然后进行写入操作
		String filein = DateFormat.getDateInstance().format(new Date())+newStr + "\r\n";
		try {
			// 打开一个随机访问文件流，按读写方式
			RandomAccessFile randomFile = new RandomAccessFile(path, "rw");
			// 文件长度，字节数
			long fileLength = randomFile.length();
			// 将写文件指针移到文件尾。
			randomFile.seek(fileLength);
			randomFile.writeBytes(filein);
			randomFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
