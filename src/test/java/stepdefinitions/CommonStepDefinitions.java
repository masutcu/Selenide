package stepdefinitions;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.*;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.*;

public class CommonStepDefinitions {


    @Given("kullanici {string} adresine gider")
    public void kullaniciAdresineGider(String string) {
        open(string);
    }
    @Then("{int} saniye bekler")
    public void saniye_bekler(Integer int1) {
        //selenide default olarak 4 saniye bekler
        //4 saniyeden fazla beklemek için sleep  metodu kullanılır
        sleep(int1*1000);

    }
    @Then("onceki sayfaya gider")
    public void onceki_sayfaya_gider() {
        back();

    }
    @Then("sonraki sayfaya gider")
    public void sonraki_sayfaya_gider() {
    forward();
    }
    @Then("sayfayi yeniler")
    public void sayfayi_yeniler() {
        refresh();
    }
    @Then("sayfayi acik tutar")
    public void sayfayi_acik_tutar() {
        //varsayılan selenide ayarlarında browser otomatik kapanır
      //  Configuration.holdBrowserOpen=false;  //Default durum
        Configuration.holdBrowserOpen=true;

    }

    @And("tum ekran goruntusunu alir")
    public void tumEkranGoruntusunuAlir() {
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        Selenide.screenshot(date);
    }
}
