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

    // WRITER HAK SAYISI
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
            System.out.println(dataToString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        numberOfRights = Integer.valueOf(dataToString);
        return numberOfRights;
    }

    // username: root password:root => admin sayfasına yönlendirsin
    // eğer yanlış yaparsa haktan 1 azaltsın eğer hakkınız kalmazsa sistemi kilitlesin
    public static boolean isLogin() {
        String userEmail, userPassword;
        Scanner klavye = new Scanner(System.in);
        System.out.println("\nLütfen Emailinizi giriniz");
        userEmail = klavye.nextLine();
        System.out.println("Lütfen Şifrenizi giriniz");
        userPassword = klavye.nextLine();

        // Hak sayısı
        int counter = myFileReader();
        // interface abstract inheritance nedir ? bunlarsınız kod yazabilir miyiz?
        if (counter >= 0) {
            if (MyPathName.FAKE_PASSWORD.equals(userPassword) && MyPathName.FAKE_EMAIL.equals(userEmail)) {
                System.out.println("Admin Sayfasına Yönlendiriliyorsunuz");
                return true;
            } else {
                System.out.println("Kalan Hakkınız: "+(counter-1));
                System.out.println("Kullanıcı adınız veya şifreniz yanlış");
                if (counter == 0) {
                    System.out.println("Hakkınız kalmadı hesanız bloke oldu");
                }
                counter--;
                myFileWriterNumberOfRights(counter);
            }
        }else{
            myFileWriter();
        }
        return false;
    }

    public static void main(String[] args) {
        // myFileWriter();
        // System.out.println(myFileReader());
        while (true) {
            boolean result = isLogin();
        }

    }

} //end class
