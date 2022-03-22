import java.util.Scanner;

public class SimpleUI implements UserInterface 
{
    private BlackJackGame game;
    private Scanner user = new Scanner(System.in);
    private String Answer;
    private int Tracker = 0;

    public void setGame(BlackJackGame game) 
    {
        this.game = game;
    }

    public void display() 
    {
        if(Tracker == 0)
        {
            System.out.println("Players Cards: " + game.getYourCards());
            System.out.println("Houses Cards: " + game.getHouseCards());
            System.out.println("Hit or Pass?(y = Hit, n = pass)");
                do
                {
                    Answer = user.nextLine().toLowerCase();
                        switch(Answer)
                        {
                            case "y":
                                break;
                            case "n":
                                break;
                            default: System.out.println("Please either Hit "
                                    + "or Pass");
                                break;
                        }
                }
                while(!(Answer.equals("y") || Answer.equals("n")));
                Tracker = 1;
        }
    }

    public boolean hitMe() 
    {
        if(Answer.equals("y"))
        {
            Tracker = 0;
            return true;
        }
        else
            return false;
    }

    public void gameOver() 
    {
        int Player, House;
        Player = game.score(game.getYourCards());
        House = game.score(game.getHouseCards());
        System.out.println("Game over. Here are the results:");
        System.out.println("Players Cards: " + game.getYourCards());
        System.out.println("Players Score: " + Player);
        System.out.println("Houses Cards: " + game.getHouseCards());
        System.out.println("Houses Score: " + House);
        
        if(Player > 21 && House > 21)
        {
            System.out.println("The House wins!");
        }
        else if(Player > 21)
            System.out.println("The Player busted. House wins!");
        else if(House > 21)
            System.out.println("The House busted. Player wins!");
        else if(Player == House || Player < House)
            System.out.println("The House wins!");
        else if (Player > House && Player < 21)
            System.out.println("The Player wins!");
    }

}