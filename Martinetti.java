import java.util.ArrayList;
public class Martinetti
{
    ArrayList<Player> players;
    ArrayList<Die> dice;
    int[] results;
    String currentPlayer;
    public Martinetti(ArrayList<Player> _players, ArrayList<Die> _dice)
    {
        players = _players;
        dice = _dice;
        results = new int[3];
        currentPlayer = "";
    }
    
    public void simulateGame(){
        do{
            for(Player player:players){
                
            }
        }while(checkForWinner());
    }
    
    private int[] rollDice(){
        int i = 0;
        int[] dieRolls = new int[7];
        for(Die die:dice){
            dieRolls[i] = die.roll();
            i++;
        }
        dieRolls[3] = dieRolls[1]+dieRolls[2];
        dieRolls[4] = dieRolls[1]+dieRolls[3];
        dieRolls[5] = dieRolls[2]+dieRolls[3];
        dieRolls[6] = dieRolls[1]+dieRolls[2]+dieRolls[3];
        return dieRolls;
    }
    
    private boolean checkForWinner(){
        for(Player player:players){
            if(player.checkBoard()==24){
                player.win();
                player.toString();
                return true;
            }
        }
        return false;
    }
    
    private void crossBox(int[] numbers, Player player){
        do{
            int j = player.checkBoard();
            boolean found = false;
            for(int i = 0;i<numbers.length;i++){
                if(numbers[i] == j&&!found){
                    player.clearSquare(j);
                    found = true;
                }
            }
        }while(true);
    }
    
    private void takeTurn(Player player){
        boolean keepGoing = true;
        do{
            crossBox(rollDice(), player);
        }while(keepGoing);
    }
}
