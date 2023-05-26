@locaters
  Feature: locaters
    Scenario: TC01 locaters
      Given kullanici "https://testcenter.techproeducation.com/index.php?page=form-authentication" adresine gider
      And 3 saniye bekler
      And kullanici adini gir
      And 3 saniye bekler
      And kullanici sifresini gir
      And 3 saniye bekler
      When submit butonuna tikla
      And 3 saniye bekler
      Then giris yapildigini test et

      #1. feature file oluştur
      #2. test case leri yaz
      #3. yeni test adimlari için step definitions olustur
      #4. page class olustur locate leri al

