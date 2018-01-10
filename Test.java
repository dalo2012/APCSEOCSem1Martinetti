import java.util.ArrayList;
import java.util.Scanner;
public class Test
{
    public static void main(String[] args){
        Player player1 = new Player("David Reetz");
        Player player2 = new Player("Kevin Sikes");
        Player player3 = new Player("Elijah Thibodeau");
        
        Die die1 = new Die(6);
        Die die2 = new Die(6);
        Die die3 = new Die(6);
        
        Scanner scan = new Scanner(System.in);
        String response;
        
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        
        ArrayList<Die> dice = new ArrayList<Die>();
        dice.add(die1);
        dice.add(die2);
        dice.add(die3);
        
        Martinetti martinetti = new Martinetti(players, dice);
        
        do{
            martinetti.simulateGame();
            System.out.println("Play Again? (y/n)");
            response = scan.next();
        }while(response.equals("y")); 
        System.out.println("Thanks for playing!!");
        
        //System.out.println(die1.toString());
        //System.out.println(die2.toString());
        //System.out.println(die3.toString());
    }
}
