Feature: iframe _ windows
  @iframe
  Scenario: TC01 iframe ve window
    Given kullanici "https://testcenter.techproeducation.com/index.php?page=iframe" adresine gider
    And switch to farme 1
    And kullanici back to techproeducation linkine tiklar
    And switch to window 2
    Then sayfayi acik tutar

    #Selenide de
  #Selenide iframe içindeki elementleri direk göremez  öncelikle switchTo()frame ile geçiş gerekir.
  #3 farklı yol ile geçiş yapılabilir
  #switchTo()frame() ==> index alır
  #switchTo()frame("id") ==> name veya id attiribute varsa
  #switchTo()frame($(By.xpath("xpath")) ==> "" value değeri alır

  #Ayrıca Selenide de açılan yeni pencereye geçmek selenium a göre daha kolaydır
  #seleniumda windowhandle değerleri set e alınır
  #selenide de ise switchTo().window() metodu ile açılan pencerenin index nosu ile geçiş yapılabilir.
