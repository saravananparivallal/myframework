package com.sample.report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JVMReport {
public static void makeJVMReport(String report) {
	File location =  new File("C:\\Users\\Owern\\eclipse-workspace\\Saravanan\\Reports");
	Configuration con = new Configuration(location,"Saran");
	con.addClassifications("OS", "Windows 8");
	List<String> jsonfiles= new ArrayList<>();
	jsonfiles.add(report);
	ReportBuilder builder = new ReportBuilder(jsonfiles, con);
	builder.generateReports();
}
}
