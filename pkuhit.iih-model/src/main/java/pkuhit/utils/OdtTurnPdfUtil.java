package pkuhit.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.artofsolving.jodconverter.OfficeDocumentConverter;
import org.artofsolving.jodconverter.office.DefaultOfficeManagerConfiguration;
import org.artofsolving.jodconverter.office.OfficeManager;
//import org.slf4j.logger;
//import org.slf4j.loggerFactory;

import pkuhit.iih.mr.wr.ArchiveFile;

public class OdtTurnPdfUtil {
//	private static logger log = loggerFactory.getlogger(Odt2PdfUtil.class);
	private static OfficeManager officeManager;
	private static String OPEN_OFFICE_HOME = null;
	private static int OPEN_OFFICE_PORT[] = { 8100 };
	private static OfficeDocumentConverter CONVERRTER;
	public static void main(String [] args){//测试类
		OPEN_OFFICE_HOME="C:\\OpenOffice4\\iemr_client\\OpenOffice 4";
		startService();
		CONVERRTER = new OfficeDocumentConverter(officeManager);
		odtTopdf(CONVERRTER, "D:\\22.odt", "D:\\22.pdf", 5);
		System.out.println(1);
	}
	public static List<ArchiveFile> getPdfBytes(String openOfficeHome, String odtFilePath, String pdfFilePath,
			List<ArchiveFile> odtList) throws java.io.IOException {
		List<ArchiveFile> pdfList = new ArrayList<ArchiveFile>();
		int count = 0;
		if (openOfficeHome.isEmpty()) {
			System.out.println("openOfficeHome路径不允许留空");
			return null;
		}
		OPEN_OFFICE_HOME = openOfficeHome;
		if (odtFilePath.isEmpty()) {
			System.out.println("待转换office路径不允许留空");
			return null;
		}
		if (!pdfFilePath.toLowerCase().endsWith(".pdf")) {
			System.out.println("输出pdf路径必须以.pdf结尾");
			return null;
		}
		System.out.println("进行文档转换转换:" + odtFilePath + " --> " + pdfFilePath);
		long startTime = System.currentTimeMillis();
			startService();
			CONVERRTER = new OfficeDocumentConverter(officeManager);
		for (int i = 0; odtList != null && i < odtList.size(); i++) {
			ArchiveFile archiveFile = odtList.get(i);
			if(archiveFile.getPdfBuffer()==null){
				byte[] odtBuffer = archiveFile.getOdtBuffer();
				FileOutputStream out = new FileOutputStream(odtFilePath);
				out.write(odtBuffer);
				out.close();
				odtTopdf(CONVERRTER, odtFilePath, pdfFilePath, count);
				File file = new File(pdfFilePath);
				FileInputStream inputFile = new FileInputStream(file);
				byte[] pdfBuffer = new byte[(int) file.length()];
				inputFile.read(pdfBuffer);
				inputFile.close();
				File fodt = new File(odtFilePath);
				fodt.delete();
				file.delete();
				archiveFile.setPdfBuffer(pdfBuffer);
			}
			pdfList.add(archiveFile);
		}
		System.out.println("转换完成.耗时" + ((System.currentTimeMillis() - startTime)) + "毫秒");
		 stopService();//不停止服务会加快下次启动服务速度
		System.out.println("运行结束");
		return pdfList;
	}

	private static void odtTopdf(OfficeDocumentConverter converter, String odtFile, String pdfFile, int count) {
		try {
			count++;
			System.out.println(pdfFile + "第" + count + "次调用");
			converter.convert(new File(odtFile), new File(pdfFile));
			count = 0;
		} catch (Exception e) {
			e.printStackTrace();
			File file = new File(pdfFile);
			if (!file.exists() && count < 5) {
				System.out.println(pdfFile + "第" + count + "次重试");
				odtTopdf(converter, odtFile, pdfFile, count);
			} else if (file.exists()) {
				System.out.println(pdfFile + "第" + count + "次抛异常，但创建成功");
				count = 0;
			} else {
				System.out.println(pdfFile + "重试次数达到" + count + "次，不再重试");
			}
		}
	}

	private static void stopService() {
		System.out.println("关闭office转换服务....");
		if (officeManager != null) {
			officeManager.stop();
		}
		System.out.println("关闭office转换服务成功!");
	}

	private static void startService() {
		DefaultOfficeManagerConfiguration configuration = new DefaultOfficeManagerConfiguration();
		try {
			System.out.println("准备启动安装在" + OPEN_OFFICE_HOME + "目录下的openoffice服务....");
			configuration.setOfficeHome(OPEN_OFFICE_HOME); //设置OpenOffice.org安装目录
			configuration.setPortNumbers(OPEN_OFFICE_PORT);  //设置转换端口，默认为8100
			configuration.setTaskExecutionTimeout(1000 * 30);// 设置任务执行超时为30秒
			configuration.setTaskQueueTimeout(1000 * 30); //设置任务队列超时为30秒

			officeManager = configuration.buildOfficeManager();
			officeManager.start();  //启动服务
			System.out.println("office转换服务启动成功!");
		} catch (Exception ce) {
			System.out.println("office转换服务启动失败!详细信息:" + ce.getMessage());
		}
	}
}