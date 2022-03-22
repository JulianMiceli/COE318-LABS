public class BlackJackGame {

    private CardPile deck;
    private CardPile houseCards;
    private CardPile yourCards;
    private boolean houseDone;
    private boolean playerDone;
    private UserInterface ui;

    public BlackJackGame(UserInterface ui) 
    {
        this.ui = ui;
        ui.setGame(this);
        deck = new CardPile();
            for (int i = 2; i < 15; i++) 
            {
                for (int j = 0; j < 4; j++) 
                {
                    deck.add(new Card(i, j, true));
                }
            }
        houseCards = new CardPile();
        yourCards = new CardPile();
        houseDone = false;
        playerDone = false;
    }

    public void start() 
    {
        Card c;
        c = deck.removeRandom();
        c.setFaceUp(false);
        getHouseCards().add(c);
        getHouseCards().add(deck.removeRandom());
        getYourCards().add(deck.removeRandom());
        getYourCards().add(deck.removeRandom());
        ui.display();
    }

    public void play() 
    {
        while (!houseDone || !playerDone) 
        {
            if (!houseDone) 
            {
                if (score(getHouseCards()) <= 17) 
                {
                    getHouseCards().add(deck.removeRandom());
                    ui.display();
                } 
                else 
                {
                    houseDone = true;
                }
            }
            if (!playerDone) 
            {
                if (ui.hitMe()) 
                {
                    getYourCards().add(deck.removeRandom());
                    ui.display();
                } 
                else 
                {
                    playerDone = true;
                }
            }
        
        }
    }

    public void end() 
    {
        getHouseCards().getCards().get(0).setFaceUp(true);
        ui.gameOver();
    }

  
    public int score(CardPile p) 
    {
        Card c;
        int ScoreTracker = 0;
        int count = 0;
        int temp;
    
            while (count < (p.getCards().size()))
            {
                c = p.getCards().get(count);
                temp = c.getRank();
                switch (temp)
                {
                    case 11:
                        ScoreTracker += 10;
                        break;
                    case 12:
                        ScoreTracker += 10;
                        break;
                    case 13:
                        ScoreTracker += 10;
                        break;
                    case 14:
                        ScoreTracker += 1;
                        break;
                    default:
                        ScoreTracker += temp;
                        break;
                }
                count++;
            }
        return ScoreTracker;
    }
 
    public CardPile getHouseCards() 
    {
        return houseCards;
    }

    public CardPile getYourCards() 
    {
        return yourCards;
    }

    public static void main(String[] args) 
    {
        BlackJackGame game = new BlackJackGame(new SimpleUI());
        game.start();
        game.play();
        game.end();
    }

}