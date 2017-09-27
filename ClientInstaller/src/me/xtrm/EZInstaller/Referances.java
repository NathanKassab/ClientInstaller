package me.xtrm.EZInstaller;

/**
 * @author xTrM_
 */
public class Referances {

//	CHANGE THESE VARS:
	public static String CLIENT_NAME = "YourClientName";
	public static String JAR_LINK = "https://YourWebsite.com/YourClient.jar";
	
	
//	DONT CHANGE THESE VARS!!!!!
	public static final String APPDATA = System.getenv("APPDATA");
	
	public static final String MINECRAFT_FOLDER = APPDATA + "\\" + ".minecraft";
	public static final String VERSIONS_FOLDER = MINECRAFT_FOLDER + "\\" + "versions";	

	public static final String CLIENT_FOLDER = VERSIONS_FOLDER + "\\" + CLIENT_NAME;
	
	public static final String JSON_FILE = Referances.CLIENT_FOLDER + "\\" + Referances.CLIENT_NAME + ".json";
	public static final String JSON_LINK = "https://pastebin.com/raw/DhUyKWta";
	
	public static final String JAR_FILE = Referances.CLIENT_FOLDER + "\\" + Referances.CLIENT_NAME + ".jar";

}
