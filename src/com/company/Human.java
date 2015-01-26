package com.company;
import java.util.Scanner;

/**
 * Created by dan on 1/25/15.
 */
public class Human extends Player
{
    private Scanner input;

    public Human(int startingChips)
    {
        this.chips = startingChips;
        this.currentBet = -1;
        this.playerHand = new Hand();
    }

    public boolean requestCard()
    {
        input = new Scanner(System.in);
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
        input = new Scanner(System.in);
        System.out.print("How much would you like to bet on this hand?: ");
        String choice = input.nextLine();
        currentBet = Integer.parseInt(choice);
    }
}
