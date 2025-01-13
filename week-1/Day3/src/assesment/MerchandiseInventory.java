package assesment;

public class MerchandiseInventory implements Comparable<MerchandiseInventory>{
    private String itemCode;
    private int quantity;
    private double unitPrice;

    public MerchandiseInventory(String itemCode, int quantity, double unitPrice){
        this.itemCode = itemCode;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getItemCode() {
        return itemCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
    @Override
    public int compareTo(MerchandiseInventory o){
        return this.itemCode.compareTo(o.itemCode);//to print in ascending
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ItemCode: ").append(itemCode)
                .append(", Quantity: ").append(quantity)
                .append(", UnitPrice: ").append(String.format("%.2f", unitPrice));
        return sb.toString();
    }


}
