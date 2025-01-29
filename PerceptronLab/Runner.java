package ie.atu.sw;

public class Runner {
    public static void main(String[] args) {
        // Input data for logical operations (AND/OR)
        float[][] data = {
            {0.0f, 0.0f},
            {1.0f, 0.0f},
            {0.0f, 1.0f},
            {1.0f, 1.0f}
        };

        // Expected outputs for logical AND operation
        float[] expected = {0.0f, 0.0f, 0.0f, 1.0f};

        // Create and train the perceptron for the AND operation
        var p = new Perceptron(2); // 2 inputs
        p.train(data, expected, 10000); // Train with max 10,000 epochs

        // Test the perceptron for the AND operation
        for (int row = 0; row < data.length; row++) {
            int result = p.activate(data[row]); // Activate the perceptron for each input
            System.out.println("Result " + row + ": " + result); // Print the output
        }

        // Expected outputs for logical OR operation
        System.out.println("\nLogical OR:");
        expected = new float[]{0.0f, 1.0f, 1.0f, 1.0f};

        // Train the perceptron for the OR operation
        p.train(data, expected, 10000);

        // Test the perceptron for the OR operation
        for (int row = 0; row < data.length; row++) {
            int result = p.activate(data[row]); // Activate the perceptron for each input
            System.out.println("Result " + row + ": " + result); // Print the output
        }
    }
}

