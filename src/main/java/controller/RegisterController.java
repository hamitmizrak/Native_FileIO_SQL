package controller;

import util.InMemoryData;
import util.FileNewPath;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class RegisterController {

    private FileNewPath fileNewPath = new FileNewPath();


    // Kullanıcı için verilecek hak
    // userData
    private static String userData() {
        Scanner klavye = new Scanner(System.in);
        System.out.println("Lütfen Giriş için Hak sayısını giriniz");
        String data = klavye.nextLine();
        return data;
    }

    // WRITER HAK SAYISI ADMIN BELIRLESIN
    private void adminMyFileWriter() {
        // false: en son file silsin ve en son eklenen, eklensin.
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileNewPath.getPath(), false))) {
            String user = userData();
            bufferedWriter.write(user);
            bufferedWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // redirect
        myFileReader();
    }

    // Kalan Hakkı Dosyaya yazsın
    private void myFileWriterNumberOfRights(int counter) {
        // false: en son file silsin ve en son eklenen, eklensin.
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileNewPath.getPath(), false))) {
            bufferedWriter.write(String.valueOf(counter));
            bufferedWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // READER HAK SAYISI
    private int myFileReader() {
        String dataToString = null;
        Integer numberOfRights = null; //hak sayısı
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileNewPath.getPath()))) {
            StringBuilder stringBuilder = new StringBuilder();
            String readRows;
            while ((readRows = bufferedReader.readLine()) != null) {
                stringBuilder.append(readRows);
            }
            dataToString = stringBuilder.toString();
            System.out.println(dataToString);
            if(dataToString.equals("") || dataToString.equals(" ")|| dataToString=="" || dataToString==" " || dataToString==null){
                adminMyFileWriter();
            }
            numberOfRights = Integer.valueOf(dataToString);
            System.out.println(numberOfRights);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numberOfRights;
    }

    // username: root password:root => admin sayfasına yönlendirsin
    // eğer yanlış yaparsa haktan 1 azaltsın eğer hakkınız kalmazsa sistemi kilitlesin
    private boolean isLogin() {
        // Hak sayısı (Admin)
        //myFileWriter();
        Integer counter = myFileReader();
        System.out.println(counter);
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
            if (InMemoryData.FAKE_PASSWORD.equals(userPassword) && InMemoryData.FAKE_PASSWORD.equals(userEmail)) {
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
    public void isLoginRegister() {
        boolean result = false;

        // Login Register
        while (true) {
            result = isLogin();
            if (result)
                break;
        }

        // Eğer sistemde bir kullanıcı varsa bu sayyfaya gitsin
        if (result) {
            blogPage();
        }
    }

    // BLOG PAGE
    private static void blogPage() {
        BlogController blogController = new BlogController();
        for (; ; ) { // Sonsuz Döngü
            blogController.chooiseMethod();
        }
    }


} //end class
