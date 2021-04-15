package labs.lab2.data;

import java.util.ArrayList;

public class Group {
    private ArrayList<Product> products;
    private String name;
    private String description;

    private Group(){}

    public Group(String name){
        products = new ArrayList<>();
        this.name = name;
        this.description = null;
    }

    public Group(String name,String description){
        this(name);
        this.description = description;
    }

    public void addProduct(Product product){
        //TODO check is product a duplication
        products.add(product);
    }

    public void removeProduct(Product product){
        //TODO check is product exists
        products.remove(product);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void removeAllProducts(){
        //TODO unlink all products
        products = new ArrayList<>();
    }

    public String getAllProducts(){
        StringBuilder builder = new StringBuilder("Products of ").append(getName()).append('\n');
        for(Product pr : products){
            builder.append('\t').append(pr).append('\n');
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if(description == null || description.isBlank())description = null;
        this.description = description;
    }

    public Group groupMatchPattern(String pattern){
        Group ret = new Group(getName(),getDescription());
        for(Product pr : products){
            if(pr.isMatchPattern(pattern))ret.addProduct(pr);
        }
        if(ret.products.size() == 0)return null;
        return ret;
    }

    public boolean isProductUnique(String name){
        for(Product pr : products){
            if(name.equals(pr.getName()))return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder("");
        ret.append(getName()).append('{').append(getDescription()).append('}').append('\n');
        for(Product p : products){
            ret.append('\t').append(p).append('\n');
        }
        return ret.toString();
    }

    public double getSumPrice() {
        double sum = 0;
        for(Product pr : products){
            sum += pr.getPriceSingle() * pr.getAmount();
        }
        return sum;
    }
}
