package lab2;

import org.uncommons.watchmaker.framework.operators.AbstractCrossover;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MyCrossover extends AbstractCrossover<double[]> {
    protected MyCrossover() {
        super(1);
    }

    protected List<double[]> mate(double[] p1, double[] p2, int i, Random random) {
        ArrayList<double[]> children = new ArrayList<>();

        double[] child1 = new double[p1.length];
        double[] child2 = new double[p1.length];
        for (int j = 0; j < p1.length; j++) {
            child1[j] = 0.3 * p1[j] + 0.7 * p2[j];
            child2[j] = 0.3 * p2[j] + 0.7 * p1[j];
        }

        children.add(child1);
        children.add(child2);

        return children;
    }
}
