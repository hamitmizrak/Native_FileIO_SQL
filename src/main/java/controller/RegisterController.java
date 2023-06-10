package controller;

import util.MyPathName;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class RegisterController {

    // Kullanıcı için verilecek hak
    // userData
    private static String userData() {
        Scanner klavye = new Scanner(System.in);
        System.out.println("Lütfen Giriş için Hak sayısını giriniz");
        String data = klavye.nextLine();
        return data;
    }

    // WRITER HAK SAYISI ADMIN BELIRLESIN
    public static void myFileWriter() {
        // false: en son file silsin ve en son eklenen, eklensin.
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(MyPathName.MY_PATH_NAME, false))) {
            String user = userData();
            bufferedWriter.write(user);
            bufferedWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Kalan Hakkı Dosyaya yazsın
    public static void myFileWriterNumberOfRights(int counter) {
        // false: en son file silsin ve en son eklenen, eklensin.
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(MyPathName.MY_PATH_NAME, false))) {
            bufferedWriter.write(String.valueOf(counter));
            bufferedWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // READER HAK SAYISI
    public static int myFileReader() {
        String dataToString = null;
        int numberOfRights; //hak sayısı
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(MyPathName.MY_PATH_NAME))) {
            StringBuilder stringBuilder = new StringBuilder();
            String readRows;
            while ((readRows = bufferedReader.readLine()) != null) {
                stringBuilder.append(readRows);
            }
            dataToString = stringBuilder.toString();
            //System.out.println(dataToString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        numberOfRights = Integer.valueOf(dataToString);
        return numberOfRights;
    }

    // username: root password:root => admin sayfasına yönlendirsin
    // eğer yanlış yaparsa haktan 1 azaltsın eğer hakkınız kalmazsa sistemi kilitlesin
    public static boolean isLogin() {
        // Hak sayısı
        int counter = myFileReader();
        // interface abstract inheritance nedir ? bunlarsınız kod yazabilir miyiz?
        if (counter == 0) {
            if (counter == 0) {
                System.out.println("Hakkınız kalmadı hesanız bloke oldu");
                System.exit(0);
            }
        } else if (counter >= 1) {
            String userEmail, userPassword;
            Scanner klavye = new Scanner(System.in);
            System.out.println("\nLütfen Emailinizi giriniz");
            userEmail = klavye.nextLine();
            System.out.println("Lütfen Şifrenizi giriniz");
            userPassword = klavye.nextLine();
            if (MyPathName.FAKE_PASSWORD.equals(userPassword) && MyPathName.FAKE_EMAIL.equals(userEmail)) {
                System.out.println("Admin Sayfasına Yönlendiriliyorsunuz");
                return true;
            } else {
                System.out.println("Kalan Hakkınız: " + (counter - 1));
                System.out.println("Kullanıcı adınız veya şifreniz yanlış");
                counter--;
                myFileWriterNumberOfRights(counter);
            }
        }
        return false;
    }


    // LOGIN REGISTER
    private static void isLoginRegister(){
        boolean result=false;

        // Login Register
        while (true) {
            result = isLogin();
            if (result)
                break;
        }

        // Eğer sistemde bir kullanıcı varsa bu sayyfaya gitsin
        if(result){
            blogPage();
        }
    }

    // BLOG PAGE
    private static void blogPage(){
        System.out.println("Blog Main sayfasına Hoş geldiniz");
        System.out.println("Lütfen seçiminizi yapınız");
    }

    public static void main(String[] args) {
        isLoginRegister();

    }

} //end class
