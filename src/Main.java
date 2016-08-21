import java.io.BufferedWriter;
import java.io.CharArrayReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import com.Helpers.*;
import com.Helpers.TreeNode;
import com.sun.source.tree.Tree;


public class Main {

    public static boolean DetectCycle(LinkedListNode node){
        LinkedListNode slow = node;
        LinkedListNode fast = node;
        while(fast !=null && fast.next !=null){
            if(slow == fast || slow.next == fast){
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
    public static void main(String[] args) {

        int num = 8;
        String s = "";
        System.out.println(s.substring(0,0));
    }
    public static boolean isbetween0and255(int num) {
        return (num >= 0 && num <= 255);

    }

    public static int nthfibbonaciRecursive(int num){
        if(num == 0){
            return 0;
        }
        if(num == 1){
            return 1;
        }
        return nthfibbonaciRecursive(num-1) + nthfibbonaciRecursive(num-2);
    }
    public static int nthfibbonaciIterative(int num){
        if(num == 0){
            return 0;
        }
        if(num == 1){
            return 1;
        }
        int curr = 1;
        int prev = 0;
        int result = curr + prev;
        for(int i=2; i<=num; i++){
            int temp = curr;
            result = curr + prev;
            curr = result;
            prev = temp;
        }
        return result;
    }
    /* String Questions */

    public static boolean isPalindrome(String str){
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        if(str.equals(sb))
            return true;
        return false;
    }

    // Return the last word in a String
        public int lengthOfLastWord(String s) {
            if(s.length() == 0 || s == null)
                return 0;
            String [] words = s.trim().split(" ");
            return words[words.length-1].length();
        }
    /* Array Questions */

    // Return the Longest Common Prefix among all Strings in a String Array
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        String result = "";
        /*
        string
        str
        s
        strs
        ss
        sss
        -> return s
        */

        String s = strs[0]; // s = string
        int MinLengthPrefix = s.length();
        for(int i=1; i<strs.length; i++){
            int length = 0;
            for(int j = 0; j<strs[i].length() && j<s.length();j++){

                if(strs[i].charAt(j) == s.charAt(j))
                    length++;
                else
                    break;
            }
            if(length < MinLengthPrefix )
                MinLengthPrefix = length;
        }
        return s.substring(0,MinLengthPrefix);
    }
    /* Find maximum profit given a list of prices for stocks where ith
    * index represents the ith day */
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2)
            return 0;
        int lowestminIndex = 0;
        int maxprofit = 0;
        int diff = 0;
        // [ 2, 5, 10, 9, 15,3, 17,1,18]
        for(int i=0; i<prices.length;i++){
            if(prices[i] < prices[lowestminIndex]){
                lowestminIndex = i;
            }
            diff = prices[i] - prices[lowestminIndex];
            if(diff > maxprofit){
                maxprofit = diff;
            }
        }
        return maxprofit;
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
    /* function to parse Int as String */
    public static String lessthanThousand(int num){
        HashMap<Integer, String> map = new HashMap <Integer,String>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Ninteen");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");
        String result = "";
        //801
        if(num > 100){
            int hundreds = num /100;
            num = num - hundreds * 100;
            result += map.get(hundreds) + " Hundred ";
        }
        if(num > 9){
            int digit = num % 10;
            result += map.get(num - digit) + map.get(digit);
        }
        return result;
    }
    /* Pascal's Triangle problem*/
    public List<List<Integer>> generate(int numRows) {
        List< List<Integer> > result = new ArrayList< List<Integer> >();
        if(numRows == 0)
            return result;
        ArrayList<Integer> firstRow = new ArrayList<Integer>();
        firstRow.add(1);
        result.add(firstRow);
        for(int i=1;i<numRows; i++) {
            List<Integer> temp = result.get(i-1);
            ArrayList<Integer> xRow = new ArrayList<Integer>();
            for(int j=0;j<=temp.size();j++){
                if(j == 0 || j == temp.size()){
                    xRow.add(0);
                }
                else{
                    xRow.add(temp.get(j-1) + temp.get(j));
                }
            } // end inner for loop
            result.add(xRow);
        } // end outer for loop
        return result;
    } // end generate function
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
//    public static List<LinkedLinkedListNode> createLinkedListDepth(TreeNode root){
//       Queue<TreeNode> q = new LinkedList<TreeNode>();
//            q.add(root);
//            while(!q.isEmpty()){
//
//            }
//        return List<LinkedLinkedListNode>();
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
    /* Linked List practice problems */
    public LinkedListNode swapPairs(LinkedListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        LinkedListNode FirstSwap = head;
        while(FirstSwap.next != null){
            int temp = FirstSwap.data;
            FirstSwap.data = FirstSwap.next.data;
            FirstSwap.next.data = temp;
            if(FirstSwap.next.next == null){
                return head;
            }
            FirstSwap = FirstSwap.next.next;
        }
        return head;
    }
    /*
    OddEvenList returns a LinkedListNode where the odd indexes
    are the first half of the list and the second half of the list
    is all even index nodes
     */
    public LinkedListNode oddEvenList(LinkedListNode head) {
        /*
     Input:1->2->3->4->NULL,
    Output:1->3->2->NULL.
        */
        if(head == null || head.next == null || head.next.next == null){
            return head;
        }
        LinkedListNode startOfEvens = head.next;
        LinkedListNode even = head.next;
        LinkedListNode odd = head;
        while(even!= null && even.next!=null){
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = startOfEvens;
        return head;
    }
    /* Reverse a Linked List*/
    public LinkedListNode reverseList(LinkedListNode head) {
        //iterative version
        if(head == null || head.next == null){
            return head;
        }
        LinkedListNode prev = null;
        LinkedListNode curr = head;
        LinkedListNode next = curr.next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public LinkedListNode mergeTwoLists(LinkedListNode l1, LinkedListNode l2) {
        //  1 -> 2 -> 3 - > 4
        // 2 -> 4 - > 5 -> 6
        LinkedListNode bull = new LinkedListNode(-1);
        LinkedListNode mergedList = bull;
        while(l1!=null && l2!=null){
            if(l1.data <= l2.data){
                mergedList.next = new LinkedListNode(l1.data);
                l1 = l1.next;
            }
            else {
                mergedList.next = new LinkedListNode(l2.data);
                l2 = l2.next;
            }
            mergedList = mergedList.next;
        }
        if(l1!=null)
            mergedList.next = l1;
        if(l2!=null)
            mergedList.next = l2;
        return bull.next;
    }
    /* TreeNode questions*/


    /* isbalanced brute force solution */
    public int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public boolean isBalanced(TreeNode root){
        if(root == null){
            return true;
        }
        int diff = getHeight(root.left) - getHeight(root.right);
        if(Math.abs(diff) >1){
            return false;
        }
        else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    /* isBalanced more optimal version */

    // need to lessen calls to getHeight, so you can actually use getHeight as a means of telling if a tree is balanced
    public int getHeightOpt(TreeNode root){
        if( root == null){
            return 0;
        }
        int leftH = getHeightOpt(root.left);
        if(leftH == -1){
            return -1;
        }
        int rightH = getHeightOpt(root.right);
        if(rightH == -1){
            return -1;
        }
        int heightdiff = rightH - leftH;
        if(Math.abs(heightdiff) > 1){
            return -1;
        } else {
            return Math.max(leftH,rightH) + 1;
        }
    }
    public boolean validateBST(TreeNode root){
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        return validateBST(root,min,max);
    }
    public boolean validateBST(TreeNode root, int min, int max){
        if(root == null){
            return true;
        }
        if(root.data < min || root.data > max){
            return false;
        }
        else {
            return validateBST(root.left, min, root.data) && validateBST(root.right,root.data,max);
        }
    }






















    /* Find Lowest Common Ancestor of a BST */
    public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        if(p == root || q == root){
            return root;
        }
        // check to see if it is on left subtree
        if(root.data < p.data && root.data< q.data){
            return lowestCommonAncestorBST(root.right, p ,q);
        }
        if(root.data > p.data && root.data > q.data)
            return lowestCommonAncestorBST(root.left, p ,q);
        // check to see if it is on right subtree
        if(p.data > q.data){
            if(root.data > q.data && root.data < p.data){
                return root;
            }
        }
        else { // q<p
            if(root.data < q.data && root.data > p.data){
                return root;
            }
        }
        return null;
    }
    /* Find Lowest Common Ancestor of a Binary Tree */
    public TreeNode lowestCommonAncestorBT(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestorBT(root.left,p,q);
        TreeNode right = lowestCommonAncestorBT(root.right,p,q);
        if(left!=null && right!=null){
            return root;
        }
        return left!=null ? left : right;
    }
}
