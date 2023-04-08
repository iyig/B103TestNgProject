package techproed.utilities;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ListenersRetryAnalyzer implements IAnnotationTransformer {
   //Bu sinifin amac, TUM FAİLE TEST CASELERİ BİR KEZ DAHA AUTOMATİK OLARAK XML FİLE İLE RUN ETMEK
   // BU SINIF ListenersRetry sinifini xml de kullanabilmek için olusturuldu
   @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod){

  // BU sinif ListenersRetry util classina baglıdır
     annotation.setRetryAnalyzer(ListenersRetry.class);

    }



}
