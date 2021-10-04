//=============================================================================
import java.util.Scanner;
public class GasLaw {
    //-----------------------------------------------------------------------------
    private static final Scanner keyboard = new Scanner(System.in);
    //----The gas constant in Joules/mole/K
    private static final double GasConstant = 8.3143;


    //-----------------------------------------------------------------------------
    public static void main(String[] args) {

//----Variables to hold system values
        double volume,moles,temp;
        double pressure;

//----Using scanner to assign values to the variables
        System.out.print("Enter volume, moles, temperature : ");
        volume = keyboard.nextDouble();
        moles = keyboard.nextDouble();
        temp = keyboard.nextDouble();

//----calculating pressure using newly assigned variables
        pressure = moles * GasConstant * temp / volume;

//----Presenting the calculated value to the user
        System.out.println("Pressure is " + pressure);
    }
}
//-----------------------------------------------------------------------------
//=============================================================================