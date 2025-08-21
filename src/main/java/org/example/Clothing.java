package org.example;

public class Clothing extends Product{
    private String size;

    public Clothing(){
        super();
    }

    public Clothing(int id, String name, float price, String size) {
        super(id, name, price);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Size: %-5s", size);
    }

}
