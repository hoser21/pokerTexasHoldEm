package com.example.bellosil21.pokertexasholdem.Poker.Money;

import java.io.Serializable;

/**
 * Stores an amount of chips with player data.
 *
 * @author Patrick Bellosillo
 * @author Jordan Ho
 * @author Kevin Hoser
 * @author Gabe Marcial
 */
public class PlayerChipCollection extends ChipCollection implements Serializable {

    private int lastBet; // keep track of most recent bet in case of a raise
    private int lastContributedPot; // index of the last pot this player
                                    // contributed to

    private static final int DEFAULT_LAST_CONTRIBUTED_POT = -1;

    /**
     * Assigns player data to a ChipCollection.
     *
     * @param amount The amount of starting chips in the collection
     */
    public PlayerChipCollection(int amount) {
        super(amount);
        lastBet = 0;
        lastContributedPot = DEFAULT_LAST_CONTRIBUTED_POT;
    }

    /**
     * Copy constructor
     */
    public PlayerChipCollection(PlayerChipCollection toCopy) {
        super(toCopy.amount);
        lastBet = toCopy.lastBet;
        lastContributedPot = toCopy.lastContributedPot;
    }


    public void setLastBet(int lastBet) {
        this.lastBet = lastBet;
    }

    public int getLastBet() {
        return lastBet;
    }

    /**
     * Increments and returns the player's lastContributedPot
     *
     * @return the new index of the player's lastContributedPOt
     */
    public int incrementLastContributedPot() {
        lastContributedPot++;
        return lastContributedPot;
    }

    public int getLastContributedPot() { return lastContributedPot; }

    public void resetLastContributedPot() {
        lastContributedPot = DEFAULT_LAST_CONTRIBUTED_POT;
    }

    /**
     * Prints the status of the collection.
     *
     * @return the string describing status of player action
     */
    @Override
    public String toString() {
        return super.toString() + ", lastBet " + lastBet + ", lastPot "
                + lastContributedPot;
    }
}
