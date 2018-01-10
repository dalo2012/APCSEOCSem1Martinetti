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
                takeTurn(rollDice(), player);
                if(checkForWinner()){
                    player.win();
                    System.out.println(players.get(0).toString());
                    System.out.println(players.get(1).toString());
                    System.out.println(players.get(2).toString());
                    return;
                }
            }
        }while(!checkForWinner());
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
            if(player.checkBoard()==23){
                players.get(0).reset();
                players.get(1).reset();
                players.get(2).reset();
                return true;
            }
        }
        return false;
    }
    
    private void takeTurn(int[] numbers, Player player){
        boolean found = false;
        String squaresCrossed = " ";
        System.out.println(player.name + "'s" + " turn!");
        do{
            int j = player.checkBoard();
            //System.out.println(j);
            found = false;
            //System.out.println("Reached do-while");
            if(j<12){
                for(int i = 0;i<numbers.length;i++){
                    //System.out.println("Reached for loop");
                    if(numbers[i] == j + 1&&!found){
                        //System.out.println("Reached if statement");
                        player.clearSquare(j);
                        found = true;
                        squaresCrossed += (j+1) + ", ";
                    }
                }
            }else{
                for(int i = 0;i<numbers.length;i++){
                    //System.out.println("Reached for loop");
                    if(numbers[i] == 24-j &&!found){
                        //System.out.println("Reached if statement");
                        player.clearSquare(j);
                        found = true;
                        squaresCrossed += (j+1) + ", ";
                    }
                }
            }
        }while(found && player.checkBoard()!=11 && player.checkBoard() != 23);
        if(squaresCrossed.equals(" ")){
            System.out.println(player.name + " didn't cross off any squares. Bummer!");
        }else if(squaresCrossed.length() == 4||squaresCrossed.length()==5){
            System.out.println(player.name+" crossed off square" + 
                squaresCrossed.replace(", ", "") + ".");
        }else{
            System.out.println(player.name+" crossed off squares" + squaresCrossed + ".");
        }
    }
    
}
