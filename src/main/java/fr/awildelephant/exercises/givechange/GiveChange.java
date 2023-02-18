package fr.awildelephant.exercises.givechange;

/**
 * Give change in an "optimal" way (minimal number of coins and bills).
 * <p>
 * Only 2€ coins, 5€ bills and 10€ bills are available, the supply is infinite.
 */
public class GiveChange {

    /**
     * @return the optimal way to give change, or null if impossible
     */
    public Change optimalChange(long value) {
        if (value <= 1 || value == 3) {
            return null;
        }

        long coin2 = 0;
        long bill5 = 0;
        long bill10 = 0;

        long zoom = value - 12;

        if (zoom > 1) {
            bill10 = zoom / 10;
            zoom %= 10;

            bill5 = zoom / 5;
            zoom %= 5;

            coin2 = zoom / 2;
            zoom %= 2;
        }

        int rest = (int) zoom + 12;

        switch (rest) {
            case 2, 4, 6, 8 -> coin2 += rest / 2;
            case 5 -> bill5++;
            case 7 -> {
                coin2++;
                bill5++;
            }
            case 9 -> {
                coin2 += 2;
                bill5++;
            }
            case 10 -> bill10++;
            case 11 -> {
                coin2 += 3;
                bill5++;
            }
            case 12 -> {
                coin2++;
                bill10++;
            }
            case 13 -> {
                coin2 += 4;
                bill5++;
            }
        }

        if (coin2 >= 5) {
            bill10 += coin2 / 5;
            coin2 %= 5;
        }

        if (bill5 >= 2) {
            bill10 += bill5 / 2;
            bill5 %= 2;
        }

        return new Change(coin2, bill5, bill10);
    }
}
