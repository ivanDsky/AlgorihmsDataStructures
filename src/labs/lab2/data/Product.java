package labs.lab2.data;

import java.util.Locale;

public class Product {
    private String name;
    private String description;
    private String manufacturer;
    private double amount;
    private double priceSingle;

    private Product(){
        //TODO
    }

    public Product(String name,double priceSingle){
        this.name = name;
        this.priceSingle = priceSingle;
        this.description = null;
        this.amount = 1;
        this.manufacturer = null;
    }

    public Product(String name,String manufacturer,double priceSingle){
        this(name, priceSingle);
        this.manufacturer = manufacturer;
    }

    public Product(String name,String description,String manufacturer, double priceSingle){
        this(name,manufacturer,priceSingle);
        this.description = description;
    }

    public Product(String name, String description, String manufacturer, double amount, double priceSingle){
        this(name,description,manufacturer,priceSingle);
        this.amount = amount;
    }

    public boolean isMatchPattern(String pattern){
        return name.matches(pattern);
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
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPriceSingle() {
        return priceSingle;
    }

    public void setPriceSingle(double priceSingle) {
        this.priceSingle = priceSingle;
    }

    public double getPriceAll(){return getPriceSingle() * getAmount();}

    @Override
    public String toString() {
        return String.format(Locale.ROOT,"%s{%s}, made by %s, amount - %.2f, price for one - %.2f",
                getName(),
                getDescription() == null ? "No description" : getDescription(),
                getManufacturer() == null ? "unknown" : getManufacturer(),
                getAmount(),
                getPriceSingle());
    }

    public String fullInfo(String tabs){
        StringBuilder ret = new StringBuilder();
        ret.append(tabs).append(getName()).append('\n');
        ret.append(tabs).append(getDescription() == null ? "No description" : getDescription()).append('\n').append('\n');
        ret.append(tabs).append("Made by ").append(getManufacturer() == null ? "unknown" : getManufacturer()).append('\n');
        ret.append(tabs).append("Amount: ").append(getAmount()).append('\n');
        ret.append(tabs).append("Price for one: ").append(getPriceSingle()).append('\n');
        ret.append(tabs).append("Price for all: ").append(getPriceSingle() * getAmount());
        return ret.toString();
    }

    public void setAllFields(Product nProduct) {
        setName(nProduct.getName());
        setDescription(nProduct.getDescription());
        setManufacturer(nProduct.getManufacturer());
        setAmount(nProduct.getAmount());
        setPriceSingle(nProduct.getPriceSingle());
    }
}
