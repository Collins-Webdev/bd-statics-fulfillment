package com.amazon.ata.statics;

// Custom exception for dimension validation
class DimensionValueException extends Exception {
    public DimensionValueException(String message) {
        super(message);
    }
}

public class Box {

    // Constants for maximum allowed dimension
    private static final double MAX_DIMENSION = 72.0;

    // Variables to store the dimensions of the box
    private double length;
    private double width;
    private double height;

    /**
     * Constructs a Box object if the dimensions are valid
     * @param length - length of the box
     * @param width - width of the box
     * @param height - height of the box
     * @throws DimensionValueException if any dimension exceeds the max Box size
     */
    public Box(double length, double width, double height) throws DimensionValueException {
        // Validate the dimensions using the static method
        if (!validateBoxDimensions(length, width, height)) {
            throw new DimensionValueException("One or more dimensions exceed the maximum allowed size of " + MAX_DIMENSION + " inches.");
        }

        // Assign the values if they are valid
        this.length = length;
        this.width = width;
        this.height = height;
    }

    // Getters for the dimensions
    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    /**
     * Validates the dimensions of the box
     * @param length - the length of the box
     * @param width - the width of the box
     * @param height - the height of the box
     * @return true if all dimensions are within the valid range, false otherwise
     */
    public static boolean validateBoxDimensions(double length, double width, double height) {
        return length <= MAX_DIMENSION && width <= MAX_DIMENSION && height <= MAX_DIMENSION;
    }

    public static void main(String[] args) {
        try {
            // Example of a valid box
            Box validBox = new Box(50, 60, 70);
            System.out.println("Valid box created with dimensions: " +
                    "Length: " + validBox.getLength() + ", Width: " + validBox.getWidth() + ", Height: " + validBox.getHeight());

            // Example of an invalid box
            Box invalidBox = new Box(80, 60, 70); // This will throw DimensionValueException
        } catch (DimensionValueException e) {
            System.out.println("Error creating box: " + e.getMessage());
        }
    }
}
