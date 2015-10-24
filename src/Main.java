import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        int [] array = {2,5,5,3,2,3,10};
        System.out.println(returnNonDupe(array));

    }

    /* Given an array of duplicates, find the value
     that is the only nonduplicate  */
    public static int returnNonDupe(int [] nums){
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length; i++){
            if(map.get(nums[i])==null){
                map.put(nums[i],1);
            }
            else
                map.put(nums[i],2);
        }
        for(int key: map.keySet()){
            if(map.get(key) == 1)
                return key;
            }
        return -1;
}
}
