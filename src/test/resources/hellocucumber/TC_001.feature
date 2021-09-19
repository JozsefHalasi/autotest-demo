# encoding: utf-8
# language: hu
Jellemző: Házi feladat

@Smoke
Forgatókönyv: Automate User Registration Process

    Amikor Megnyitom az "http://automationpractice.com/index.php" oldalt
    Akkor Az "http://automationpractice.com/index.php" oldal betöltött

    Amikor A SIGNIN gombra kattintok 
    Akkor Az "http://automationpractice.com/index.php?controller=authentication&back=my-account" oldal betöltött

    Amikor Beírom az "@myemail.com" címem
    És A CREATE_ACCOUNT gombra kattintok
    Akkor Az "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation" oldal betöltött
    
    Amikor Kitöltöm az adatokat
    És Várok 2 másodpercet
    És A REGISTER gombra kattintok
    Akkor Az "http://automationpractice.com/index.php?controller=my-account" oldal betöltött

    Amikor Várok 2 másodpercet
    Akkor Sikeres regisztráció
    És Az oldalt bezárom