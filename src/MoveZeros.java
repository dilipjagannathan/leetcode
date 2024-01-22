import java.util.Arrays;

public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int lastNonZeroCounter = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroCounter++] = nums[i];
            }
        }

        for (int i = lastNonZeroCounter; i < nums.length; i++) {
            nums[i] = 0;
        }

    }

    public static void main(String[] args) {
        MoveZeros moveZeros = new MoveZeros();
        int[] values = {0,1,0,3,12};
        moveZeros.moveZeroes(values);
        System.out.println(Arrays.toString(values));
    }
}
