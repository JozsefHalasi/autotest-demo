# encoding: utf-8
# language: hu
Jellemző: Házi feladat

@Smoke
Forgatókönyv: Verify error messages for mandatory fields

    Amikor Megnyitom az "http://automationpractice.com/index.php" oldalt
    Akkor Az "http://automationpractice.com/index.php" oldal betöltött

    Amikor A SIGNIN gombra kattintok 
    Akkor Az "http://automationpractice.com/index.php?controller=authentication&back=my-account" oldal betöltött

    Amikor Beírom az "@myemail.com" címem
    És A CREATE_ACCOUNT gombra kattintok
    Akkor Az "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation" oldal betöltött
    
    Amikor Kitöltöm a hiányos adatokat
    És Várok 2 másodpercet
    És A REGISTER gombra kattintok
    Akkor Az "http://automationpractice.com/index.php?controller=authentication" oldal betöltött

    Amikor Várok 2 másodpercet
    Akkor Error megjelent
    És Az oldalt bezárom