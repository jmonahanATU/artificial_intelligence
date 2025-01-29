package ie.atu.sw;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

// Perceptron class: Implements a basic single-layer perceptron
public class Perceptron {
    private float[] weights; // Array to hold the weights for the inputs
    private float theta = 0.2f; // Threshold value for activation

    // Constructor: Initializes the perceptron with random weights
    public Perceptron(int connection) {
        weights = new float[connection];
        var rand = ThreadLocalRandom.current();
        for (int i = 0; i < weights.length; i++) {
            weights[i] = rand.nextFloat(-1.0f, 1.0f); // Random weights between -1 and 1
        }
        System.out.println(this); // Print initial weights
    }

    // Getter for weights (optional, for debugging or external use)
    public float[] getWeights() {
        return weights;
    }

    // Activation function: Calculates the weighted sum and applies the threshold
    public int activate(float[] inputs) {
        float sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += inputs[i] * weights[i]; // Weighted sum of inputs
        }
        return sum >= theta ? 1 : 0; // Apply threshold to determine output
    }

    // Training function: Trains the perceptron using the perceptron learning rule
    public void train(float[][] data, float[] expected, int max_epochs) {
        float alpha = 0.1f; // Learning rate
        for (int epoch = 0; epoch < max_epochs; epoch++) {
            int errorCount = 0; // Track the number of errors in each epoch
            for (int i = 0; i < data.length; i++) {
                int result = activate(data[i]); // Compute the perceptron output
                float error = expected[i] - result; // Calculate error
                if (error != 0) {
                    errorCount++; // Increment error count if there's a mismatch
                    for (int j = 0; j < weights.length; j++) {
                        weights[j] += alpha * error * data[i][j]; // Update weights
                    }
                }
            }
            // Stop training early if there are no errors
            if (errorCount == 0) {
                System.out.println("Training complete in " + (epoch + 1) + " epochs.");
                break;
            }
        }
        System.out.println(this); // Print final weights after training
    }

    // toString method: Returns a string representation of the perceptron's weights
    @Override
    public String toString() {
        return "Perceptron [weights=" + Arrays.toString(weights) + "]";
    }
}
