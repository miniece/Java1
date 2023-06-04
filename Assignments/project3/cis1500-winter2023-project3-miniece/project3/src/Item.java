import java.io.*;

public class Item {
    private String itemName;
    private double quantity;
    private double price;

    public Item(String itemName, double quantity, double price) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }

    public Item(String itemName) {
    }

    public Item(double quantity) {
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //confused about this
//    public void writeToFile() throws IOException {
//        PrintWriter printWriter = new PrintWriter(new FileWriter(itemName + ".txt"));
//        for (Item item) {
//            printWriter.println(item.getStringForFile());
//        }
//    }
//    printWriter.close();
}
