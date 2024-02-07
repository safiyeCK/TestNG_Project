package team02.utilities;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Extent_Reports {

        public static com.aventstack.extentreports.ExtentReports extentReport;//-->raporlamayı başlatır
        public static ExtentHtmlReporter extentHtmlReporter;//-->Html formatında rapor oluşturur
        public static ExtentTest extentTest;//-->Test adımlarına bilgi eklenir
        //Extent Report
        public static void rapor(String browser,String reportName,String teamMember){
            extentReport = new com.aventstack.extentreports.ExtentReports();
            String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
            String dosyaYolu = "target/ExtentReport/report"+tarih+".html";
            extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
            extentReport.attachReporter(extentHtmlReporter);
            //Raporda gözükmesini istediğimiz bilgiler
            extentReport.setSystemInfo("Tester",teamMember);
            extentReport.setSystemInfo("browser",browser);
            extentHtmlReporter.config().setDocumentTitle("ExtentReport");
            extentHtmlReporter.config().setReportName(reportName);
        }
    }
































