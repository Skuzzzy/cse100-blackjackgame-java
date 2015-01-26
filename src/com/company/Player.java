package com.company;

/**
 * Created by dan on 1/25/15.
 */
public abstract class Player
{
    protected int chips;
    protected Hand playerHand;
    protected int currentBet;

    abstract boolean requestCard();
    abstract void requestBet();

    public int getCurrentBet()
    {
        return currentBet;
    }

    public int getChips()
    {
        return chips;
    }
    public void addChips(int chipsToAdd)
    {
        chips+=chipsToAdd;
    }
    public void addCardToHand(Card cta)
    {
        playerHand.addCard(cta);
    }
    public void clearHand()
    {
        playerHand.clearHand();
    }
    public String getHandString()
    {
        return playerHand.toString();
    }
    public int getHandValue()
    {
        return playerHand.handValue();
    }

}
