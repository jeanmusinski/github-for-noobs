import java.util.Random;

public class Individual {

    int fitness = 0;
    int[] genes = {};
    int geneLength = 0;

    public Individual(int geneLength) {
        this.geneLength = geneLength;
        genes = new int[geneLength];

        Random rn = new Random();

        // Set genes randomly for each individual
        // rn.nextInt(3) % 2 allows fot twice as many 0's aas 1's initially.
        for (int i = 0; i < geneLength; i++) {
            genes[i] = rn.nextInt(3) % 2;
        }

        fitness = 0;
    }

    // Calculate fitness
    public void calcFitness() {

        fitness = 0;
        for (int i = 0; i < geneLength; i++) {
            if (genes[i] == 1) {
                ++fitness;
            }
        }
    }
}
