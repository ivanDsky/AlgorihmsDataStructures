package labs.lab2;

import labs.lab2.data.Database;
import labs.lab2.data.Group;
import labs.lab2.data.Product;

import java.util.regex.Pattern;

public class Tester {
    public static void main(String[] args) {
        Database db = new Database();
        db.addGroup(new Group("test"));

        Group prod = new Group("prod");
        prod.addProduct(new Product("Flour",15.0));
        prod.addProduct(new Product("Oil",15.0));
        prod.addProduct(new Product("Rice",150.0));

        Group unprod = new Group("unprod");
        unprod.addProduct(new Product("Soap",20.0));
        unprod.addProduct(new Product("Napkin","Napkins for kitchen","Kyiv-Napkins",20,3));

        db.addGroup(prod);
        db.addGroup(unprod);
//        db.getGroups().get(2).removeProduct(prod.getProducts().get(1));
        Pattern p = Pattern.compile(".*l.\\*");
        Database patternDB = db.databaseMatchPattern(".*l.*").databaseMatchPattern(".*r");

        db.saveToFile("src/labs/lab2/files");
        System.out.println(patternDB.getGroups());
    }
}
