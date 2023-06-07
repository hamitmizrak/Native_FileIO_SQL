package util;

import java.io.File;
import java.io.IOException;

public class FileTutorials {
    public static void main(String[] args) throws IOException {
        try {
            // C:\io\ecodation\eco9.txt
            File file = new File(MyPathName.MY_PATH_NAME);

            System.out.println("### IS ###");
            System.out.println(file.isFile());
            System.out.println(file.isDirectory());
            System.out.println("SAKLI MI "+file.isHidden());

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
            System.out.println("Canonical Path: " + file.getCanonicalPath());

            // PATH, Absolute Path, Canonical Path

            // Relative Path(Dynamics), Absolute Path(static)
            // Relative Path(Dynamics) ==> /picture/admin
            // Absolute Path(static)   ==> /picture/admin/register.png
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
