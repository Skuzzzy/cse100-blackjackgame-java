package com.company;

/**
 * Created by dan on 1/25/15.
 */
public interface Player
{
    public boolean requestCard();
    public void requestBet();
    public int getCurrentBet();

    public void addChips(int chipsToAdd);
    public int getChips();


    public void addCardToHand(Card cta);
    public void clearHand();
    public String getHandString();
    public int getHandValue();

}
