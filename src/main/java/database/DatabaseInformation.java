package database;

import lombok.Getter;
import lombok.Setter;

// LOMBOK
@Getter @Setter
public class DatabaseInformation {
   private String user;
   private String password;
   private String url;
   private String forNameData;

   // parametresiz constructor
    public DatabaseInformation() {
        this.user="root";
        this.password="root";
        this.url="jdbc:mysql://localhost:3306/one_page";
        this.forNameData="com.mysql.cj.jdbc.Driver";
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
