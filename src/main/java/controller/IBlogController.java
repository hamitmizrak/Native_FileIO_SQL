package controller;

import dto.BlogDto;

public interface IBlogController {

    // CREATE
    public void blogCreate(BlogDto blogDto);

    // LIST
    public void blogList();

    // FIND
    public void blogFind(Long id);

    // UPDATE
    public void blogUpdate(BlogDto blogDto);

    // DELETE
    public void blogDelete(BlogDto blogDto);
}
