package pkuhit.iih.version;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class GenerateBuildNumber {

	public static BufferedReader bufread;
	
	private static String VERSION_KEY = "iemr.version";

	/**
	 * main方法测试
	 * 
	 * @param s
	 * @throws IOException
	 */
	public static void main(String[] s) throws IOException {
		GenerateBuildNumber generateBuildNumber = new GenerateBuildNumber();
		String settingPath = generateBuildNumber.getSettingPropertiesPath();
		String packageJsonPath = generateBuildNumber.getPackageJsonPath();
		LoggerManager.log(settingPath);
		LoggerManager.log(packageJsonPath);
		String jsonString = FileManager.ReadFile(packageJsonPath);
		LoggerManager.log(jsonString);
		JSONObject jsonObject = JSONObject.parseObject(jsonString);
		Map<String, String> map = (Map<String, String>) jsonObject.get("maintenance");
		String version = map.get("version");
		LoggerManager.log("packageVersion:"+version);
		String oldVersion = PropertiesManager.getInstance(settingPath).getKeyValue(VERSION_KEY);
		String newVersion = generateBuildNumber.getNewVersion(oldVersion);
		map.put("version", newVersion);
		LoggerManager.log(jsonObject.toJSONString());
		FileManager.writeFile(packageJsonPath, jsonObject.toJSONString());
		PropertiesManager.getInstance(settingPath).updateProperties(VERSION_KEY,
				newVersion);
	}

	public String getNewVersion(String oldVersion) {
		LoggerManager.log(oldVersion);
		int oldBuildNumber = 0;
		String newVersion = "";
		if (oldVersion != null) {
			String versions[] = oldVersion.split("\\.");
			LoggerManager.log(versions.length);
			if (versions.length > 3) {
				oldBuildNumber = Integer.parseInt(versions[3]);
				oldBuildNumber++;
				newVersion = versions[0] + "." + versions[1] + "." + versions[2]
						+ "." + oldBuildNumber;
			}
			return newVersion;
		} else {
			throw new RuntimeException("the version is null");
		}
	}

	public String getSourcePath() {
		String path = this.getClass().getResource("/").getPath();
		int rootIndex = path.indexOf("pkuhit-app");
		String root = path.substring(0, rootIndex);
		return root;
	}
	
	public String getSettingPropertiesPath(){
		String root = this.getSourcePath();
		String filePath = "pkuhit-app"+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator;
		return root+filePath;
	}
	
	public String getPackageJsonPath(){
		String root = this.getSourcePath();
		String filePath = "pkuhit.iih.ui"+File.separator+"test"+File.separator+"package.json";
		return root+filePath;
	}
}
