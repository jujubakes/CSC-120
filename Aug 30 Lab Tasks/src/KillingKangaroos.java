import java.util.Scanner;
public class KillingKangaroos {
    private static final Scanner scan = new Scanner(System.in);
    //Given Kangaroo Constant
    private static final double rooConstant = 1.47;
    public static void main(String[] args) {
        KillCalculator();
    }
    /*
    KillCalculator() returns a double of the number of kangaroos killed in a given area based off of
    user inputs
     */
    public static double KillCalculator(){
        boolean correct = false; //boolean used with while loop to ensure proper data input
        double sideLength=0;
        double rooDensity;
        double roadLength=0;
        double kills;
        double roadArea;
        double squareArea;
        int numRoos=0;
        while(!correct) {
            System.out.println("Please input the length of one side of the land square");
            sideLength = scan.nextDouble();
            System.out.println("Please input the number of kangaroos in the square");
            numRoos = scan.nextInt();
            System.out.println("Please input the length of roads running through the square");
            roadLength = scan.nextDouble();
            System.out.println("You entered\nLand Square Length (km): "+sideLength+"\nNumber of Kangaroos: "+numRoos
            +"\nRoad Length (km): "+roadLength+"\nIf this is correct please type 'y'");
            correct = scan.next().charAt(0)=='y';
        }
        System.out.println("Your data has been input, please wait for calculation...");
        squareArea = sideLength*sideLength; //area of square = side length squared
        rooDensity = numRoos/squareArea; //kangaroo density = kangaroo population / area of square
        roadArea = 10*roadLength; //road area is calculated using input road length and given 10 meter width
        kills = rooDensity*roadArea*rooConstant; //kills calculated using given equation
        System.out.println("Based off of the provided data, an estimated "+kills+" kangaroos will be killed.");
        return kills;
    }
}
