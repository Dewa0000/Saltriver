package com.Saltriver;


		import java.util.ArrayList;
        import java.util.List;

		public class CoordinateLine {

		    public static void main(String[] args) {
		        // Example coordinates (latitude, longitude)
		        double[] coordinate1 = {40.7128, -74.0060}; // Example coordinates for New York City
		        double[] coordinate2 = {34.0522, -118.2437}; // Example coordinates for Los Angeles

		        List<double[]> routePoints = calculatePointsBetweenCoordinates(coordinate1, coordinate2);

		        // Display the generated points
		        for (double[] point : routePoints) {
		            System.out.println("Latitude: " + point[0] + ", Longitude: " + point[1]);
		        }
		    }

		    public static List<double[]> calculatePointsBetweenCoordinates(double[] coord1, double[] coord2) {
		        // Calculate the distance between the given coordinates
		        double totalDistance = calculateDistance(coord1[0], coord1[1], coord2[0], coord2[1]);
		        System.out.println("Total distance between coordinates: " + totalDistance + " meters");

		        // Generate points at 25-meter intervals
		        double interval = 25.0; // Interval distance in meters
		        int numSegments = (int) (totalDistance / interval);

		        List<double[]> points = new ArrayList<>();
		        for (int i = 0; i <= numSegments; i++) {
		            double fraction = (double) i / numSegments;
		            double newLatitude = coord1[0] + (coord2[0] - coord1[0]) * fraction;
		            double newLongitude = coord1[1] + (coord2[1] - coord1[1]) * fraction;
		            points.add(new double[]{newLatitude, newLongitude});
		        }

		        return points;
		    }

		    // Calculate distance between two coordinates using Haversine formula
		    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
		        double R = 6371000; // Earth radius in meters

		        double latDistance = Math.toRadians(lat2 - lat1);
		        double lonDistance = Math.toRadians(lon2 - lon1);

		        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
		                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
		                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

		        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		        return R * c;
		    }
		}


