package frc.robot;

public final class Maths {

    public static double rotationConversion(double distanceInInches) {
        double circumference = (Math.PI * (Constants.WHEEL_DIAMTER));
        double rotations = (distanceInInches / circumference) * Constants.WHEEL_CONVERSION_FACTOR;
        return rotations;
    }

    public static double motorConversion(double distanceForMotors) {
        double circumference = (Math.PI * (Constants.MOTOR_DIAMETER));
        double rotations = (distanceForMotors / circumference) * Constants.WHEEL_CONVERSION_FACTOR;
        return rotations;
    }

    public static double distanceFromTarget(double YAngle) {
        double D = Constants.TARGET_HEIGHT_TOP_TO_GROUND;
        double h = Constants.LIMELIGHT_HEIGHT_TO_GROUND;
        double LLangle = Constants.LIMELIGHT_ANGLE_FROM_GROUND;
        double totalAngle = Math.tan(Math.toRadians(LLangle + YAngle));

        double distance = (D - h) / (totalAngle);

        return distance;
    }

    public static double flyWheelVelocityByDistance(double distance) {
        double targetDistance = distance + 24;
        double radiansForLaunch = Math.toRadians(Constants.SHOOTER_LAUNCH_ANGLE);
        double radiansForLaunchSquared = Math.pow(Math.cos(radiansForLaunch), 2);
        double velocityEquationDivisor = (2 * ((targetDistance * Math.tan(radiansForLaunch)) - Constants.TARGET_HEIGHT) * radiansForLaunchSquared);
        double velocityEquationNumerator = (Constants.GRAVITATIONAL_VELOCITY * Math.pow(targetDistance, 2));
        double targetVelocityForFlywheel = Math.sqrt(velocityEquationDivisor / velocityEquationNumerator); // Velocity
        System.out.println(targetVelocityForFlywheel);
        return targetVelocityForFlywheel;

    }

    public static double flywheelMotorVelocityConversion(double targetVelocityForFlywheel) {
        double flywheelTargetSpeed = targetVelocityForFlywheel / Constants.MAX_FLYWHEEL_VELOCITY;
        return flywheelTargetSpeed;
    }

    public static final double SHOOTER_LAUNCH_ANGLE = 45;
    public static final double GRAVITATIONAL_VELOCITY = -9.81; //in meters per second
    public static final double TARGET_HEIGHT = 2.6416; //in meters
    public static final double MAX_FLYWHEEL_VELOCITY = 5;
    
     public static double flyWheelVelocityByDistanceTest(double distance) {
        double targetDistance = distance + .6096;
        double radiansForLaunch = Math.toRadians(SHOOTER_LAUNCH_ANGLE);
        double radiansForLaunchSquared = Math.pow(Math.cos(radiansForLaunch), 2);
        double velocityEquationDivisor = (2 * ((targetDistance * Math.tan(radiansForLaunch)) - TARGET_HEIGHT) * radiansForLaunchSquared);
        double velocityEquationNumerator = (GRAVITATIONAL_VELOCITY * Math.pow(targetDistance, 2));
        double targetVelocityForFlywheel = velocityEquationDivisor / velocityEquationNumerator; // Velocity
        return targetVelocityForFlywheel;

    }

}
