package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TestCenterPage {
    public SelenideElement kullaniciAdi=$(By.id("exampleInputEmail1"));
    public SelenideElement kullaniciSifresi=$("#exampleInputPassword1"); //css olduğunda direk tırnak içine yaz tanımlamaya gerek yok
    public SelenideElement submitButton=$(By.xpath("//button[@type='submit']"));
    public SelenideElement girisMesaji=$(By.xpath("//*[contains(text(),'You logged into a secure area!')]"));
    public SelenideElement checkbox1=$(By.id("box1"));
    public SelenideElement checkbox2=$(By.id("box2"));
    public SelenideElement red=$(By.id("red"));
    public SelenideElement football=$(By.id("football"));
    public SelenideElement year=$(By.id("year"));
    public SelenideElement month=$(By.id("month"));
    public SelenideElement day=$(By.id("day"));
    public SelenideElement alertPromptButton=$(By.xpath("//button[@onclick='jsPrompt()']"));
    public SelenideElement sonuc=$("#result"); //#pound işareti css de id demektir
    public SelenideElement techprolink=$(By.xpath("//a[@type='button']"));
    public SelenideElement kaynak=$("#draggable"); //#id işareti
    public SelenideElement hedef=$("#droppable");
    public SelenideElement startButton=$(By.xpath("//div[@id='start']//button"));
    public SelenideElement helloText=$(By.xpath("//div[@id='finish']//h4"));
    public SelenideElement googleImg=$(".lnXdpd");




}
