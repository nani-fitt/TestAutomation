package reportTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Class.TestBase;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Locale;

public class TestListener extends TestBase implements ITestListener {

    //Extent Report Declarations
    private static ExtentReports extent = ExtentReporter.createInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();    
    ExtentTest suite;

    @Override
    public synchronized void onStart(ITestContext context) {
        System.out.println("Test Suite started!");
        String iSuite = context.getSuite().getName();
        if (!context.getSuite().getAllMethods().isEmpty()) {
            suite = extent.createTest(iSuite);
        }
        test.set(suite);
    }

    @Override
    public synchronized void onFinish(ITestContext context) {
        System.out.println(("Test Suite is ending!"));
        extent.flush();
    }

    @Override
    public synchronized void onTestStart(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " started! " + result.getTestName()));
        ExtentTest extentTest = suite.createNode(result.getMethod().getMethodName(),result.getMethod().getDescription());
        test.set(extentTest);
    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " passed!"));
        test.get().pass("Test passed");
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " failed!"));
        test.get().fail(result.getThrowable());
    }

    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " skipped!"));
        test.get().skip(result.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
    }
}