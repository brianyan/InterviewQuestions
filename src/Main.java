import java.util.HashMap;
import java.util.HashSet;
import com.Helpers.*;

public class Main {

    public static void main(String[] args) {
//        char [] str = {'h' , 'i', '_'};
//        int result = numberwhitespace(str);
        char [] str = {'h' , 'i', '_' , 't', 'h', 'e', 'r', 'e', ' ', ' ', ' ', ' '};
        char[] result = URLify(str,8);                                      //\0
        System.out.println(result);


    }
    /* calculates the number of white space */
    public static int numberwhitespace(char [] string){

        int numws = 0;
        for( int i = 0; i<string.length;i++){
            if(string[i] == '_') {
                numws++;
            }
        }
        return numws;
    }

    static char[] URLify(char[] str, int truelength){
        int white_space = numberwhitespace(str);
        int newlength = truelength + white_space*2;
        str[newlength] = '\0';
        for(int i= truelength-1;i>=0; i--){
            if(str[i] == '_'){
                str[newlength-1] = '0';
                str[newlength-2] = '2';
                str[newlength-3] = '%';
                newlength = newlength - 3;
            }
            else {
                str[newlength-1] = str[i];
                newlength--;
            }
        }
        return str;
    }
    /* Given two strings, write a method to decide if one is a permutation of the other */
    public static boolean isPermutation(String str1, String str2){
        if(str1.length()!=str2.length()){
            return false;
        }
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        for(int i=0;i<str1.length();i++){
            if(!map.containsKey(str1.charAt(i))){
                map.put(str1.charAt(i),1);
            }
            else {
                map.put(str1.charAt(i), map.get(str1.charAt(i)) + 1);
            }
        }
        for(int j=0; j<str2.length();j++){
            if(!map.containsKey(str2.charAt(j)))
                return false;
            else if(map.get(str2.charAt(j))==0)
                return false;
            else {
                map.put(str2.charAt(j), map.get(str2.charAt(j)) - 1);
            }
        }
        return true;
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

    public static String reverseStringBuilder(String str){
        String temp = new StringBuilder(str).reverse().toString();
        return temp;
    }
    public static String reverseString(String str){
        String result = "";
        for(int i=str.length()-1;i>=0;i--) result += str.charAt(i);
        return result;
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

    /* Uses HashSet to return the first integer that is a nonDuplicate */

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
    large enough to hold B. How would you merge them into a sorted one*/

    public static int [] mergeSortedArrays(int [] A, int [] B){
       return A;
    }

    /* Given an array of integers, count the number of pairs of integers that have the difference
    k. For example, given the array A = [1,7,5,9,2,12,3] and k=2 Output = (1,3) , (3,5) , (5,7) , (7,9)
     */
    public static String findelementswithdiffk(int [] array, int k){
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        String temp = "";
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], array[i]);
            }
        }
        for (int j = 0; j < array.length; j++) {
            if(map.containsKey(array[j]+2)){
                temp += " " + array[j] + "" + map.get(array[j]+2);
            }
        }
        return temp;
    }


    /* Find # of 1's in the int */

    static int numberOfOnes(int num){
        int i=0;
        while(num>0){
            if(num%10 ==1)
                i++;
            num /=10;
        }
        return i;
    }








}
