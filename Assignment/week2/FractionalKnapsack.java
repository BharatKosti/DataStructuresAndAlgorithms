package week2;
import java.util.*;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity,double value,List<ValueWeight> valuePerWeightSorted) {
        //double value = 0;
        if(capacity==0){
            return value;
        }
        if(valuePerWeightSorted.isEmpty()){
            return value;
        }
        ValueWeight head = valuePerWeightSorted.get(0);
        List<ValueWeight> tail = valuePerWeightSorted.subList(1,valuePerWeightSorted.size());
        if(head.getWeight()<=capacity){
            Double totalValue = Double.valueOf(head.getWeight()) * head.getValuePerWeight();
            return getOptimalValue(capacity - head.getWeight(),value+totalValue,tail);
        }
        else {
            Double totalValue = capacity * head.getValuePerWeight();
            return getOptimalValue(0,value+totalValue,tail);
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        List<ValueWeight> valueWeights = new ArrayList<>(n);
        //List<Double> valuesPerUnitWeight = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
            valueWeights.add(new ValueWeight(values[i],weights[i]));
            //valuesPerUnitWeight.add(Double.valueOf(values[i])/Double.valueOf(weights[i]));
        }
        valueWeights.sort((o1,o2) -> -1* Double.compare(o1.getValuePerWeight(),o2.getValuePerWeight()));
        System.out.println(getOptimalValue(capacity,Double.valueOf(0), valueWeights));

    }

    static class ValueWeight{
        private final int value;
        private final int weight;

        public ValueWeight(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }

        public Double getValuePerWeight(){
            return Double.valueOf(value)/Double.valueOf(weight);
        }

        public int getValue() {
            return value;
        }

        public int getWeight() {
            return weight;
        }
    }

} 
