package com.company;

/**
 * Created by dan on 1/25/15.
 */
public class Card
{
    // Blackjack really doesn't care about Suite, but I guess it's nice to include
    public enum Suite {
        HEART, DIAMOND, CLUB, SPADE
    }
    public enum Value {
        ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
    }

    private Suite cardSuite;
    private Value cardValue;

    public Card(Suite cardSuite,Value cardValue)
    {
        this.cardSuite = cardSuite;
        this.cardValue = cardValue;
    }

    public Suite getCardSuite()
    {
        return cardSuite;
    }

    public Value getCardValue()
    {
        return cardValue;
    }

    public String toString()
    {
        return "[" + cardValue.name() + " " + cardSuite.name() + "]";
    }
}
