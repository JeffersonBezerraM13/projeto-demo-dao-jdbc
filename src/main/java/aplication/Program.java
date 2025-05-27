package aplication;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.dao.impl.SellerDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println("=== TEST 1: seller findById ===");
        Seller seller = sellerDao.findSellerById(3);
        System.out.println(seller);

        System.out.println("\n=== TEST 2: seller findByDepartment ===");
        Department department = new Department(2,null);
        List<Seller> list = sellerDao.findByDepartment(department);
        list.forEach(System.out::println);

        System.out.println("\n=== TEST 3: seller findAll ===");
        list = sellerDao.findAll();
        list.forEach(System.out::println);

        System.out.println("\n=== TEST 4: seller insert ===");
        Seller seller2 = new Seller(null,"Ana", "ana@gmail.com",new Date(), 2000.00,department);
        sellerDao.insert(seller2);
        System.out.println("Inserted! New Id = " + seller2.getId());

        System.out.println("\n=== TEST 5: seller update ===");
        Seller seller3 = sellerDao.findSellerById(1);
        seller3.setName("Cristian");
        sellerDao.update(seller3);
        System.out.println("Update completed!");

        System.out.println("\n=== TEST 6: seller delete ===");
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        sc.nextLine();
        sellerDao.delete(id);
        System.out.println("Delete comleted");
        sc.close();
    }
}
