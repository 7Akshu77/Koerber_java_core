package assesment;

import java.util.Comparator;

public class OrderByPrice implements Comparator<MerchandiseInventory> {
    @Override
    public int compare(MerchandiseInventory p1, MerchandiseInventory p2) {
        return Double.compare(p2.getUnitPrice(), p1.getUnitPrice());// descending
    }}
