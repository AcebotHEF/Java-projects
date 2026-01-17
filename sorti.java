public class sorti {
    public static void main(String[] args){
        int nums[] = {75,20,33,14,5,10,101};
        int size = nums.length;
        int temp1 = 0;
        int minIndex = -1;

        // to get the element in the array before sorting
        System.out.println("Before sorting");
        for(int num : nums){
            System.out.print(num + " ");
        }

        // Nested for-loop for the sorting 
        for(int i = 0; i<size-1; i++){
            minIndex = i;

            // inner part of sorting picking one element and comparing it with the other ones
            for (int j = i+1 ;j<size; j++){
                if(nums[minIndex] > nums[j])
                    minIndex = j;
            }

            temp1 = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp1;
            
            System.out.println();

            for(int num : nums){
                System.out.print(num + " ");
            }

        }
        System.out.println(" ");

        System.out.println("After sorting");
        for(int num : nums){
            System.out.print(num + " ");
        }

    }
}
