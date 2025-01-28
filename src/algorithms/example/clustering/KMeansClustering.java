package algorithms.example.clustering;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// K-Means clustering implementation
public class KMeansClustering {

    // Data point class
    static class Point {//https://www.youtube.com/watch?v=4b5d3muPQmA good explanation 6:27
        double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        double distance(Point other) {
            return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
        }

        @Override
        public String toString() {
            return String.format("(%.2f, %.2f)", x, y);
        }
    }

    public static void main(String[] args) {
        // Example dataset
        List<Point> dataPoints = List.of(
                new Point(1.0, 2.0), new Point(1.5, 1.8), new Point(5.0, 8.0),
                new Point(8.0, 8.0), new Point(1.0, 0.6), new Point(9.0, 11.0),
                new Point(8.0, 2.0), new Point(10.0, 2.0), new Point(9.0, 3.0)
        );

        int k = 3; // Number of clusters
        int maxIterations = 100; // Max iterations

        List<Point> centroids = initializeCentroids(dataPoints, k);
        System.out.println("Initial Centroids: " + centroids);

        for (int iteration = 1; iteration <= maxIterations; iteration++) {
            System.out.println("\nIteration: " + iteration);

            // Assign points to the nearest centroid
            List<List<Point>> clusters = assignClusters(dataPoints, centroids);

            // Log cluster assignments
            for (int i = 0; i < clusters.size(); i++) {
                System.out.println("Cluster " + (i + 1) + ": " + clusters.get(i));
            }

            // Recalculate centroids
            List<Point> newCentroids = recalculateCentroids(clusters);

            System.out.println("New Centroids: " + newCentroids);

            // Check for convergence
            if (centroids.equals(newCentroids)) {
                System.out.println("\nConverged after " + iteration + " iterations.");
                break;
            }

            centroids = newCentroids;
        }

        System.out.println("\nFinal Centroids: " + centroids);
    }

    // Initialize centroids randomly
    private static List<Point> initializeCentroids(List<Point> dataPoints, int k) {
        Random random = new Random();
        List<Point> centroids = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            centroids.add(dataPoints.get(random.nextInt(dataPoints.size())));
        }
        return centroids;
    }

    // Assign data points to the nearest centroid
    private static List<List<Point>> assignClusters(List<Point> dataPoints, List<Point> centroids) {
        List<List<Point>> clusters = new ArrayList<>();
        for (int i = 0; i < centroids.size(); i++) {
            clusters.add(new ArrayList<>());
        }
        for (Point point : dataPoints) {
            int nearestIndex = 0;
            double nearestDistance = point.distance(centroids.get(0));
            for (int i = 1; i < centroids.size(); i++) {
                double distance = point.distance(centroids.get(i));
                if (distance < nearestDistance) {
                    nearestDistance = distance;
                    nearestIndex = i;
                }
            }
            clusters.get(nearestIndex).add(point);
        }
        return clusters;
    }

    // Recalculate centroids based on cluster assignments
    private static List<Point> recalculateCentroids(List<List<Point>> clusters) {
        List<Point> newCentroids = new ArrayList<>();
        for (List<Point> cluster : clusters) {
            if (cluster.isEmpty()) continue; // Avoid division by zero
            double sumX = 0, sumY = 0;
            for (Point point : cluster) {
                sumX += point.x;
                sumY += point.y;
            }
            newCentroids.add(new Point(sumX / cluster.size(), sumY / cluster.size()));
        }
        return newCentroids;
    }
}

/**
 * Pros:
 * - Simple and easy to implement.
 * - Works well for smaller datasets and low-dimensional spaces.
 * - Fast for a small number of clusters.
 *
 * Cons:
 * - Sensitive to the initial choice of centroids; might converge to local optima.
 * - Requires the number of clusters (k) to be specified in advance.
 * - Not suitable for non-convex or varying density clusters.
 * - Computationally expensive for large datasets.
 *
 * Time Complexity: O(n * k * t), where n is the number of data points, k is the number of clusters, and t is the number of iterations.
 * Space Complexity: O(n + k), for storing cluster assignments and centroids.
 *
 * Use Cases:
 * - Image compression (e.g., color quantization).
 * - Customer segmentation in marketing.
 * - Document clustering for text analysis.
 * - Anomaly detection in data streams.
 */

