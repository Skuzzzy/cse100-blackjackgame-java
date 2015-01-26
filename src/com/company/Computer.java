package com.company;
import java.util.Random;

/**
 * Created by dan on 1/25/15.
 */
public class Computer implements Player
{
    private int chips;
    private Hand playerHand;

    int currentBet;

    public Computer(int startingChips)
    {
        this.chips = startingChips;
        playerHand = new Hand();
    }

    public boolean requestCard()
    {
        if(playerHand.handValue() < 21-10)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void requestBet()
    {
        Random rand = new Random();
        currentBet = rand.nextInt(10) + 1; // Bet some random chip amount 1-10
    }
    public int getCurrentBet()
    {
        return currentBet;
    }


    public int getChips()
    {
        return chips;
    }
    public void addChips(int chipsToAdd) {
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