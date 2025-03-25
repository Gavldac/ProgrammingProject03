import java.security.interfaces.EdECKey;
import java.util.Map;
import java.util.TreeMap;

/**
 * class for manupulating and comparing nodes that
 * each represent an experiment.
 * Each experiment has a name, weight and rating.
 * Limits to this program are that the total weight of
 * experiments cannot exceed 700kg.
 *
 * Various ways are implemented to determine which group of experiments
 * are selected based on weight and rating.
 *
 * @author Edwin Casady
 */
public class Knapsack {
    /**
     * class for handling the data involved for comparing experiments
     * that each have a name, weight, and rating
     *
     * @author Edwin Casady
     */
    public static class Experiment
    {
        int rating;
        int weight;
        String name;

        /**
         * Nodes are for storing and evaulating the given list of
         * experiments for the assignment Programming Assignment 3
         * for CS2430
         * @param name
         * @param weight
         * @param rating
         */
        public Experiment(String name, int weight, int rating) {
            this.name = name;
            this.rating = rating;
            this.weight = weight;
        }

        public int getRating() {
            return rating;
        }

        public int getWeight(){
            return weight;
        }

        public String getName() {
            return name;
        }

        /**
         * getValue returns a fuzzy value based on the nodes rating
         * divided by the weight.
         * @return double rating / weight
         */
        public double getValue(){
            return (rating * 1.0) / weight;
        }

        @Override
        public String toString() {
            return name + " (Weight: " + weight + ", Rating: " + rating + ")";
        }

    }

    public static void main(String[] args) {
        TreeMap<Integer, Experiment> weights = new TreeMap<>();

        weights.put(36, new Experiment("Patterns", 36, 5));
        weights.put(264, new Experiment("Solar Flares", 264, 9));
        weights.put(188, new Experiment("Solar Power", 188, 6));
        weights.put(203, new Experiment("Binary Stars", 203, 8));
        weights.put(104, new Experiment("Relativity", 104, 8));
        weights.put(7, new Experiment("Seed Viability", 7, 4));
        weights.put(90, new Experiment("Sun Spots", 90, 2));
        weights.put(65, new Experiment("Mice Tumors", 65, 8));
        weights.put(75, new Experiment("Microgravity Plant Growth", 75, 5));
        weights.put(170, new Experiment("Micrometeorites", 170, 9));
        weights.put(80, new Experiment("Cosmic Rays", 80, 7));
        weights.put(27, new Experiment("Yeast Fermentation", 27, 4));

        /*
    tree visualization:
          90
       /      \
     36         188
    /  \       /    \
   7   65     104    203
      /  \    / \     \
    27   75  80 170    264

         */

    selectHeaviest(weights, 700);

    }

    public static void selectHeaviest(TreeMap<Integer,Experiment> weights, int maxWeight){
        int currentTotal = 0;
        System.out.println("Selected: ");

        // TreeMap has a descending function
        for (Map.Entry<Integer, Experiment> experiment : weights.descendingMap().entrySet()){
            if (experiment.getKey() + currentTotal <= maxWeight){
                currentTotal += experiment.getKey();
                System.out.println(experiment);
            }
        }
        System.out.println("total weight: " + currentTotal);
    }
}
