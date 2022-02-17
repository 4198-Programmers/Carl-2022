package frc.robot;

public class Maths {
    public static double rotationConversion(double distanceInInches) {
        double circumference = (Math.PI * (Constants.JAKE_WHEELS));
        double rotations = (distanceInInches / circumference);
        return rotations;
    }

}
