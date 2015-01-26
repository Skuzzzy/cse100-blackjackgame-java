package com.company;
import java.util.Random;

/**
 * Created by dan on 1/25/15.
 */
public class Computer extends Player
{

    public Computer(int startingChips)
    {
        this.chips = startingChips;
        this.currentBet = -1;
        this.playerHand = new Hand();
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

}