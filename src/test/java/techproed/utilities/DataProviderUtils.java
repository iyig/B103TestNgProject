package techproed.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {

    @DataProvider
    public Object[][] musteriVerileri() {
        Object[][] musteriGirisBilgileri = {
                {"menejer1", "12345","besiktas"},
                {"menejer2", "98765","cebeci"},
                {"menejer3", "5678","karsıyaka"}

        };
        return musteriGirisBilgileri;

    }

    @DataProvider
    public Object[][] musteriHizmetleriVerileri() {
        Object[][] musteriHizmetleriGirisBilgileri = {
                {"adam1", "3456"},
                {"ali2", "1234"},
                {"nancy3", "7890"}

        };
        return musteriHizmetleriGirisBilgileri;
    }

    @DataProvider
    public Object[][] personelVerileri() {
        Object[][] personelGirisBilgileri = {
                {"rukiye1", "abc1"},
                {"mehmet2", "123r"},
                {"emin3", "3edc"},
                {"baran3","4asd"},
                {"okkumus3","3edc"}
        };
        return personelGirisBilgileri;
    }
//  Excelden dataprovider a data gelir
 //  Burdan da Test case e gider
@DataProvider
public Object[][] customerData(){
//        DataProviderTest2 ile bu metot arasındaki tek fark bu metota datalr Excelden gelir.
    //       Bu kullanım daha güzeldir
    String path="./src/test/java/resources/ulkeler.xlsx";
    String sayfa="customer_info";
    ExcelUtils excelUtils=new ExcelUtils(path,sayfa);

    Object[][] musteriBilgileri=excelUtils.getDataArrayWithoutFirstRow();

    return musteriBilgileri;
}
}