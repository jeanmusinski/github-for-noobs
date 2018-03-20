public class Population {
    Individual[] individuals = {};

    int populationSize = 0;
    int geneLength = 0;

    int fittest = 0;

    //Initialize population
    public void initializePopulation(int populationSize, int geneLength) {
        this.populationSize = populationSize;
        this.geneLength = geneLength;

        individuals = new Individual[populationSize];
        for (int i = 0; i < populationSize; i++) {
            individuals[i] = new Individual(geneLength);
        }
    }

    // Get the fittest individual
    public Individual getFittest() {
        int maxFit = 0;
        for (int i = 0; i < populationSize; i++) {
            if (individuals[maxFit].fitness <= individuals[i].fitness) {
                maxFit = i;
            }
        }
        fittest = individuals[maxFit].fitness;
        return individuals[maxFit];
    }

    // Get the second most fittest individual
    public Individual getSecondFittest() {
        int maxFit1 = 0;
        int maxFit2 = 0;
        for (int i = 0; i < populationSize; i++) {
            if (individuals[i].fitness > individuals[maxFit1].fitness) {
                maxFit2 = maxFit1;
                maxFit1 = i;
            } else if (individuals[i].fitness > individuals[maxFit2].fitness) {
                maxFit2 = i;
            }
        }
        return individuals[maxFit2];
    }

    // Get index of least fittest individual
    public int getLeastFittestIndex() {
        int minFit = 0;
        for (int i = 0; i < populationSize; i++) {
            if (minFit >= individuals[i].fitness) {
                minFit = i;
            }
        }
        return minFit;
    }

    // Calculate fitness of each individual
    public void calculateFitness() {

        for (int i = 0; i < populationSize; i++) {
            individuals[i].calcFitness();
        }
        getFittest();
    }
}
