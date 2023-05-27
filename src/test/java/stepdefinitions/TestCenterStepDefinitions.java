package stepdefinitions;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.TestCenterPage;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.visible;

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
}