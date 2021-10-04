//=============================================================================
public class WhatsTheOutput {
    //-----------------------------------------------------------------------------
    private static final short MASTS = 4;
    //-----------------------------------------------------------------------------
    public static void main(String[] args) {

        final int somePeopleNeverChange;
        float aBoat,aShip;
        double upInPain = 88.8;
        long devilInDisguise;
        aBoat = (float)14.8;

        devilInDisguise = (long) (upInPain - MASTS / 2 * 11.1);
        aShip = (int)aBoat % MASTS + MASTS / 8 + 2;
        upInPain = upInPain / aShip;
        somePeopleNeverChange = (short)upInPain;
        aBoat *= -MASTS;

        System.out.println(aBoat);
        System.out.println(++devilInDisguise);
        System.out.println(aShip);
        System.out.println(upInPain);
        System.out.println((MASTS + somePeopleNeverChange));
    }
//-----------------------------------------------------------------------------
}
//
//=============================================================================