package stepdefinitions;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.TestCenterPage;

import static com.codeborne.selenide.Condition.visible;

public class TestCenterStepDefinitions {
    TestCenterPage testCenterPage=new TestCenterPage();
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
}
