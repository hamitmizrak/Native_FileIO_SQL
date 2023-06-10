package dao;

import database.DatabaseConnection;

import java.sql.Connection;
import java.util.ArrayList;

public interface IDaoGenerics<T> {
    // CRUD

    // CREATE
    public void create(T t);

    // LIST
    public ArrayList<T> list();

    // FIND
    public T findById(Long id);

    // UPDATE
    public void update(T t);

    // DELETE
    public void delete(T t);

    // Govdeli Interface
    default Connection getInterfaceConnection() {
        return DatabaseConnection.getInstance().getConnection();
    }
}
