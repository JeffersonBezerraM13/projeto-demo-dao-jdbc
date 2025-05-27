package model.dao;

import model.entities.Seller;

import java.util.List;

public interface SellerDao {

    void insert(Seller seller);
    void update(Seller seller);
    void delete(Integer id);
    Seller findSellerById(Integer id);
    List<Seller> findAll();
}
