import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

import apple.laf.JRSUIUtils;
import com.Helpers.*;
import com.Helpers.TreeNode;

import javax.swing.tree.*;

public class Main {

    public static void main(String[] args) {
//       TreeNode node = new TreeNode(10);
//        node.setRightChild(new TreeNode(15));
//        node.setLeftChild(new TreeNode(5));
//        node.left.setRightChild(new TreeNode(8));
//        node.left.setLeftChild(new TreeNode(3));
//
//        System.out.println(inorderTraversalwithoutRecursion(node));

        String str = "There is a blackout";
        System.out.println(reversewords(str).toString());
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
    public static boolean StringRotation(String str1, String str2){
        StringBuilder temp = new StringBuilder();
        return true;
    }
    public static String test(String str){

        return(str.substring(1));
    }
    public static String inorderTraversalwithoutRecursion(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        String result = "";
        boolean [] array = new boolean[16];
        Arrays.fill(array, false);
        array[root.data] = true;
        while(!queue.isEmpty()){
            if(queue.peek().left!=null){
                if(array[queue.peek().left.data] == false) {
                    queue.add(queue.peek().left);
                    array[queue.peek().left.data] = true;
                }
                else break;
            }
            else if (queue.peek().right != null) {
                if(array[queue.peek().right.data] ==false){
                    TreeNode right = new TreeNode(queue.peek().right.data);
                    array[queue.peek().right.data] = true;
                    result += queue.peek() + " ->";
                    queue.remove(queue.peek());
                    queue.add(right);
                }
            }

            else {
                    result += queue.peek() + " ->";
                    queue.remove(queue.peek());

                }
        }
        return result;

    }
    public static char[] repeatedletters(String str){
        char [] test = new char[256];
        char [] result = new char[str.length()];
        int count = 0;
        for(int i=0; i<str.length();i++){
            char c = str.charAt(i);
            if(test[c] == 1){
                result[count] = c;
                count++;
            }
            test[c]++;
        }
        return result;
    }
    public void firstNonRepeatingChar(String st1 ){

        int[] freq = new int[26];

        for(int i=0; i<st1.length() ;i++){
            //first time char occurs, store the index of that char
            if(freq[st1.charAt(i)-'a']==0){
                freq[st1.charAt(i)-'a'] = 1;
            }else{//occurs for more than one time
                freq[st1.charAt(i)-'a']++ ;
            }
        }

        for(int i=0; i<st1.length();i++)
        {
            if(freq[st1.charAt(i)-'a']==1){
                System.out.println(st1.charAt(i));
                break;
            }
        }

    }
    public static int[] testarray(int[] nums){
        nums[1]= 5;
        nums[4] = 2;
        System.out.println(nums[4]);
        return nums;
    }

    public static void permutation(String prefix, String str){
        int n = str.length();
        if(n == 0) { // here the length of string has been reached
            System.out.println(prefix);
        }
        else {
            // do recursive statement
            for(int i =0; i<n; i++){
                permutation(prefix + str.charAt(i),
                        str.substring(0,i) + str.substring(i+1));
            }
        }
    }
    /* compute the different ways someone can step up stairs size n given that there is 1
    public static int numberofsteps(int n, int[] memo){

    }
    */
    public static boolean isPalindromePermutation(String str){
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        int numOdds = 0;
        for(int i=0; i<str.length();i++){
            if(!map.containsKey(str.charAt(i))){
                map.put(str.charAt(i), 1);
                numOdds++;
            }

            else if( map.get(str.charAt(i))%2 == 1){
                numOdds--;
                map.put(str.charAt(i), map.get(str.charAt(i))+1);
            }
            else {
                map.put(str.charAt(i), map.get(str.charAt(i))+1);
                numOdds++;
            }
        }// end for loop
        if(numOdds>1){
            return false;
        }

        return true;
    }
    /* Compress the string Input : "aabccccccaaa"
                           Output: a2b1c5a2
     */
    public static String compress(String str){
        String result = "";
        int count = 1;
        for(int i=0; i<=str.length()-2;i++){
            if(count == 1) {
                result += str.charAt(i);
            }
            if(str.charAt(i) == str.charAt(i+1)){
                count++;
            }
            else {
                result +=  count;
                count = 1;
            }
        }
        result+= count;
        return result;
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
    public static String reversewords(String str){
        String[] words =  str.split(" ");
        StringBuilder build = new StringBuilder();
        for(int i=words.length-1; i>=0;i--){
            build.append(words[i]);
            build.append(" ");
        }
        return build.toString();

    }
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
