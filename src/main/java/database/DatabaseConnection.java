package database;

import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// LOMBOK
@Getter
@Setter
public class DatabaseConnection extends DatabaseInformation {

    // Üst Class gelen verileri almak
    // Connection
    private Connection connection;
    private String user = super.getUser();
    private String password = super.getPassword();
    private String url = super.getUrl();
    private String forNameData = super.getForNameData();

    // Design Pattern (Singleton Design Pattern)
    // Singleton Class
    private static DatabaseConnection instance;

    // Singleton Constructor
    private DatabaseConnection() throws ClassNotFoundException, SQLException {
        try {
            Class.forName(this.forNameData);
            //System.out.println("Driver Basarili bir sekilde yuklendi");
            connection= DriverManager.getConnection(url,user,password);
            //System.out.println("Database Basarili bir sekilde yuklendi");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Singleton getConnection (new)
    public static DatabaseConnection getInstance() {
        try {
            // eğer database bağlantısı varsa veya kapatılmışsa
            // yeni bir instance oluştur
            // eğer bağlantı varsa var olanı kullansın
            if(instance==null || instance.connection.isClosed()){
                instance=new DatabaseConnection();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return instance;
    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //DatabaseConnection connection1=new DatabaseConnection();
    }
}


