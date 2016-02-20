import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


import apple.laf.JRSUIUtils;
import com.Helpers.*;
import com.Helpers.TreeNode;
import com.sun.xml.internal.ws.util.StringUtils;

import javax.swing.tree.*;

public class Main {

    public static void main(String[] args) {
        String str = "fucking";
        String s = "1232s";
        if(s.matches("[0-9]+"))
            System.out.println("fs");


        System.out.println(str.substring(str.length()-2,str.length()));
        System.out.println(str.substring(str.length()-3,str.length()));
        if(str.substring(str.length()-3,str.length()).equals("ing")){
            System.out.println("fuck");
            str = str.substring(0,str.length()-3);
            System.out.println(str);
        }
//        int [] lengths = {1,2,5,3};
//        Arrays.sort(lengths);
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        for(int n:lengths)
//            list.add(n);
//        Set<Character> set = new HashSet<Character>();
//        Stack<Character> stack = new Stack<Character>();
//        set.add('c');
    }
    public static boolean isbetween0and255(int num){
        return (num >= 0 && num <=255);

    }
    public int removeDuplicatesinplace(int[] nums) {
        // [ 1,1,2,5,5,5,6,7,9,9] -> [1,2,5,6,7,9], 6
        // return int of new length array
        if(nums == null || nums.length ==0)
            return 0;
        int currentNum = nums[0];
        int lastindex = 1;
        for(int i=1; i<nums.length; i++){
            if(currentNum == nums[i]){
                continue;
            }
            else {
                currentNum = nums[i];
                PerformSwap(lastindex,i,nums);
                lastindex+=1;
            }
        }
        return lastindex;
    }
    public void PerformSwap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return;
    }
    public static boolean isPalindrome(String str){
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        if(str.equals(sb))
            return true;
        return false;
    }
    public static boolean wordPattern(String pattern, String str) {
        String [] words = str.split(" ");
        HashMap<Character, String> map = new HashMap<Character,String>();
        if(words.length != pattern.length())
            return false;
        for(int i = 0; i<pattern.length();i++){
            if(!map.containsKey(pattern.charAt(i))){
                map.put(pattern.charAt(i),words[i]);
            }
            else {
                if(!map.get(pattern.charAt(i)).equals(words[i])){
                    return false;
                }
            }
        }
        return true;
    }

//    public static boolean isValidSocket(String address)
//    {
//        String [] socket = address.split("(\\.:)");
//        // Write your implementation here
//    }
    public static long sumOfIntegers(int[] arr){
        long sum = 0;
        for(int i: arr){
            sum += arr[i];
        }
        return sum;
    }
    /* Bob is in a candy shop and wants to purchase his favorite
     candy, which he knows costs N dollars. He has an infinite
     number of 1,2,5,10,20,50, and 100 dollar bills in his pocket.
      Bob wants to know the number of different ways he can pay
      the N dollars for his candy.
    */

    public static void PaidCandyShop(int n){
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        // 1 = 1
        // 2 = (2) (1,1,)
        // 3 = (2,1) (1,1,1)
        // 4 = (2,2) , (1,1,1,1) , (1,1,2)
        // 5 = (1,1,1,1,1) , (2,1,1,1) (2,2,1) (5)

        while(n>0){

        }
    }
    public static void HackerRankpractice(String [] args) throws IOException{
    Scanner in = new Scanner(System.in);
    final String fileName = System.getenv("OUTPUT_PATH");
    BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
    long res;

    int _arr_size = Integer.parseInt(in.nextLine());
    int[] _arr = new int[_arr_size];
    int _arr_item;
    for(int _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
        _arr_item = Integer.parseInt(in.nextLine());
        _arr[_arr_i] = _arr_item;
    }

    res = sumOfIntegers(_arr);
    bw.write(String.valueOf(res));
    bw.newLine();

    bw.close();
}
    public static void printscannedIntegers(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
    public static void ScanAndPrintStringDoubleInteger (String[] args) {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        String s = sc.nextLine();
        Double y = sc.nextDouble();
        //Complete this code

        System.out.println("String: "+s);
        System.out.println("Double: "+y);
        System.out.println("Int: "+x);
    }
    public static void printhash(){
        Scanner sc = new Scanner(System.in);
        int stairs = sc.nextInt();
        if(stairs < 1){
            System.out.println("Please enter another number");
            return;
        }
        else {
            int start = 1;
            String str = "#";


            while (start <= stairs) {
                System.out.print(String.format("%1$" + stairs + "s", printhash(start)));
                System.out.println();
                start++;
            }
        }
    }
    public static String printhash(int n){
        String s = "";
        while(n>0){
            s+="#";
            n--;
        }
        return s;
    }
    /* calculates the number of white space */
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
    Stack<Integer> stack = new Stack<Integer>();
        stack.push(5);
        Queue<Integer> q = new LinkedList<Integer>();
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
//    public static List<LinkedListNode> createLinkedListDepth(TreeNode root){
//       Queue<TreeNode> q = new LinkedList<TreeNode>();
//            q.add(root);
//            while(!q.isEmpty()){
//
//            }
//        return List<LinkedListNode>();
//    }

    public static ArrayList<Integer> findsubsequence( int [] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.size();
        int i = 0;
        int runningsum = 0;
        while(i< nums.length){
            runningsum += nums[i];
            if(!map.containsKey(runningsum)){
                map.put(runningsum , i);
                i++;
            }
            if(map.containsKey(runningsum - target)) {
                result.add(map.get(runningsum -target));
                result.add(map.get(runningsum));
                return result;
            }
        }// end while
        return result;
    }// end method

    public static int magicIndex(int[] nums){
        int start = 0;

        int found = magicIndexhelper(nums, 0, nums.length);
        return found;
    }// end method

    public static int magicIndexhelper(int [] nums, int start, int end){
        int mid = (start + end)/2;
        if(start > end)
            return Integer.MIN_VALUE;
        if(nums[mid] == mid)
            return mid;
        else if(nums[mid] > mid) {
            return magicIndexhelper(nums, start, mid - 1);
        }
        else
            return magicIndexhelper(nums, mid+1, end);
        }

    // end method
public static int helper(){
    Stack<Integer> s = new Stack<Integer>();
    s.add(5);
    return 5;
}


}
