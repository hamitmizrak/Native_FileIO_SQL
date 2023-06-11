package util;

import lombok.Getter;
import lombok.Setter;
import java.io.File;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class FileNewPath {
    //public static final String MY_PATH_NAME="C:\\io\\ecodation\\eco9.txt";
    //FILE

    private String id;
    private String path;
    private String url;
    private File file;
    private Date systemCreatedDate;

    //parametresiz constructor (Default)
    public FileNewPath() {
        id = UUID.randomUUID().toString();
        systemCreatedDate = new Date(System.currentTimeMillis());
        url = "C:\\io\\ecodation";
        path = url.concat("\\eco9.txt");
        file = new File(path);

        try {
             // Böyle bir dosya var mı? varsa birşey yapma yoksa oluştur.
            // createNewFile: yoksa yeni oluşturulacak
            if(file.createNewFile()){
                System.out.println("Yeni dosya oluşturuldu");
                System.out.println("ID: "+id+" URL: "+url+" Verilen PATH: "+path);
                System.out.println("System Parent: "+file.getParent()+" "+file.getName()+" PATH: "+file.getPath());
            }else{
                System.out.println(path+" Adında Böyle Bir dosya zaten var");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
