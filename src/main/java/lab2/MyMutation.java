package lab2;

import org.uncommons.watchmaker.framework.EvolutionaryOperator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static lab2.MyAlg.GENERATIONS;

public class MyMutation implements EvolutionaryOperator<double[]> {
    private int generation;

    public static double generateDouble(Random random) {
        return -5.0 + 10.0 * random.nextDouble();
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public double getMutationRate() {
        return (double) generation / GENERATIONS;
    }

    public List<double[]> apply(List<double[]> population, Random random) {
        double mutationRate = getMutationRate();
        double explorationThreshold = 1 - mutationRate * mutationRate;
        List<double[]> mutatedPopulation = new ArrayList<>();

        for (double[] individual : population) {
            double[] mutated = individual.clone();

            double mutationCoefficient = random.nextDouble();
            boolean uniform = mutationCoefficient <= explorationThreshold;

            for (int i = 0; i < mutated.length; i++) {
                double mutateThreshold = random.nextDouble();
                double mutateAmount = (uniform ? 0.07 : 0.3) * (1. / mutated.length);

                if (mutateThreshold <= mutateAmount) {
                    mutated[i] = uniform
                            ? generateDouble(random)
                            : mutated[i] + random.nextGaussian() * 0.5;
                }
            }

            mutatedPopulation.add(mutated);
        }

        return mutatedPopulation;
    }
}
