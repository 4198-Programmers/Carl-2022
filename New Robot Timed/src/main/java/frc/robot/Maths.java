package frc.robot;

public class Maths {


    public static double rotationConversion(double distanceInInches){
        double circumference = (Math.PI * (Constants.WHEEL_DIAMETER));
        double rotations = (distanceInInches / circumference) * Constants.WHEEL_CONVERSION_FACTOR;
        return rotations;
    }
}
