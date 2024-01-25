import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> asteriodsStack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            int value = asteroids[i];
            boolean toBeAdded = true;
            while (!asteriodsStack.isEmpty() && value < 0 && asteriodsStack.peek() > 0) {
                if (Math.abs(value) > Math.abs(asteriodsStack.peek())) {
                    asteriodsStack.pop();
                    continue;
                } else if (Math.abs(value) == Math.abs(asteriodsStack.peek()))
                {
                    asteriodsStack.pop();
                }
                toBeAdded = false;
                break;


            }

            if (toBeAdded) {
                asteriodsStack.push(value);
            }


        }

        // Add the asteroids from the stack to the vector in the reverse order.
        int[] remainingAsteroids = new int[asteriodsStack.size()];
        for (int i = remainingAsteroids.length - 1; i >= 0; i--) {
            remainingAsteroids[i] = asteriodsStack.peek();
            asteriodsStack.pop();
        }

        return remainingAsteroids;

    }
}
