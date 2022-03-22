public class Card implements Comparable 
{
    public static final int CLUB = 0;
    public static final int DIAMOND = 1;
    public static final int HEART = 2;
    public static final int SPADE = 3;
    int Rank, Suit;
    boolean FaceUp;
    String SuitName;
    String RankName;
  
    public Card(int rank, int suit, boolean faceUp) 
    {
        this.Rank = rank;
        this.Suit = suit;
        this.FaceUp = faceUp;
    }
    
    public boolean isFaceUp() 
    {
        if(FaceUp == true)
            return true;
        else
            return false;
    }

    public void setFaceUp(boolean faceUp) 
    {
        this.FaceUp = faceUp;
    }
    
    public int getRank() 
    {
        return Rank;
    }

    public int getSuit() 
    {
        return Suit;
    }

    @Override
    public boolean equals(Object ob) 
    {
        if (!(ob instanceof Card)) 
        {
            return false;
        }
        Card c = (Card) ob;
        if(this.getRank() == c.getRank() && this.getSuit() == c.getSuit())
            return true;
        else
            return false;
    }

    @Override
    public int hashCode() 
    {
        int hash = 7;
        hash = 31 * hash + this.getRank();
        hash = 31 * hash + this.getSuit();
        return hash;
    }

    @Override
    public int compareTo(Object obj) 
    {
        return compareTo((Card) obj);
    }

    public int compareTo(Card c) 
    {
        if(this.getRank() > c.getRank())
        {
            if(this.getSuit() < c.getSuit())
                return getRank();
        }
        return c.getRank();
    }
    
    public String getRankString() 
    {
        switch(Rank)
        {
            case 2: RankName = "2";
                break;
            case 3: RankName = "3";
                break;
            case 4: RankName = "4";
                break;
            case 5: RankName = "5";
                break;
            case 6: RankName = "6";
                break;
            case 7: RankName = "7";
                break;
            case 8: RankName = "8";
                break;
            case 9: RankName = "9";
                break;
            case 10: RankName = "10";
                break;
            case 11: RankName = "JACK";
                break;
            case 12: RankName = "QUEEN";
                break;
            case 13: RankName = "KING";
                break;
            case 14: RankName = "ACE";
                break;
            default: RankName = "ERROR";
        }
        return RankName;
    }

    public String getSuitString() 
    {
        switch(Suit)
        {
            case CLUB: return "Clubs";
            case DIAMOND: return "Diamond";
            case HEART: return "Heart";
            case SPADE: return "Spade";
            default: return "?";
        }
    }

    @Override
    public String toString() 
    {
        return (isFaceUp())?(getSuitString()+ " " +getRankString()):"?";
    }

    public static void main(String[] args) 
    {
        Card club5 = new Card(5, 0, true);
            System.out.println("club5: " + club5);
        Card spadeAce = new Card(14, SPADE, true);
            System.out.println("spadeAce: " + spadeAce);
    
            System.out.println("club5 compareTo spadeAce: "
            + club5.compareTo(spadeAce));
    
            System.out.println("club5 compareTo club5: "
            + club5.compareTo(club5));
    
            System.out.println("club5 equals spadeAce: "
            + club5.equals(spadeAce));
    
            System.out.println("club5 equals club5: "
            + club5.equals(club5));
    }
}