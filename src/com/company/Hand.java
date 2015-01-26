package com.company;

/**
 * Created by dan on 1/25/15.
 */
public class Hand
{
    private int cardsInHand;
    Card[] cards;

    public Hand()
    {
        cardsInHand = 0;
        cards = new Card[12]; // At 12 cards the player will always bust
    }

    public int size()
    {
        return cardsInHand;
    }

    public void addCard(Card aCard)
    {
        cards[cardsInHand] = aCard;
        cardsInHand++;
    }

    public void clearHand()
    {
        cardsInHand = 0;
        cards = new Card[12];
    }

    public int handValue()
    {
        int totalValue = 0;
        int aceCount = 0;
        for(int i =0;i<cardsInHand;i++)
        {
            switch(cards[i].getCardValue())
            {
                case ONE:
                    totalValue += 1;
                    break;
                case TWO:
                    totalValue += 2;
                    break;
                case THREE:
                    totalValue += 3;
                    break;
                case FOUR:
                    totalValue += 4;
                    break;
                case FIVE:
                    totalValue += 5;
                    break;
                case SIX:
                    totalValue += 6;
                    break;
                case SEVEN:
                    totalValue += 7;
                    break;
                case EIGHT:
                    totalValue += 8;
                    break;
                case NINE:
                    totalValue += 9;
                    break;
                case TEN:
                    totalValue += 10;
                    break;
                case JACK:
                case QUEEN:
                case KING:
                    totalValue += 10;
                    break;
                case ACE:
                    aceCount++;
                    break;
            }
        }
        if(aceCount != 0)
        {
            if(totalValue > 21-11){
                totalValue += (aceCount*1); //If we are gonna go over, don't go over, or at least try not to
            }
            else
            {
                switch(aceCount)
                {
                    case 1:
                        totalValue += (11);
                        break;
                    case 2:
                        totalValue += (11)+(1);
                        break;
                    case 3:
                        if(totalValue > 21-11-1-1)
                        {
                            totalValue += (1+1+1);
                        }
                        else
                        {
                            totalValue += (11)+(1)+(1);
                        }
                        break;
                    case 4:
                        if(totalValue > 21-11-1-1-1)
                        {
                            totalValue += (1+1+1+1);
                        }
                        else
                        {
                            totalValue += (11)+(1)+(1)+(1);
                        }
                        break;
                }
            }
        }
        return totalValue;
    }

    public String toString()
    {
        String handString = "{";
        for(int i =0;i<cardsInHand;i++)
        {
            handString += cards[i].toString();
            handString += ","; //TODO Make this not add a comma on the last card
        }
        handString += "}";
        return handString;
    }
}
