import java.util.HashMap;
import java.util.List;



/**
 * Created by brianyan on 10/23/15.
 */
public class StringsandArrays {

    public static void main(){

    }
    // Remove duplicates from a list
    public int [] removeDuplicates(int [] nums){

        return nums;
    }
    // Generate all of the permutations of a string
    public String generatePermuatation(String str){

        return str;
    }
    public int returnNonDupe(int [] nums){
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length; i++){
            if(map.get(nums[i])==null){
                map.put(nums[i],1);
            }
            else
                map.put(nums[i],2);

        }
            for(int value: map.values()){
                if(value == 1){
                    return value;
                }
            }
        return -1;
    }

}
