package controller;

import dao.BlogDao;
import dto.BlogDto;
import javax.swing.*;
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
        JOptionPane.showMessageDialog(null, blogDto, "EKLENDI", JOptionPane.INFORMATION_MESSAGE);
    }

    // LIST
    @Override
    public void blogList() {
        blogDao.list().forEach((temp) -> {
            System.out.println(temp);
        });
        JOptionPane.showMessageDialog(null, null, "LISTELENDI", JOptionPane.INFORMATION_MESSAGE);
    }

    // FIND
    @Override
    public void blogFind(Long id) {
        BlogDto findById = blogDao.findById(id);
        if (findById.getId() != null) {
            System.out.println("\n" + findById);
            JOptionPane.showMessageDialog(null, findById, "BULUNDU", JOptionPane.INFORMATION_MESSAGE);
        } else {
            System.err.println(id + " nolu bulunamadı");
            JOptionPane.showMessageDialog(null, findById, "BULUNAMADI", JOptionPane.ERROR_MESSAGE);
        }
    }


    // UPDATE
    @Override
    public void blogUpdate(BlogDto blogDto) {
        blogDao.update(blogDto);
        JOptionPane.showMessageDialog(null, blogDto, "GÜNCELLENDİ", JOptionPane.INFORMATION_MESSAGE);
    }

    // DELETE
    @Override
    public void blogDelete(BlogDto blogDto) {
        // Silmek istediğinizden Emin misiniz ?
        blogDao.delete(blogDto);
        JOptionPane.showMessageDialog(null, blogDto, "SİLİNDİ", JOptionPane.INFORMATION_MESSAGE);
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
                String strUpdate = JOptionPane.showInputDialog("Güncellemek isterdiğiniz ID giriniz");
                Long stringToInteger2 = Long.valueOf(strUpdate);
                blogDto2.setId(stringToInteger2);

                BlogDto findById = blogDao.findById(blogDto2.getId());
                if (findById.getId() != null) {
                    String header2, content2;
                    header2 = JOptionPane.showInputDialog("Güncellenecek Blog için header giriniz");
                    content2 = JOptionPane.showInputDialog("Güncellencek Blog için content");
                    blogDto2.setHeader(header2);
                    blogDto2.setContent(content2);
                    blogUpdate(blogDto2);
                } else {
                    System.err.println(findById.getId() + " nolu bulunamadı");
                    JOptionPane.showMessageDialog(null, "Güncellemedi!", findById.getId() + " nolu bulunamadı", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case 5:
                blogList();
                BlogDto blogDto3 = new BlogDto();
                String strDelete = JOptionPane.showInputDialog("Silmek isterdiğiniz ID giriniz");
                Long stringToInteger3 = Long.valueOf(strDelete);
                blogDto3.setId(stringToInteger3);

                BlogDto findById3 = blogDao.findById(blogDto3.getId());
                if (findById3.getId() != null) {
                    int result = JOptionPane.showConfirmDialog(null, "Silmek istediğinizde emin misiniz ?");
                    // EVET:0  HAYIR:1 ÇIKIŞ: 2
                    if(result==0){
                        blogDelete(blogDto3);
                    }else if(result==1){
                        System.out.println("Silinmedi ");
                        JOptionPane.showMessageDialog(null, "Silinmedi!", "HAYIR TUŞUNA BASTINIZ", JOptionPane.ERROR_MESSAGE);
                    }else if(result==2){
                        JOptionPane.showMessageDialog(null, "Direk Çıkıldı!", blogDto3.getId() + " nolu bulunamadı", JOptionPane.ERROR_MESSAGE);
                    }else{
                        System.out.println("Belirtilenin dışına çıkıldı");
                        JOptionPane.showMessageDialog(null, "Çıkış oldu!", "Belirtilenin dışına çıkıldı", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    //throw new BadRequestException(blogDto.getId() + " id bulunamadı");
                    System.err.println("Aradığınız " + blogDto3.getId() + " ID YOKTUR");
                    JOptionPane.showMessageDialog(null, "ID YOKTUR!", blogDto3.getId() + " nolu bulunamadı", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case 6:
                for (int i = 1; i <= 5; i++) {
                    BlogDto blogDtoSpeed = new BlogDto();
                    blogDtoSpeed.setHeader("header " + i);
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
