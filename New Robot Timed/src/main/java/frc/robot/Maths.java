package frc.robot;
import frc.robot.Constants;
public final class Maths {

    public static double rotationConversion(double distanceInInches) {
        double circumference = (Math.PI * (Constants.WHEEL_DIAMTER));
        double rotations = (distanceInInches / circumference) * Constants.WHEEL_CONVERSION_FACTOR;
        return rotations;
    }
    public static double motorConversion(double distanceForMotors)
    {
        double circumference = (Math.PI*(Constants.MOTOR_DIAMETER));
        double rotations = (distanceForMotors/circumference)*Constants.WHEEL_CONVERSION_FACTOR;
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
    
    public static double flyWheelVelocityByDistance(double Distance) {
        /*  u = initial velocity
            u = +,- sqr root((gx²)/2(xtan(Θ)-y)(cos²Θ))

        */
        // double u_x = u(Math.cos(Constants.ANGLE_DEGREES));
        double time = distance/(u(Math.cos(Constants.ANGLE_DEGREES)));
        // double (u(Math.cos(Constants.ANGLE_DEGREES))) = distance/time
        double u = Math.sqrt((Constants.GRAVITATIONAL_VELOCITY*Math.pow(time, 2))/(2*(time*Math.tan(Math.toRadians(Constants.ANGLE_DEGREES)
         - Constants.TARGET_HEIGHT)*(cos(Math.toRadians(Constants.ANGLE_DEGREES))^2))));
        return u;// TODO create equation
    }

}
