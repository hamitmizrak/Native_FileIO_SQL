package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;
import java.util.Scanner;

public class FileTutorials {

    // nowDate
    private static String nowDate() {
        Date date = new Date();
        String nowChange = "\n" + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds() + "\t";
        return nowChange;
    }

    // userData
    private static String userData() {
        Scanner klavye = new Scanner(System.in);
        System.out.println("Lütfen bir şeyler yazınız");
        String data = klavye.nextLine();
        String concatString = nowDate().concat(data);
        return concatString;
    }

    // WRITER
    public static void myFileWriter() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(MyPathName.MY_PATH_NAME, true))) {
            String user = userData();
            bufferedWriter.write(user);
            bufferedWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // READER
    public static void myFileReader() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(MyPathName.MY_PATH_NAME))) {
            StringBuilder stringBuilder = new StringBuilder();
            String readRows;
            while ((readRows = bufferedReader.readLine()) != null) {
                stringBuilder.append("\n").append(readRows);
            }
            String dataToString = stringBuilder.toString();
            System.out.println(dataToString);
            System.out.println("OKUNDU");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fileTutorials() {
        try {
            // C:\io\ecodation\eco9.txt
           /* File file = new File(MyPathName.MY_PATH_NAME);

            System.out.println("### IS ###");
            System.out.println(file.isFile());
            System.out.println(file.isDirectory());
            System.out.println("SAKLI MI " + file.isHidden());

            System.out.println("### CAN ###");
            System.out.println("Read: " + file.canRead());
            System.out.println("Write: " + file.canWrite());
            System.out.println("Execute: " + file.canExecute());

            System.out.println("###  ###");
            System.out.println("setExecutable: " + file.setExecutable(false));
            System.out.println("setWritable: " + file.setWritable(false));
            System.out.println("setReadable: " + file.setReadable(false));

            System.out.println("Read: " + file.canRead());
            System.out.println("Write: " + file.canWrite());
            System.out.println("Execute: " + file.canExecute());

            System.out.println("### GET ###");
            System.out.println("ADI: " + file.getName());
            System.out.println("PATH: " + file.getPath());
            System.out.println("PARENT FILE: " + file.getParentFile());
            System.out.println("FREE SPACE: " + file.getFreeSpace());
            System.out.println("TOTAL SPACE: " + file.getTotalSpace());
            System.out.println("Absolute Path: " + file.getAbsolutePath());
            System.out.println("Canonical Path: " + file.getCanonicalPath());*/

            // PATH, Absolute Path, Canonical Path

            // Relative Path(Dynamics), Absolute Path(static: domain ismini yazarız)
            // Relative Path(Dynamics) ==> /picture/register.png
            // Absolute Path(static)   ==> www.deneme.com/picture/register.png

            // URL: ana kaynak / URI: resim belge tam adresi
            // URL : www.deneme.com
            // URI : www.deneme.com/resim/register.png
            // URI=URL/picture
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) {
       // myFileWriter();
        myFileReader();

    }
}
