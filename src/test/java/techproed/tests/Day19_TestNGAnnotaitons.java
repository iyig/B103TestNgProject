package techproed.tests;

import org.testng.annotations.*;

public class Day19_TestNGAnnotaitons {

    /*
    @Test: Test case olusturmak icin kullanilir
    @Before ve @After:5 Before 5 After anotations var
    suite> tests>grup>class>method
    @BeforeSuite: her bir test suite den önce 1 sefer calışır
    @AfterSuite: her bir test suiteden sonra 1 sefer calışır
    @BeforeTest: her bir test(Test case ile Karıştırılmamalı) 1 sefer calışır
    @AfterTest:her bir testden sonra 1 sefer calışır
    @BeforClass: her bir classdan önce 1 sefer calışır
    @AfterClass: her bir classdan sonra 1 sefer çalışır
    @BeforeMethod: her bir @Test annotationdan  önce tek sefer çalışır. JUnitedki karşılğı @Before sonra  sonra 1 sefer calışır
    @AfterMethod:her bir @Test annotationdan  sonra tek sefer çalışır. JUnitedki karşılğı @After sonra  sonra 1 sefer calışır
@Ignore: @Test caseleri atlamak skip ignore için kullanır
@Test(enabled=false): @Test caseleri kullanıma kapatmak icin kullanilir
default priotery  sifir dir

     */
   @BeforeSuite
   public void beforeSuite(){
       System.out.println("Before Suite");
   }
    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
}
    @BeforeGroups
    public void beforeGroups(){
        System.out.println("Before Groups");
    }

    @BeforeClass
    public static void beforeClass(){
        System.out.println("Before Class");
    }
    @BeforeMethod
   public void beforeMethod(){
        System.out.println("Before method");
}
  @AfterSuite
    public void afterSuite(){
      System.out.println("After Suite");
    }
@AfterTest
public void afterTest(){
    System.out.println("After Test");
}
@AfterClass
public static void afterClass(){
    System.out.println("After Class");
}

  @AfterMethod
  public void afterMethod(){
      System.out.println("After Method");
  }





   @Test(priority = 1,groups = "regression-tests")
    public void test7(){
    System.out.println("Test 7");
    }
     @Test@Ignore
    public void test2(){
        System.out.println("Test 2");
    }
     @Test(enabled = false,groups = "regression-tests")
    public void test3(){
        System.out.println("Test 3");
    }
     @Test
    public void test4(){
        System.out.println("Test 4");
    }

     @Test(priority = 2)
    public void test5(){
        System.out.println("Test 5");
    }
     @Test(priority = -5)
    public void test6(){
        System.out.println("Test 6");
    }











}
