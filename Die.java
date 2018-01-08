import java.util.Random;
public class Die
{
    int sides;
    int lastRoll;
    public Die(){
        sides = 6;
        lastRoll = 0;
    }
    
    public Die(int _sides)
    {
        sides = _sides;
        lastRoll = 0;
    }
    
    public int roll(){
        Random rand = new Random();
        int newRoll = (int)(rand.nextDouble()*6) + 1;
        lastRoll = newRoll;
        return newRoll;
    }
    
    public String toString(){
        return "Last roll was: " + roll();
    }
}
