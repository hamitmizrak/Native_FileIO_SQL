package database;

import lombok.Getter;
import lombok.Setter;
import util.FileNewPath;

// LOMBOK
@Getter @Setter
public class DatabaseInformation {
   private String user;
   private String password;
   private String url;
   private String forNameData;

   // File Path Name
   private FileNewPath fileNewPath;

   // parametresiz constructor
    public DatabaseInformation() {
        this.user="root";
        this.password="root";
        this.url="jdbc:mysql://localhost:3306/one_page";
        this.forNameData="com.mysql.cj.jdbc.Driver";
        // New File Path
        fileNewPath=new FileNewPath();
    }
    // parametreli constructor
    // String user, String password, String url, String forNameData
    public DatabaseInformation(String user, String password, String url, String forNameData) {
        this.user = user;
        this.password = password;
        this.url = url;
        this.forNameData = forNameData;
    }
}
