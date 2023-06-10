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
        ArrayList<BlogDto> blogDtoList=new ArrayList<>();
        BlogDto blogDto;
        try (Connection connection = getInterfaceConnection()) {
            // select * from one_page.blog;
            String sql = "select * from one_page.blog";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet resultSet=pstm.executeQuery();
            while(resultSet.next()){
                blogDto=new BlogDto();
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
    }

    // FIND
    @Override
    public void findById(Long id) {

    }

    // UPDATE
    @Override
    public void update(BlogDto blogDto) {

    }

    // DELETE
    @Override
    public void delete(BlogDto blogDto) {

    }
}
