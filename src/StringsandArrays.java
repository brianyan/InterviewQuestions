import java.util.HashMap;
import java.util.List;



/**
 * Created by brianyan on 10/23/15.
 */
public class StringsandArrays {

    public static void main(){
        int [] p = {1,2,2,2,3,3,4};
        System.out.println(removeDuplicates(p));

    }
    // Remove duplicates from a list
    public static int [] removeDuplicates(int [] nums){
        int dupes = 0;
        int i=1;
        while(i< nums.length){
            if(nums[i] == nums[i-1])
                dupes++;
            else
                nums[i-dupes] = nums[i];
            i++;
        }
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
    public int BeattheStockMarket(int [] stockprices){
        int lowindex = 0;
        int highindex = 1;
        int profit = Integer.MIN_VALUE;
        int i = 0;
        while(i<stockprices.length){

        }
        return 0;
    }
}
