import java.util.Scanner;
public class NitroxCalculator {

    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args){
        //declare depth and O2 mix variables
        double depth, mix;
        //declare ppO2 and ambient pressure variables which will be calculated
        double pO2, aP;
        //declaring pressure group character
        char group;
        System.out.println("Please enter your max depth in ft and oxygen mix separated by a space");
        //depth and mix are input from the user
        depth = keyboard.nextDouble();
        mix = keyboard.nextDouble();
        //ambient pressure is calculated by dividing the depth by 33 feet and augmenting by 1 for existing
        //atmospheric pressure
        aP = 1 + depth / 33;
        //pO2 is calculated by converting the partial pressure into decimals 21 = .21 and multiplying
        //by the ambient pressure
        pO2 = (mix / 100) * aP;
        //group calculated using CalcPGroup and returned as a char or ?
        group = CalcPGroup(pO2);
        //initializing boolean array that will be used to describe maximal and contingency agreement
        boolean[] maxContCheck = CalcMaxCont(pO2);
        //Using DispResults method to display results
        DispResults(aP,pO2,maxContCheck,group);

    }
    /*
    CalcPGroup has the parameter oPP corresponding to oxygen partial pressure
    it will undertake calculations to return a char, the pressure group
     */
    public static char CalcPGroup(double oPP){
        //partial pressure / 0.1 will yield an integer corresponding to pressure group
        int pGroup = (int)(oPP / 0.1);
        //if statement to make sure the pressure group is valid, returns ? otherwise
        if(pGroup>26) return '?';
        //adding 64 to pGroup will make the integer correspond to capital letters on the ascii table
        return (char)(pGroup + 65);
    }
    /*
    CalcMaxCont will determine whether the partial pressure parameter exceeds the maximal
    and contingency pressures, filling a boolean array with those results
     */
    public static boolean[] CalcMaxCont(double oPP){
        //boolean array to hold values for checked maximal and contingency partial pressures
        boolean[] maxCont = new boolean[2];
        //fills first entry with t/f within maximal pp
        maxCont[0] = oPP <= 1.4;
        //fills second entry with t/f within contingency pp
        maxCont[1] = oPP <= 1.6;
        return maxCont;
    }
    /*
    DispResults takes parameters calculated in the main method and displays them in the console
    in an organized fashion
     */
    public static void DispResults(double ambP, double oPP, boolean[] maxCont, char pGroup){
        System.out.println("Ambient Pressure: " + ambP);
        System.out.println("O2 Partial Pressure: " + oPP);
        System.out.println("Pressure Group: " + pGroup);
        System.out.println("Within Maximal: " + maxCont[0]);
        System.out.println("Within Contingency: " + maxCont[1]);
    }
}
