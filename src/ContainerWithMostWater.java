public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxarea = 0;
        while (left < right) {
            int width = right - left;
            maxarea = Math.max(maxarea, width * (Math.min(height[left], height[right])));

            if (height[left]<= height[right]) {
                left++;
            } else {
                right--;
            }

        }
        return maxarea;

    }
}
