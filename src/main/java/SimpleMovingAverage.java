import java.util.ArrayList;

public class SimpleMovingAverage {

    private double currentValue;
    private int periods;
    private ArrayList<Double> valuesList;

    public static void main(String[] args) {
        Double[] doubles = {1.0,1.0,1.0,1.0,1.0,1.0};
        SimpleMovingAverage simpleMovingAverage = new SimpleMovingAverage(5);
        for (int i = 1; i < 10; i++) {
            simpleMovingAverage.add(1.1);
            System.out.println("Moving average: " + simpleMovingAverage.getCurrentValue());
        }
    }

    public SimpleMovingAverage(int timePeriod) {
        this.periods = timePeriod;
        valuesList = new ArrayList<Double>();
    }

    public SimpleMovingAverage(int periods, ArrayList<Double> valuesList) {
        this.periods = periods;
        this.valuesList = valuesList;
    }

    public double calculateSMA(){
        double avg = 0;
        for (double val: valuesList) {
            avg += val;
        }

        if(valuesList.size() >= periods)
            avg /= periods;
        else
            avg /= valuesList.size();

        this.currentValue = avg;
        return avg;
    }

    public double add(double newVal){
        if(valuesList.size() < periods){
            valuesList.add(newVal);
        } else {
            valuesList.remove(0);
            valuesList.add(newVal);
        }

        return calculateSMA();
    }



    public double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }

    public int getTimePeriod() {
        return periods;
    }

    public void setTimePeriod(int timePeriod) {
        this.periods = timePeriod;
    }
}
