package com.company;
import java.util.Scanner;

/**
 * Created by dan on 1/25/15.
 */
public class Human implements Player
{
    private Scanner input;
    private int chips;
    private Hand playerHand;
    int currentBet;

    public Human(int startingChips)
    {
        this.chips = startingChips;
        playerHand = new Hand();
        input = new Scanner(System.in);
    }

    public boolean requestCard()
    {
        System.out.print("Would you like another card? (y/n): ");
        String choice = input.nextLine();
        if(choice.equals("y") || choice.equals("yes"))
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
        System.out.print("How much would you like to bet on this hand?: ");
        String choice = input.nextLine();
        currentBet = Integer.parseInt(choice);
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
