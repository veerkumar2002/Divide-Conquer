public class question2a {
    private static int countInRange(int[] nums, int num, int lower,int higher){
        int count = 0;
        for(int i= lower; i<=higher; i++){
            if(nums[i] == num){
                count++;
            }
        }
        return count;
    }
    private static int majorityElementRec(int[] nums, int lower,int higher){
        //base case; the only element in an array of size 1 is the majority
        //element
        if(lower == higher){
            return nums[lower];
        }
        //recurse on left and right halves of this slice
        int mid = (higher - lower)/2 + lower;
        int left = majorityElementRec(nums, lower, mid);
        int right = majorityElementRec(nums, mid+1, higher);

        //if the two halves agree on the majority element , return it.
        if(left == right){
            return left;
        }

        //otherwise, count each element and return the "winner"
        int leftCount = countInRange(nums, left, lower, higher);
        int rightCount = countInRange(nums, right, lower, higher);
        return leftCount > rightCount ? left : right;
    }
    public static void main(String args[]){
        int nums[] = {2,2,1,1,1,2,2};
        System.out.println(majorityElementRec( nums, lower, higher));
    }
}
