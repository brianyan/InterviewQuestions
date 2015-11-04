import java.util.HashMap;
import java.util.HashSet;
import com.Helpers.*;

public class Main {

    public static void main(String[] args) {
      String s = "abc de123";
        String temp = reversewordsinplace(s);
        System.out.println(temp);

    }

    /* Given an array of duplicates, find the value
     that is the only nonduplicate  */
    /* Reverse words in place */

    public static String reversewordsinplace(String str) {
        String temp = "";
        String result = "";
        // reverse string in place
        for (int i = str.length() - 1; i >= 0; i--) {
            temp += str.charAt(i);
        }

        // here we have a reversed string,
        // now we want to keep track of length of the word until whitespace
        // and once it reaches whitespace, reverse that word
        int k = 0;
        while (k < temp.length()) {
            int start = 0;
            int end = 0;
            if(!Character.isWhitespace(temp.charAt(k))) {
                end ++;
            }
            else{
                int temp1 = end;
                while(start<temp1){
                    result +=temp.charAt(temp1-1);
                    temp1--;
                }
                result += " ";
            }
            end++;
            start = end;

            k = end;

        }
        return result;
    }
    /* Classic reverse the string problem */

    public static String reverse(String str){
        String temp = new StringBuilder(str).reverse().toString();
        return temp;
    }
    public static boolean hasAllUniqueChars(String s){
        if(s== "")
            return true;
        else if(s == " "){
            return false;
        }
        HashSet<Character> set = new HashSet<Character>();
        for(int i=0; i< s.length(); i++) {
            if(set.contains(s.charAt(i)))
                return false;
            else {
                set.add(s.charAt(i));
            }
        }
        return true;
    }
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
    /* Given two sorted arrays A and B, A has a buffer at the end
    large enough to hold B. How would you merge them into a sorted one

    public static int [] mergeSortedArrays(int [] A, int [] B){
        int x = 0;
        int y = 0;
        int i = 0;
        int [] list = new int[A.length+B.length];
        while(x < A.length && y <B.length){
            if(A[x]<= B[y]){
                list[i] = A[x];
                i++;
                x++;
            }
            else if(A[x]> B[y]){
                list[i] = B[y];
            }
            else if(x == A.length-1)
                for(int j = )
        }
return new int [2];
    }


*/
    /* Find # of 1's in the int */

    public static int numberOfOnes(int num){
        int i=0;
        while(num>0){
            if(num%10 ==1)
                i++;
            num /=10;
        }
        return i;
    }








}
