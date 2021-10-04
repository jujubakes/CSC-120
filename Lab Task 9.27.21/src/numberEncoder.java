import java.util.Scanner;
import java.lang.Math;

public class numberEncoder {

    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args){
        encodeFull();
    }

    public static String encode(String userNum, char[]encrKey){
        String encoded = "";
        int[] digits = digitArray(userNum);
        for(int i = 0; i < digits.length; i++){
            encoded += encrKey[digits[i]];
        }
        return encoded;
    }

    public static char[] genEncryptionKey(){
        char[] key = new char[10];
        key[0] = '0';
        key [1] = '1';
        boolean repeat;
        char temp;
        int counter = 2;
        while(counter<=9){
            repeat = false;
            temp = (char)((int)(Math.random()*26)+'A');
            for(int i = 2; i < counter ; i++){
                if(key[i] == temp){
                    i = counter;
                    repeat = true;
                }
            }
            if(!repeat){
                key[counter] = temp;
                counter++;
            }
        }
        return key;
    }

    public static int[] digitArray (String userNum){
        int loopNum = Integer.parseInt(userNum);

        // removed check System.out.println(loopNum);

        int activeDigit = 0;
        int numLength = userNum.length();
        int[] ret = new int[numLength];
        for (int i = numLength-1; i >= 0; i--){
            activeDigit = loopNum % 10;
            ret[i] = activeDigit;
            loopNum/=10;
        }

        // removed check printIntArray(ret);

        return ret;
    }

    public static void encodeFull(){
        String daNum;
        do {
            System.out.println("Please input your 305 number: ");
            daNum = keyboard.next();
        } while(daNum.length()<7);
        char[] daKey = genEncryptionKey();

        // removed check printCharArray(daKey);

        System.out.println("Your number, 305"+daNum+" can be encoded as: " + encode("305", daKey) + encode(daNum, daKey));
        System.out.println("The number was encoded using the following translation (0-9):");
        printCharArray(daKey);
    }

    public static void printCharArray(char[] printed){
        for(char c: printed){
            System.out.print(c+" ");
        }
    }

    public static void printIntArray(int[] printed){
        for(int i: printed){
            System.out.print(i+" ");
        }
    }
}
