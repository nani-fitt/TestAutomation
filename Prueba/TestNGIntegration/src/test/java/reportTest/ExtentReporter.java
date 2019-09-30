package reportTest;


import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Locale;

import org.openqa.selenium.Platform;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	private static ExtentReports extent;
    private static Platform platform;
    private static String reportFileName = "Report.html";
    private static String macPath = System.getProperty("user.dir")+ "/TestReport";
    private static String windowsPath = System.getProperty("user.dir")+ "\\TestReport";
    private static String macReportFileLoc = macPath + "/" + reportFileName;
    private static String winReportFileLoc = windowsPath + "\\" + reportFileName;
    private static String linuxPath = System.getProperty("user.dir")+ "/TestReport";
    private static String linuxFileLoc = linuxPath + "/" + reportFileName;
    
 
    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }
 
    //Create an extent report instance
    public static ExtentReports createInstance() {
    	
        platform = getCurrentPlatform();
        String fileName = getReportFileLocation(platform);
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
//        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
//        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(fileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Help Desk");

 
        extent = new ExtentReports();
//        try {
//
//            extent.setGherkinDialect(Locale.ROOT.getLanguage());
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }

        InetAddress adress;
        String hostname = "";
        String IP = "";
        
		try {
			final DatagramSocket socket = new DatagramSocket();
			adress = InetAddress.getLocalHost();
			hostname = adress.getHostName();
			socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
			IP = socket.getLocalAddress().getHostAddress();
		} catch (UnknownHostException e) {			
			e.printStackTrace();
		} catch (SocketException e) {			
			e.printStackTrace();
		}
        
        extent.setSystemInfo("SO : ", System.getProperty("os.name"));       
        extent.setSystemInfo("Versión de Java: ", System.getProperty("java.version"));
        extent.setSystemInfo("Usuario : ", System.getProperty("user.name"));
        extent.setSystemInfo("Nombre del Host : ", hostname );
        extent.setSystemInfo("Dirección IP : ", IP);
        
        extent.attachReporter(htmlReporter);
 
        return extent;
    }
 
    //Select the extent report file location based on platform
    private static String getReportFileLocation (Platform platform) {
        String reportFileLocation = null;
        switch (platform) {
            case MAC:
                reportFileLocation = macReportFileLoc;
                createReportPath(macPath);
                System.out.println("ExtentReport Path for MAC: " + macPath + "\n");
                break;
            case WINDOWS:
                reportFileLocation = winReportFileLoc;
                createReportPath(windowsPath);
                System.out.println("ExtentReport Path for WINDOWS: " + windowsPath + "\n");
                break;
            case LINUX:
                reportFileLocation = linuxFileLoc;
                createReportPath(linuxPath);
                System.out.println("ExtentReport Path for LINUX: " + linuxFileLoc + "\n");
                break;
            default:
                System.out.println("ExtentReport path has not been set! There is a problem!\n");
                break;
        }
        return reportFileLocation;
    }
 
    //Create the report path if it does not exist
    private static void createReportPath (String path) {
        File testDirectory = new File(path);
        if (!testDirectory.exists()) {
            if (testDirectory.mkdir()) {
                System.out.println("Directory: " + path + " is created!" );
            } else {
                System.out.println("Failed to create directory: " + path);
            }
        } else {
            System.out.println("Directory already exists: " + path);
        }
    }
 
    //Get current platform
    private static Platform getCurrentPlatform () {
        if (platform == null) {
            String operSys = System.getProperty("os.name").toLowerCase();
            if (operSys.contains("win")) {
                platform = Platform.WINDOWS;
            } else if (operSys.contains("nix") || operSys.contains("nux")
                    || operSys.contains("aix")) {
                platform = Platform.LINUX;
            } else if (operSys.contains("mac")) {
                platform = Platform.MAC;
            }
        }
        return platform;
    }
}