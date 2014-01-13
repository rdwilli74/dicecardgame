package dicecardgame.card;

import java.util.HashMap;
import java.util.Map;

import dicecardgame.exceptions.InvalidCard;

/**
 * @author mom
 *
 * The Card object will hold all the neccessary information about a card.  It has a method to computer the next
 * lowest and next highest cards in the deck for a given suit.
 */
public class Card
{

    /**
     * @author mom
     *  Enum to hold the valid values for a given card.
     */
    public enum Rank
    {
        DUECE(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(
                9), TEN(10), JACK(11), QUEEN(12), KING(13), ACE(14);

        private int num;

        Rank(int num)
        {
            this.num = num;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }
    }

    Rank rank;
    String rankString;

    
    /**
     * Maps a string to the valid enum Rank. 
     */
    Map<String, Rank> RankMap = new HashMap<String, Rank>();

    /**
     * @author mom
     *
     *  Suite holds the string 
     */
    public enum Suit
    {
        DIAMONDS("D"), CLUBS("C"), HEARTS("H"), SPADES("S");

        private final String suitString;

        Suit(String s)
        {
            suitString = s;
        }

        public String getString() {
            return suitString;
        }
    };

    Suit suit;

    public Card()
    {
        initRank();
    }

    public Card(String cardString) throws InvalidCard
    {
        initRank();
        rankString = String.valueOf(cardString.charAt(0));
        if (RankMap.containsKey(rankString))
            rank = RankMap.get(rankString);
        else
            throw new InvalidCard("Bad card " + cardString);
        String suitString = String.valueOf(cardString.charAt(1));
        switch (suitString)
        {
            case "S":
                suit = Suit.SPADES;
                break;
            case "D":
                suit = Suit.DIAMONDS;
                break;
            case "H":
                suit = Suit.HEARTS;
                break;
            case "C":
                suit = Suit.CLUBS;
                break;
            default:
            {
                throw new InvalidCard("bad card " + cardString);
            }
        }
    }

    public String getRankString() {
        return rankString;
    }

    private void initRank() {
        RankMap.put("2", Rank.DUECE);
        RankMap.put("3", Rank.THREE);
        RankMap.put("4", Rank.FOUR);
        RankMap.put("5", Rank.FIVE);
        RankMap.put("6", Rank.SIX);
        RankMap.put("7", Rank.SEVEN);
        RankMap.put("8", Rank.EIGHT);
        RankMap.put("9", Rank.NINE);
        RankMap.put("T", Rank.TEN);
        RankMap.put("J", Rank.JACK);
        RankMap.put("Q", Rank.QUEEN);
        RankMap.put("K", Rank.KING);
        RankMap.put("A", Rank.ACE);

    }

    public String getSuit() {
        return suit.suitString;
    }

    public int getRank() {
        return rank.num;
    }

    public String toString() {
        String val = rankString + getSuit();
        return val;
    }

    public static Card getNextLowest(Card lowCard) {
        Card c = null;
        String s = lowCard.getSuit();
        String rString = lowCard.getRankString();
        try
        {
            switch (rString)
            {
                case "2":
                    break;
                case "3":
                    c = new Card("2" + s);
                    break;
                case "4":
                    c = new Card("3" + s);
                    break;
                case "5":
                    c = new Card("4" + s);
                    break;
                case "6":
                    c = new Card("5" + s);
                    break;
                case "7":
                    c = new Card("6" + s);
                    break;
                case "8":
                    c = new Card("7" + s);
                    break;
                case "9":
                    c = new Card("8" + s);
                    break;
                case "T":
                    c = new Card("9" + s);
                    break;
                case "J":
                    c = new Card("T" + s);
                    break;
                case "Q":
                    c = new Card("J" + s);
                    break;
                case "K":
                    c = new Card("Q" + s);
                    break;
                case "A":
                    c = new Card("K" + s);
                    break;
                default:
                    System.out.println("WTF?");
                    break;
            }
        }
        catch (InvalidCard e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return c;
    }

    public static Card getNextHighest(Card currentCard) {
        Card c = null;
        String s = currentCard.getSuit();
        String rString = currentCard.getRankString();
        try
        {
            switch (rString)
            {
                case "2":
                    c = new Card("3" + s);
                    break;
                case "3":
                    c = new Card("4" + s);
                    break;
                case "4":
                    c = new Card("5" + s);
                    break;
                case "5":
                    c = new Card("6" + s);
                    break;
                case "6":
                    c = new Card("7" + s);
                    break;
                case "7":
                    c = new Card("8" + s);
                    break;
                case "8":
                    c = new Card("9" + s);
                    break;
                case "9":
                    c = new Card("T" + s);
                    break;
                case "T":
                    c = new Card("J" + s);
                    break;
                case "J":
                    c = new Card("Q" + s);
                    break;
                case "Q":
                    c = new Card("K" + s);
                    break;
                case "K":
                    c = new Card("A" + s);
                    break;
                case "A":
                    c = null;
                    break;
                default:
                    System.out.println("WTF?");
                    break;
            }
        }
        catch (InvalidCard e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return c;
    }
}
