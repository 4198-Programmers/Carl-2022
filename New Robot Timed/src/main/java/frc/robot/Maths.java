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
        double targetDistance = distance + 48;
        double radiansForLaunch = Math.toRadians(Constants.SHOOTER_LAUNCH_ANGLE);
        double targetVelocityForFlywheel = Math.sqrt((Constants.GRAVITATIONAL_VELOCITY * Math.pow(targetDistance, 2))
                / (2 * (targetDistance * Math.tan(radiansForLaunch
                        - Constants.TARGET_HEIGHT) * (Math.pow(Math.cos(radiansForLaunch), 2))))); // Velocity
        return targetVelocityForFlywheel;
    }

    public static double flywheelMotorVelocityConversion(double targetVelocityForFlywheel) {
        double flywheelTargetSpeed = targetVelocityForFlywheel / Constants.MAX_FLYWHEEL_VELOCITY;
        return flywheelTargetSpeed;
    }

}
