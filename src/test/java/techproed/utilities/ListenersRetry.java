package techproed.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
// Tekrar Dene test case fail olduğunda tekrar calıştırı
public class ListenersRetry implements IRetryAnalyzer{
   // BU SINIF SADECE FAİL OLAN TEST CASELERE TEKRAR CALISTIRIR
    private int retryCount=0;
 // maxRetryCount EK OLARAK CALISMA SAYISİ.BU ÖRNEKDE FAİL OLAN TESTLER EXTRA  1 KEZ DAHA CALIŞIR
    private static final int maxRetryCount=2;
    @Override
      public boolean retry(ITestResult result){

        if (retryCount< maxRetryCount){
            retryCount++;
            return true;

        }
    return false;
    }




}
