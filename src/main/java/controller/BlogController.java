package controller;

import dao.BlogDao;
import dto.BlogDto;
import exception.BadRequestException;

import javax.swing.*;
import java.rmi.server.UID;
import java.util.Scanner;
import java.util.UUID;

public class BlogController implements IBlogController {

    private BlogDao blogDao;

    // CONSTRUCTOR
    public BlogController() {
        blogDao = new BlogDao();
    }

    // CREATE
    @Override
    public void blogCreate(BlogDto blogDto) {
        blogDao.create(blogDto);
    }

    // LIST
    @Override
    public void blogList() {
        blogDao.list().forEach((temp) -> {
            System.out.println(temp);
        });
    }

    // FIND
    @Override
    public void blogFind(Long id) {
       BlogDto find= blogDao.findById(id);
        System.out.println("\n "+find);
    }


    // UPDATE
    @Override
    public void blogUpdate(BlogDto blogDto) {
        BlogDto findById = blogDao.findById(blogDto.getId());
        if (findById != null) {
            blogDao.update(blogDto);
        } else
            throw new BadRequestException(blogDto.getId() + " id bulunamadı");
    }

    // DELETE
    @Override
    public void blogDelete(BlogDto blogDto) {
        BlogDto findById = blogDao.findById(blogDto.getId());
        if (findById != null) {
            blogDao.delete(blogDto);
        } else
            throw new BadRequestException(blogDto.getId() + " id bulunamadı");
    }

    // ###########################################################################

    // Kullanıcı Veri Almak
    public int userData() {
        Scanner klavye = new Scanner(System.in);
        System.out.println("\nLütfen Seçim yapınız\n1-) Blog Listele\n2-) Blog Bul"
                + "\n3-) Blog Ekle\n4-) Blog Güncelle\n5-) Blog sil\n6-) Çoklu Veri Ekle\n7-) ÇIKIŞ YAP");
        int chooise = klavye.nextInt();
        return chooise;
    }

    // LOGOUT
    public void logout() {
        System.err.println("Sistemden çıkış yapıyorsunuz");
        System.exit(0);
    }

    public void chooiseMethod() {
        // Kullanıcıdan veri almak
        int key = userData();
        switch (key) {
            case 1:
                blogList();
                break;
            case 2:
                blogList();
                String str = JOptionPane.showInputDialog("Bulmak isterdiğiniz ID giriniz");
                Long stringToInteger = Long.valueOf(str);
             blogFind(stringToInteger);
                break;
            case 3:
                String header, content;
                header = JOptionPane.showInputDialog("Blog için header giriniz");
                content = JOptionPane.showInputDialog("Blog için content");
                // Blog Dto Instance
                BlogDto blogDto = new BlogDto();
                blogDto.setHeader(header);
                blogDto.setContent(content);
                blogCreate(blogDto);
                break;
            case 4:
                blogList();
                // Blog Dto Instance
                BlogDto blogDto2 = new BlogDto();
                String strUpdate = JOptionPane.showInputDialog("Bulmak isterdiğiniz ID giriniz");
                Long stringToInteger2 = Long.valueOf(strUpdate);
                blogDto2.setId(stringToInteger2);
                String header2, content2;
                header2 = JOptionPane.showInputDialog("Blog için header giriniz");
                content2 = JOptionPane.showInputDialog("Blog için content");
                blogDto2.setHeader(header2);
                blogDto2.setContent(content2);
                blogUpdate(blogDto2);
                break;
            case 5:
                blogList();
                BlogDto blogDto3 = new BlogDto();
                String strDelete = JOptionPane.showInputDialog("Bulmak isterdiğiniz ID giriniz");
                Long stringToInteger3 = Long.valueOf(strDelete);
                blogDto3.setId(stringToInteger3);
                blogDelete(blogDto3);
                break;
            case 6:
                for (int i = 1; i <=5 ; i++) {
                    BlogDto blogDtoSpeed=new BlogDto();
                    blogDtoSpeed.setHeader("header "+i);
                    blogDtoSpeed.setContent(UUID.randomUUID().toString());
                    blogCreate(blogDtoSpeed);
                }
                break;
            case 7:
                logout();
                break;
            default:
                System.out.println("Lütfen belirtilen seçimi yapınız");
                break;
        }
    }
}
