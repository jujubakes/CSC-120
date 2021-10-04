import java.util.Scanner;

public class I95SpeedCalculator {

    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args){

        showCalculations(computeTravelSpeed(welcomeAndInputs()));
    }

    /*
    welcomeAndInputs() will welcome the user, ask them for the travel distance and
    travel time, then store these values in a double array so they may be used in
    other methods
     */
    public static double[] welcomeAndInputs(){
        double[] ret = new double[2];
        System.out.println("Welcome to the I95 Speed Machine\nYou will have to supply:");
        System.out.print("The number of miles you would like to travel: ");
        ret[0] = keyboard.nextDouble();
        System.out.print("\nThe number of hours you available for travel: ");
        ret[1] = keyboard.nextDouble();
        System.out.println("\nCalculating your required speed...");
        return ret;
    }

    public static double computeTravelSpeed(double[] distAndTime){
        double dist = distAndTime[0];
        double time = distAndTime[1];
        double tTMins = time*60;
        double tTHours;
        double travelSpeed;
        int numStops = (int)(dist/100);
        if(dist%100 != 0) numStops++;
        tTMins-=(5*numStops);
        tTHours = tTMins/60;
        travelSpeed = dist/tTHours;
        return travelSpeed;
    }

    public static void showCalculations(double tS){
        System.out.println("The speed you must travel is "+tS+" MPH");
        System.out.println("Over the speed limit: "+ (tS>65));
    }

}
