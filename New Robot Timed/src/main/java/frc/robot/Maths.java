package frc.robot;

public final class Maths {
    
    public static double rotationConversion(double distanceInInches)
    {
        double circumference = (Math.PI*(Constants.WHEEL_DIAMTER));
        double rotations = (distanceInInches/circumference)*Constants.WHEEL_CONVERSION_FACTOR;
        return rotations;
    }
    public static double motorConversion(double distanceForMotors)
    {
        double circumference = (Math.PI*(Constants.MOTOR_DIAMETER));
        double rotations = (distanceForMotors/circumference)*Constants.WHEEL_CONVERSION_FACTOR;
        return rotations;
    }

    public static double distanceFromTarget(double YAngle)
    {
        double D = Constants.TARGET_HEIGHT_TOP_TO_GROUND;
        double h = Constants.LIMELIGHT_HEIGHT_TO_GROUND;
        double LLangle = Constants.LIMELIGHT_ANGLE_FROM_GROUND;
        double totalAngle = Math.tan(Math.toRadians(LLangle + YAngle));

        double distance = (D - h)/(totalAngle);

        return distance;
    }

    public static double flyWheelVelocityByDistance(double Distance)
    {
        return 0;//TODO create equation
    }
    
}
