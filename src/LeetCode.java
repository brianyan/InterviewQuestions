import java.util.ArrayList;
import java.util.List;

/**
 * Created by brianyan on 11/11/15.
 */
public class LeetCode {

    public static void main(){

    }
    /* You are playing the following Flip Game with your friend:
    Given a string that contains only these two characters: + and -,
    you and your friend take turns to flip two consecutive "++"
    into "--". The game ends when a person can no longer make a move
     and therefore the other person will be the winner.
     */
    public List<String> generatePossibleNextMoves(String s) {
        ArrayList<String> result = new ArrayList<String>();
        int count = 0;
        if (s.length() <= 1) {
            return result;
        }
        while (count < s.length() - 1) {
            if (s.charAt(count) == '+') {
                if (s.charAt(count) == s.charAt(count + 1)) {
                    StringBuilder sb = new StringBuilder(s);
                    sb.replace(count, count + 2, "--");
                    result.add(sb.toString());
                }
            }
            count++;
        }
        return result;
    }
    /* Code Review
    * Things I could have done better
    * 1) Use Substring to replace the stringbuilder
    * 2) State edge cases 
    */
}


