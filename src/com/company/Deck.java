package com.company;
import java.util.Collections;
import java.util.Stack;

/**
 * Created by dan on 1/25/15.
 */
public class Deck
{
    Stack<Card> deckRepresentation;

    public Deck()
    {
        deckRepresentation = new Stack<Card>();
        for(Card.Value each : Card.Value.values())
        {
            for(Card.Suite all : Card.Suite.values())
            {
                deckRepresentation.add(new Card(all,each));
            }
        }

        shuffleDeck();
    }

    public Card takeCard()
    {
        return deckRepresentation.pop();
    }

    public int getDeckSize()
    {
        return deckRepresentation.size();
    }

    public void shuffleDeck()
    {
        Collections.shuffle(deckRepresentation);
    }


}
