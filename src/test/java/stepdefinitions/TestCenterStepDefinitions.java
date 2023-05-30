package stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.TestCenterPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

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

    @And("switch to frame {int}")
    public void switchToFrame(int numOfFrame) {
        switchTo().frame(numOfFrame-1);//index 0 dan başladığı için

    }

    @And("kullanici back to techproeducation linkine tiklar")
    public void kullaniciBackToTechproeducationLinkineTiklar() {
        testCenterPage.techprolink.click(); //yeni pencere açıldı
      // System.out.println("sayfa url : "+ WebDriverRunner.url());
        System.out.println("sayfa url : "+ url()); //sayfa url sini verecek
    }

    @And("switch to window {int}")
    public void switchToWindow(int targetIndexWindow) {
        switchTo().window(targetIndexWindow-1, Duration.ofSeconds(5));//duration second zorunlu değil bekleme ekliyor
        System.out.println("yeni sayfa url :"+url()); //yeni sayfa url sini verecek
    }

    @And("kullanici source elementi target elementine surukler")
    public void kullaniciSourceElementiTargetElementineSurukler() {
        //SELENİDE DE DİREK actions() metodunu selenide den import ile kullanabiliriz
        actions().
                dragAndDrop(testCenterPage.kaynak,testCenterPage.hedef).build().perform();
        //veya koordinatlar ile 3 parametre, 1 kaynak elementi, 2. x koordinat 3. y kordinat
        actions().dragAndDropBy(testCenterPage.kaynak,463,-19).build().perform();
    }

    @And("kullanici source elementini {int} by {int} koordinatlarina surukler")
    public void kullaniciSourceElementiniByKoordinatlarinaSurukler(int xOffset, int yOffset) {
        actions().dragAndDropBy(testCenterPage.kaynak,xOffset,yOffset).build().perform();
        
    }

    @And("verilen koordinatlara {int} by {int} suruklendigini dogrular")
    public void verilenKoordinatlaraBySuruklendiginiDogrular(int x, int y) {
        String styValue=testCenterPage.kaynak.getAttribute("style");
        System.out.println(styValue);
        Assert.assertTrue( styValue.contains(String.valueOf(x)) && styValue.contains(String.valueOf(y)));
    }

    @And("start butonuna tiklar")
    public void startButonunaTiklar() {
        testCenterPage.startButton.click();

    }

    @Then("kullanici {string} yazisini dogrular")
    public void kullaniciYazisiniDogrular(String arg0) throws InterruptedException {
        Assert.assertEquals(arg0,testCenterPage.helloText.getText());//fail bekleme sorunu
       // 1. WebDriver wait kullanarak beklenebilir
     //   WebDriverWait wait=new WebDriverWait(WebDriverRunner.getWebDriver(),Duration.ofSeconds(10));
     //   wait.until(ExpectedConditions.visibilityOf(testCenterPage.helloText)); //explicitwait
     //   Assert.assertEquals(arg0,testCenterPage.helloText.getText());

        //2. selenide wait
        testCenterPage.helloText.should(visible,Duration.ofSeconds(20));
        Assert.assertEquals(arg0,testCenterPage.helloText.getText());
}

    @And("google image goruntusunu alir")
    public void googleImageGoruntusunuAlir() {
        testCenterPage.googleImg.screenshot();

    }

    @And("footerelementi gorunur sekilde goster")
    public void footerelementiGorunurSekildeGoster() {

        executeJavaScript("arguments[0].scrollIntoView(true);",testCenterPage.amazonFooter);
    }
}