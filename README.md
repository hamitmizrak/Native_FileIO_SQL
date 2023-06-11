# Java File/IO and SQL

## Proje Tanımı

Projemiz FİLE/IO ve Native SQL üzerine kurulurudur.
Amaçımız Register/Login ve CRUD işlemlerini anlamak.

STEP:1
Login olabilmek için inmemory olarak verdiğimiz  email: root ve password:root kullancıdan bu bilgileri isteyelim.
Eğer bu bilgileri doğru girmezse admin tarafıdnan daha önceden verilen kullanıcı giriş hakkından aşağıya doğru düşecek
eğer kullancının hakkı kalmazsa yani sıfır olursa kullanıcı kilitlensin Unutma: bu kiliti ancak admin açabilir.
Buradaki Hak sayısını FİLE/IO üzerinden yaparak FİLE IO Writer/Reader yapmak zorundayız.
VALIDATION:
FileIO: default olarak: C:\io\ecodation\eco9.txt olmasını sağlıyalım. ancak admin isterse bu URL değiştirebilsin.

STEP:2
Eğer kullanıcı sisteme giriş yaparsa BlogDto için
-EKLEME
-SİLME
-GÜNCELLEME
-LİSTELEME
-BULMA 
yapabilsin

STEP:3
VALİDATION
Silme,Güncelleme ve Find için eğer kullanıcının girdiği ID sistemde yoksa olmadığını belirtsin.
Silmede: JOptionalPane ShowDialog soru sorsun silmek istediğinizde emin misiniz ?
----------

## Project Step
```sh
1. Login  ==> just login, You have to File /Read/ Writer
İmportant Login is try must be 4 
 
2. Register (You have to Register, with SQL)
```
