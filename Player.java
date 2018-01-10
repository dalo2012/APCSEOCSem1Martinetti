public class Player{
    String name;
    int numGamesWon;
    boolean[] board = new boolean[24];
    public Player(){
        name = "Craig Daniels";
        numGamesWon = 0;
        System.out.println("Craig Daniels is now playing.");
    }
    
    public Player(String _name){
        name = _name;
        numGamesWon = 0;
        System.out.println(name + " is now playing.");
    }

    public int checkBoard(){
        for (int i = 0;i<24;i++){
            if(!board[i]){
                return i;
            }
        }
        return 24;
    }
    
    public void win(){
        numGamesWon++;
        System.out.println(name + " has won the game!");
        //System.out.println(toString());
    }
    
    public void clearSquare(int index){
        //System.out.println(name + " has crossed off square " + (index+1));
        board[index] = true;
    }
    
    public String toString(){
        return name + " has won " + numGamesWon + " games.";
    }
    
    public void reset(){
        for (int i = 0;i<24;i++){
            board[i] = false;
        }
    }
}
