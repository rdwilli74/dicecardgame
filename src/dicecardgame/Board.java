package dicecardgame;

import java.util.ArrayList;
import java.util.Collection;

import dicecardgame.Card.Rank;

public class Board
{
    String clubs;
    String hearts;
    String diamonds;
    String spades;

    ArrayList<String> suits = new ArrayList<String>();;
    Card lowClub;
    Card highClub;
    Card lowSpade;
    Card highSpade;
    Card lowDiamond;
    Card highDiamond;
    Card lowHeart;
    Card highHeart;

    // temp cards
    Card lowCard;
    Card highCard;

    public Board()
    {

    }

    public void addBoard(String[] b) throws InvalidBoard {
        if (b.length != 4)
            throw new InvalidBoard("Invalid number of lines for a valid board "
                    + b.toString());
        for (String line : b)
        {
            if (line.startsWith(Card.Suit.CLUBS.getString()))
            {
                if (checkOutBoardLine(line))
                {
                    clubs = line;
                    lowClub = lowCard;
                    highClub = highCard;
                }
            }
            else if (line.startsWith(Card.Suit.DIAMONDS.getString()))
            {
                if (checkOutBoardLine(line))
                {
                    diamonds = line;
                    lowDiamond = lowCard;
                    highDiamond = highCard;
                }
            }
            else if (line.startsWith(Card.Suit.HEARTS.getString()))
            {
                if (checkOutBoardLine(line))
                {
                    hearts = line;
                    lowHeart = lowCard;
                    highHeart = highCard;
                }
            }
            else if (line.startsWith(Card.Suit.SPADES.getString()))
            {
                if (checkOutBoardLine(line))
                {
                    spades = line;
                    lowSpade = lowCard;
                    highSpade = highCard;
                }
            }
        }
        suits.add(clubs);
    }

    private boolean checkOutBoardLine(String line) throws InvalidBoard {
        boolean flag = false;
        try
        {
            if (line.length() == 1)
            {
                flag = true;
                lowCard = null;
                highCard = null;
            }
            else if (line.length() == 2 && line.endsWith("7"))
            {
                flag = true;
                lowCard = new Card(line.substring(1, 2) + line.substring(0, 1));
                highCard = new Card(line.substring(1, 2) + line.substring(0, 1));
            }
            else if (line.length() == 3)
            {
                String lCard = line.substring(1, 2) + line.substring(0, 1);

                lowCard = new Card(lCard);
                // other end card
                String hCard = line.substring(2, 3) + line.substring(0, 1);
                highCard = new Card(hCard);
                flag = true;
            }
            else
                throw new InvalidBoard("line is invalid: " + line);
        }
        catch (InvalidCard e)
        {
            throw new InvalidBoard("Invalid board configuration: " + line
                    + " invalid card: " + e.getMessage());
        }

        return flag;
    }

    public String getClubLine() {
        return clubs;
    }

    public String getSpadeLine() {
        return spades;
    }

    public String getHeartLine() {
        return hearts;
    }

    public String getDiamondLine() {
        return diamonds;
    }

    public ArrayList<Card> getPlayableCards() {
        ArrayList<Card> cards = new ArrayList<Card>();
        try
        {

            if (clubs.length() == 1)
            {
                cards.add(new Card("7C"));
            }
            if (spades.length() == 1)
            {
                cards.add(new Card("7S"));
            }
            if (hearts.length() == 1)
            {
                cards.add(new Card("7H"));
            }
            if (diamonds.length() == 1)
            {
                cards.add(new Card("7D"));
            }
            if (clubs.length() == 2)
            {
                cards.add(new Card("6C"));
                cards.add(new Card("8C"));
            }
            if (spades.length() == 2)
            {
                cards.add(new Card("6S"));
                cards.add(new Card("8S"));
            }
            if (hearts.length() == 2)
            {
                cards.add(new Card("6H"));
                cards.add(new Card("8H"));
            }
            if (diamonds.length() == 2)
            {
                cards.add(new Card("6D"));
                cards.add(new Card("8D"));
            }
            if (clubs.length() == 3)
            {
                cards.addAll(getNextCards(lowClub, highClub));
            }
            if (spades.length() == 3)
            {
                cards.addAll(getNextCards(lowSpade, highSpade));
            }
            if (hearts.length() == 3)
            {
                cards.addAll(getNextCards(lowHeart, highHeart));
            }
            if (diamonds.length() == 3)
            {
                cards.addAll(getNextCards(lowDiamond, highDiamond));
            }
        }
        catch (InvalidCard e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return cards;
    }

    private Collection<? extends Card> getNextCards(Card lowCard, Card highCard) {
        ArrayList<Card> c = new ArrayList<>();

        Card temp = Card.getNextLowest(lowCard);
        if (temp != null) c.add(temp);
        temp = Card.getNextHighest(highCard);
        if (temp != null) c.add(temp);
        return c;
    }

    public Card getLowClub() {
        return lowClub;
    }

    public Card getHighClub() {
        return highClub;
    }

    public Card getLowSpade() {
        return lowSpade;
    }

    public Card getHighSpade() {
        return highSpade;
    }

    public Card getLowDiamond() {
        return lowDiamond;
    }

    public Card getHighDiamond() {
        return highDiamond;
    }

    public Card getLowHeart() {
        return lowHeart;
    }

    public Card getHighHeart() {
        return highHeart;
    }

}
