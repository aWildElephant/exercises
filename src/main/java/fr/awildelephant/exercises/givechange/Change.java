package fr.awildelephant.exercises.givechange;

import java.util.Objects;

public final class Change {

    private final long coin2;
    private final long bill5;
    private final long bill10;

    public Change(long coin2, long bill5, long bill10) {
        this.coin2 = coin2;
        this.bill5 = bill5;
        this.bill10 = bill10;
    }

    public long getCoin2() {
        return coin2;
    }

    public long getBill5() {
        return bill5;
    }

    public long getBill10() {
        return bill10;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coin2, bill5, bill10);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof final Change other)) {
            return false;
        }

        return coin2 == other.coin2 && bill5 == other.bill5 && bill10 == other.bill10;
    }

    @Override
    public String toString() {
        return coin2 + " 2€ coin(s), " + bill5 + " 5€ bill(s) and " + bill10 + " 10€ bill(s)";
    }
}
