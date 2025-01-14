package q3;

import java.util.Comparator;

public class Maxi implements Comparator<Double> {

    @Override
    public int compare(Double o1, Double o2) {
        return Double.compare(o2,o1);
    }
}
