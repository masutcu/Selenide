package stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.TestCenterPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.switchTo;

public class TestCenterStepDefinitions {
    TestCenterPage testCenterPage = new TestCenterPage();

    @And("kullanici adini gir")
    public void kullaniciAdiniGir() {
        testCenterPage.kullaniciAdi.setValue("techproed");
    }

    @And("kullanici sifresini gir")
    public void kullaniciSifresiniGir() {
        testCenterPage.kullaniciSifresi.setValue("SuperSecretPassword");

    }

    @When("submit butonuna tikla")
    public void submitButonunaTikla() {
        testCenterPage.submitButton.click();
    }

    @Then("giris yapildigini test et")
    public void girisYapildiginiTestEt() {
        //   Assert.assertTrue(testCenterPage.girisMesaji.isDisplayed()); //junit
        testCenterPage.girisMesaji.shouldBe(visible); //selenide assertion
    }


    @And("{string} secili degilse sec")
    public void seciliDegilseSec(String checkbox) {
        if (checkbox.equals("Checkbox1") && !testCenterPage.checkbox1.isSelected()) {
            testCenterPage.checkbox1.click();
            testCenterPage.checkbox1.shouldBe(checked); //assertion
        }
        if (checkbox.equals("Checkbox2") && !testCenterPage.checkbox2.isSelected()) {
            testCenterPage.checkbox2.shouldNotBe(checked);
            testCenterPage.checkbox2.click();
            testCenterPage.checkbox2.shouldBe(checked); //assertion
        }
        if (checkbox.equals("Red") && !testCenterPage.red.isSelected()) {
            testCenterPage.red.shouldNotBe(checked);
            testCenterPage.red.click();
            testCenterPage.red.shouldBe(checked);

        }
        if (checkbox.equals("Red") && !testCenterPage.football.isSelected()) {
            testCenterPage.football.shouldNotBe(checked);
            testCenterPage.football.click();
            testCenterPage.football.shouldBe(checked);
        }
    }

    @And("kullanici yil olarak {int}, ay olarak {string}, gun olarak {int} secer")
    public void kullaniciYilOlarakAyOlarakGunOlarakSecer(int year, String month, int day) {
        //Select objesi kullanmaya gerek yoktur. selenide de 3 temel select option vardır.
        //selectOption() ==> index alır
        //selectOption() ==> "" içinde yani string olarak visible text alarak kullanılır
        //selectOptionByValue ==> "" value değeri alır

        testCenterPage.year.selectOption(String.valueOf(year)); //visible text olarak alır
        sleep(3000); //selenide wait. selenide den import ettik 3 saniyeye kadar bekler
        testCenterPage.month.selectOption(month); //görünen metin POPÜLER OLAN
        sleep(3000); // wait
        testCenterPage.day.selectOption(day-1);
        //Selenide.sleep(3000); //dinamik  3 saniyeye kadar bekler
        //Thread.sleep(3000); // hard 3 saniye bekler
    }

    @And("alert prompt butonuna tiklar")
    public void alertPromptButonunaTiklar() {
        testCenterPage.alertPromptButton.click();
        
    }

    @And("kullanici alerte {string} metnini yazar ve ok tiklar")
    public void kullaniciAlerteMetniniYazarVeOkTiklar(String text) throws InterruptedException {

        switchTo().alert().sendKeys(text);
        Thread.sleep(3000);
        switchTo().alert().accept();
        sleep(3000);
        
    }

    @And("kullanici sonucun {string} icerdigini dogrular")
    public void kullaniciSonucunIcerdiginiDogrular(String yazi) {
        testCenterPage.sonuc.shouldHave(text(yazi)); //selenide
      //  Assert.assertTrue(testCenterPage.sonuc.getText().contains(yazi)); //selenium junit
        sleep(3000);
    }
}