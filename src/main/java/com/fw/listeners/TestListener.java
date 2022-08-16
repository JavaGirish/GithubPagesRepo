package com.fw.listeners;

import com.fw.reports.ExtentLogger;
import com.fw.reports.ExtentReport;
import com.fw.utils.ElkResultUtils;

import org.testng.*;

public class TestListener implements ITestListener, ISuiteListener {


    public void onStart(ISuite suite) {
        ExtentReport.initReports();
    }


    public void onFinish(ISuite suite) {
    ExtentReport.flushReports();
    }


    public void onTestStart(ITestResult result) {
     ExtentReport.createTest(result.getMethod().getMethodName());
    }


    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName() + " has passed");
    }


    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getMethod().getMethodName() + " has failed");
    }


    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName() + " has skipped");
}


    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }


    public void onStart(ITestContext context) {
    }


    public void onFinish(ITestContext context) {

    }
}
