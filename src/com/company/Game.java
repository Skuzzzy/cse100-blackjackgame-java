package com.company;

import java.util.Scanner;

/**
 * Created by dan on 1/25/15.
 */
public class Game
{
    private Player[] playerList;
    private Player dealer;
    private Deck blackjackDeck;

    public Game(int numHumanPlayers,int numComputerPlayers,int startingChips)
    {
        // Let a computer be the dealer (Chips don't matter) computer would be pulling from the casino chip pool so we just create the chips in this case
        dealer = new Computer(-1);

        // Initialize player array
        playerList = new Player[numHumanPlayers+numComputerPlayers];
        // First fill the array with the human players
        for(int i=0; i<numHumanPlayers; i++)
        {
            playerList[i] = new Human(startingChips);
        }
        // Then fill the array with the computer players
        for(int i=numHumanPlayers; i<numComputerPlayers+numHumanPlayers; i++)
        {
            playerList[i] = new Computer(startingChips);
        }

        blackjackDeck = new Deck();

        startGame();
    }

    public void startGame()
    {
        boolean continueGame = true;
        while(continueGame) // Main game loop
        {
            // Everyone gets two cards at the start
            dealCards();

            // Get player bets
            getPlayerBets();

            // Get player decision regarding hitting or staying
            getPlayerDecisions();

            // Get dealer decision on hitting or staying
            getDealerDecision();

            // Now see if each player won and distribute earnings
            checkWins();

            // Checking game loop
            continueGame = checkContinue();

            // Clean up for next round
            resetHands();
        }

        System.out.println("Ending Game");
    }

    public void dealCards()
    {
        System.out.println("Dealing cards");
        dealer.addCardToHand(blackjackDeck.takeCard());
        dealer.addCardToHand(blackjackDeck.takeCard());
        for(Player pl : playerList)
        {
            pl.addCardToHand(blackjackDeck.takeCard());
            pl.addCardToHand(blackjackDeck.takeCard());
        }
        System.out.println("Cards have been dealt");
    }

    public void getPlayerBets()
    {
        System.out.println("Place your bets!");
        for(Player pl : playerList)
        {
            System.out.println("\nYour hand: " + pl.getHandString());
            pl.requestBet();
            System.out.println("You bet " + pl.getCurrentBet());
        }
    }

    public void getPlayerDecisions()
    {
        for(Player pl : playerList)
        {
            System.out.println("\nYour hand: " + pl.getHandString());
            boolean hit = pl.requestCard();
            while(hit == true)
            {
                pl.addCardToHand(blackjackDeck.takeCard());
                System.out.println("\nYour hand: " + pl.getHandString());
                hit = pl.requestCard();
            }
            System.out.println("Player decision complete\n");
        }
    }

    public void getDealerDecision()
    {
        System.out.println("Getting Dealer Decision Now");
        System.out.println("Dealer hand: " + dealer.getHandString());
        boolean hit = dealer.requestCard();
        while(hit == true)
        {
            dealer.addCardToHand(blackjackDeck.takeCard());
            System.out.println("\nDealer hand: " + dealer.getHandString());
            hit = dealer.requestCard();
        }
        System.out.println("Dealer decision complete\n");
    }

    public void checkWins()
    {
        // TODO Make this section not crap
        for(Player pl : playerList)
        {
            if(pl.getHandValue() > 21 || pl.getHandValue() < dealer.getHandValue())
            {
                // Loss
                pl.addChips((-1)*pl.getCurrentBet());
                System.out.println("You bet: "+pl.getCurrentBet());
                System.out.println("You lost! your current chip total is: "+pl.getChips());
            }
            else
            {
                // Win
                pl.addChips(pl.getCurrentBet());
                System.out.println("You bet: "+pl.getCurrentBet());
                System.out.println("You won! your current chip total is: "+pl.getChips());
            }
        }
    }

    public boolean checkContinue()
    {
        System.out.println("\nPlay another round? y/n");
        Scanner nextRound = new Scanner(System.in);
        if(nextRound.nextLine().equals("n") || nextRound.nextLine().equals("no")){
            return false;
        }
        else
        {
            return true;
        }
    }

    public void resetHands()
    {

        for(Player pl : playerList)
        {
            pl.clearHand();
        }
    }
}
