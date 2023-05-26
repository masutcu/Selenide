package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TestCenterPage {
    public SelenideElement kullaniciAdi=$(By.id("exampleInputEmail1"));
    public SelenideElement kullaniciSifresi=$("#exampleInputPassword1"); //css olduğunda direk tırnak içine yaz tanımlamaya gerek yok
    public SelenideElement submitButton=$(By.xpath("//button[@type='submit']"));
    public SelenideElement girisMesaji=$(By.xpath("//*[contains(text(),'You logged into a secure area!')]"));


}
