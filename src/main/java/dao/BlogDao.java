package dao;

import dto.BlogDto;
import exception.ResourceNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BlogDao implements IDaoGenerics<BlogDto> {

    // CREATE
    @Override
    public void create(BlogDto blogDto) {
        try (Connection connection = getInterfaceConnection()) {
            // Transaction: ya hep ya hiç kuralına göre çalışır
            // Create, Delete, Update
            connection.setAutoCommit(false);
            // insert into one_page.blog (header,content) values ("Css2","Cont data css");
            String sql = "insert into one_page.blog (header,content) values (?,?)";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, blogDto.getHeader());
            pstm.setString(2, blogDto.getContent());
            // EKLEME YAPISILSIN
            // executeUpdate: CREATE, DELETE, UPDATE
            // executeQuery : SELECT
            Integer rowsEffected = pstm.executeUpdate();
            // Eğer Sıfırdan büyükse : Eklemiş -1=ise Eklenmemiş
            if (rowsEffected > 0) {
                System.out.println(BlogDto.class + " Eklendi");
                connection.commit();
            } else {
                System.out.println(BlogDto.class + " HATA Eklenmedi !!!!");
                connection.rollback();
            }
        } catch (SQLException sql) { // AritmeticException | ClassNotFoundException e
            sql.printStackTrace();
            throw new ResourceNotFoundException(" SQL Ekleme İstisnası " + sql);
        } catch (Exception e) { // AritmeticException | ClassNotFoundException e
            e.printStackTrace();
        }
    } // end CREATE

    // LIST
    @Override
    public ArrayList<BlogDto> list() {
        ArrayList<BlogDto> blogDtoList = new ArrayList<>();
        BlogDto blogDto;
        try (Connection connection = getInterfaceConnection()) {
            // select * from one_page.blog;
            String sql = "select * from one_page.blog";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                blogDto = new BlogDto();
                blogDto.setId(resultSet.getLong("id"));
                blogDto.setHeader(resultSet.getString("header"));
                blogDto.setContent(resultSet.getString("content"));
                blogDto.setSystemCreatedDate(resultSet.getDate("created_date"));
                // liste ekleme
                blogDtoList.add(blogDto);
            }
        } catch (SQLException sql) { // AritmeticException | ClassNotFoundException e
            sql.printStackTrace();
            throw new ResourceNotFoundException(" SQL Listeme İstisnası " + sql);
        } catch (Exception e) { // AritmeticException | ClassNotFoundException e
            e.printStackTrace();
        }
        return blogDtoList;
    } // end LIST

    // FIND
    @Override
    public BlogDto findById(Long id) {
        BlogDto blogDto = new BlogDto();
        try (Connection connection = getInterfaceConnection()) {
            // select * from one_page.blog where id =1;;
            String sql = "select * from one_page.blog where id=" + id;
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet resultSet = pstm.executeQuery();
            //System.out.println(resultSet.next());
            //boolean isFind=resultSet.first();
            while (resultSet.next()) {
                blogDto.setId(resultSet.getLong("id"));
                blogDto.setHeader(resultSet.getString("header"));
                blogDto.setContent(resultSet.getString("content"));
                blogDto.setSystemCreatedDate(resultSet.getDate("created_date"));
            }
            System.out.println(blogDto);
        } catch (SQLException sql) { // AritmeticException | ClassNotFoundException e
            sql.printStackTrace();
            throw new ResourceNotFoundException(" SQL Find İstisnası " + sql);
        } catch (Exception e) { // AritmeticException | ClassNotFoundException e
            e.printStackTrace();
        }
        return blogDto;
    } // end FIND

    // UPDATE
    @Override
    public void update(BlogDto blogDto) {
        try (Connection connection = getInterfaceConnection()) {
            // Transaction: ya hep ya hiç kuralına göre çalışır
            // Create, Delete, Update
            connection.setAutoCommit(false);
            // update one_page.blog set header="Hamit55",content="Mızrak55" where id =1;
            String sql = "update one_page.blog set header=? ,content=? where id =?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, blogDto.getHeader());
            pstm.setString(2, blogDto.getContent());
            pstm.setLong(3, blogDto.getId());
            // UPDATE YAPISILSIN
            // executeUpdate: CREATE, DELETE, UPDATE
            // executeQuery : SELECT
            Integer rowsEffected = pstm.executeUpdate();
            // Eğer Sıfırdan büyükse : Eklemiş -1=ise Eklenmemiş
            if (rowsEffected > 0) {
                System.out.println(BlogDto.class + " ID: "+blogDto.getId()+" SİLİNDİ");
                connection.commit();
            } else {
                System.out.println(BlogDto.class + " HATA Güncellenemedi !!!!");
                connection.rollback();
            }
        } catch (SQLException sql) { // AritmeticException | ClassNotFoundException e
            sql.printStackTrace();
            throw new ResourceNotFoundException(" SQL Güncelleme İstisnası " + sql);
        } catch (Exception e) { // AritmeticException | ClassNotFoundException e
            e.printStackTrace();
        }
    } // end UPDATE

    // DELETE
    @Override
    public void delete(BlogDto blogDto) {
        try (Connection connection = getInterfaceConnection()) {
            // Transaction: ya hep ya hiç kuralına göre çalışır
            // Create, Delete, Update
            connection.setAutoCommit(false);
            //Eğer İlgili ID varsa Güncelleme yapsın yoksa yapmasın

            String sql = "delete FROM one_page.blog where id=?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setLong(1, blogDto.getId());
            // DELETE YAPISILSIN
            // executeUpdate: CREATE, DELETE, UPDATE
            // executeQuery : SELECT
            Integer rowsEffected = pstm.executeUpdate();
            // Eğer Sıfırdan büyükse : Eklemiş -1=ise Eklenmemiş
            if (rowsEffected > 0) {
                System.out.println(BlogDto.class + " ID: " + blogDto.getId() + " Silindir");
                connection.commit();
            } else {
                System.out.println(BlogDto.class + " HATA Silinmedi !!!!");
                connection.rollback();
            }
        } catch (SQLException sql) { // AritmeticException | ClassNotFoundException e
            sql.printStackTrace();
            throw new ResourceNotFoundException(" SQL Güncelleme İstisnası " + sql);
        } catch (Exception e) { // AritmeticException | ClassNotFoundException e
            e.printStackTrace();
        }
    }//end DELETE

} //end class
