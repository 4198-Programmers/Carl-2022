package frc.robot;

public final class Maths {

    public static double rotationConversion(double distanceInInches) {
        double circumference = (Math.PI * (Constants.WHEEL_DIAMTER));
        double rotations = ((distanceInInches / circumference));
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

    public static double flyWheelVelocityByDistance(double distanceInInches) {
        double targetDistance = (distanceInInches + Constants.TARGET_RADIUS_INCHES) * Constants.INCHES_TO_METERS;
        double radiansForLaunch = Math.toRadians(Constants.SHOOTER_LAUNCH_ANGLE);
        double targetVelocityForFlywheel = Math.sqrt((-0.5 * (Constants.GRAVITATIONAL_VELOCITY) 
        * ((Math.pow(targetDistance / Math.cos(radiansForLaunch), 2)))) 
        / (Constants.TARGET_HEIGHT - Constants.SHOOTER_HEIGHT_TO_GROUND - (targetDistance * Math.tan(radiansForLaunch))));
        System.out.println(targetVelocityForFlywheel);
        return targetVelocityForFlywheel;

    }

    public static double flywheelMotorVelocityConversion(double targetVelocityForFlywheel) {
        double flywheelTargetSpeed = targetVelocityForFlywheel / Constants.MAX_FLYWHEEL_VELOCITY;
        return flywheelTargetSpeed;
    }
    
    public static double flyWheelSpeedByDistance(double Distance) {
        double invTest = -Distance;
        double a = -0.0000535235;
        double b = 0.00766854;
        double c = -0.630631;
        System.out.println("math" + Distance);

        return (((a * (invTest * invTest)) + (b * invTest) + c));
    }

    public static double spinDistanceByDegree(double Degrees) {
        double circleDistance = (Degrees / 360) * Constants.MIDDLE_CIRCLE_CIRCUMFERENCE;
        double wheelCircumference = (Math.PI * (Constants.WHEEL_DIAMTER));
        double totalRotations = ((circleDistance / wheelCircumference));
        return totalRotations;
    }


    
      
    // public static final double INCHES_TO_METERS = 0.0254;
    // public static final double SHOOTER_LAUNCH_ANGLE = 71;
    //  public static final double GRAVITATIONAL_VELOCITY = 9.81; //in meters per second
    //  public static final double TARGET_HEIGHT = 108 * 0.0254; //in meters due to the conversion
    //  public static final double MAX_FLYWHEEL_VELOCITY = 30;
    //  public static final double DISTANCE_TO_TARGET = 324;
    //  public static final double SHOOTER_HEIGHT_TO_GROUND = 24 * INCHES_TO_METERS;
    //  public static final double MAX_FLYWHEEL_SPEED = 1;
    
    //  public static final double TARGET_RADIUS_INCHES = 24;
    //   public static void main(String []args){
        
    //      double targetVelocityForFlywheel = flyWheelVelocityByDistance(DISTANCE_TO_TARGET);
    //      flywheelMotorVelocityConversion(targetVelocityForFlywheel);
    //      System.out.println("VELOCITY");
        
    //   }

    
    //  public static double flyWheelVelocityByDistance(double distanceInInches) {
    //      double targetDistance = (distanceInInches + TARGET_RADIUS_INCHES) * INCHES_TO_METERS;
    //      double radiansForLaunch = Math.toRadians(SHOOTER_LAUNCH_ANGLE);
    //      double targetVelocityForFlywheel = Math.sqrt((-0.5 * (GRAVITATIONAL_VELOCITY) 
    //      * ((Math.pow(targetDistance / Math.cos(radiansForLaunch), 2)))) 
    //      / (TARGET_HEIGHT - SHOOTER_HEIGHT_TO_GROUND - (targetDistance * Math.tan(radiansForLaunch))));
    //      System.out.println(targetVelocityForFlywheel);
    //      return targetVelocityForFlywheel;
    //  }
    
    //  public static double flywheelMotorVelocityConversion(double targetVelocityForFlywheel) {
    //      double flywheelTargetSpeed = targetVelocityForFlywheel / MAX_FLYWHEEL_VELOCITY;
    //      System.out.println(flywheelTargetSpeed);
    //      return flywheelTargetSpeed;
    //  }

}
