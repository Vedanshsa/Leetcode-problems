class Solution {
    public void moveZeroes(int[] nums) {
        int zeroscount = 0;
        int j=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                zeroscount++;
            }else{
                nums[j] = nums[i];
                j++;
            }
        }
        while(j < nums.length){
            nums[j] = 0;
            j++;
        }
    }
}
