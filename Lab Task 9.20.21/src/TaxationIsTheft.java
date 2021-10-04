import java.util.Scanner;

public class TaxationIsTheft {
private static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args){
        taxProgram();
    }

    public static double[] incomeAndDeductions(){
        double[] incDed = new double[2];
        double income = 0;
        double deductions = 0;
        double imp = 1;
        while(imp != 0){
            System.out.print("Enter next amount: ");
            imp = keyboard.nextDouble();
            if(imp < 0) deductions -= imp;
            else income += imp;
        }
        System.out.println();
        incDed[0] = income;
        incDed[1] = deductions;
        return incDed;
    }

    public static double taxableIncome(double[] finances){
        if(finances[0]>finances[1]) return (finances[0]-finances[1]);
        else return 0;
    }

    public static char taxGroup(double taxedInc){
        if(taxedInc >= 500000) return 'S';
        else if(taxedInc >= 200000) return 'Q';
        else if(taxedInc >= 100000) return 'M';
        else if(taxedInc >= 50000) return 'A';
        else if(taxedInc >= 20000) return 'R';
        else return 'P';
    }

    public static double computeTax(double taxedInc, char group){
        double taxRate;
        if(group == 'S' || group == 'Q') taxRate = .25;
        else if(group == 'M') taxRate = .1;
        else if (group == 'A' || group == 'R') taxRate = .03;
        else if (group == 'P') taxRate = 0;
        else{
            System.out.println("Error: invalid tax group");
            return 0;
        }
        return taxedInc*taxRate;
    }

    public static void displayTaxInfo(double[] finances, char group, double tax, double taxedIncome){
        System.out.println("Income: $" + finances[0]);
        System.out.println("Deductions: $" + finances[1]);
        System.out.println("Taxable Income: $" + taxedIncome);
        System.out.println("Tax Group: " + group);
        System.out.println("Tax Owed: $" + tax);
    }

    public static void taxProgram(){
        double[] finances = incomeAndDeductions();
        double taxedIncome = taxableIncome(finances);
        char group = taxGroup(taxedIncome);
        double tax = computeTax(taxedIncome, group);
        displayTaxInfo(finances,group,tax,taxedIncome);
    }
}
