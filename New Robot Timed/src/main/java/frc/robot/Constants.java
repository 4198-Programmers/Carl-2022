package frc.robot;

public class Constants {
    // all caps are established constants, all lowercase need an assignment
    // -0 means it has a numerical value to be assigned to it, normal 0 is meant to
    // be there
    //TODO set values
    public static final byte FRONT_RIGHT_MOTOR_DEVICE_ID = 3;
    public static final byte FRONT_LEFT_MOTOR_DEVICE_ID = 4;
    public static final byte BACK_LEFT_MOTOR_DEVICE_ID = 2;
    public static final byte BACK_RIGHT_MOTOR_DEVICE_ID = 1;
    public static final byte FLY_WHEEL_MOTOR_DEVICE_ID = 5;
    public static final byte BALL_MOVER_MOTOR_DEVICE_ID = 6;
    public static final byte VERT_HOOKS_MOTOR_DEVICE_ID = 7;
    public static final byte ANGLE_HOOKS_MOTOR_DEVICE_ID = 8;
    public static final byte INTAKE_MOTOR_DEVICE_ID = 9;

    public static final byte LEFT_STICK_PORT = 0;
    public static final byte MID_STICK_PORT = 1;
    public static final byte RIGHT_STICK_PORT = 2;

    public static final int DEFAULT_AUTO = 0;
    /** Wheel velocity = 0 */
    public static final double FREEZE = 0;
    public static final double WHEEL_DIAMTER = 6;
    public static final double ANGLE_HOOK_DEGREES = -0;


    public static final double WHEEL_CONVERSION_FACTOR = 12.75;
    public static final double MOTOR_DIAMETER = -0;
    public static final double DISTANCE_UP = -0;

    public static final double VERT_HOOK_SPEED = 0.5;
    public static final double ANGLE_HOOK_SPEED = 0.5;
    public static final double INTAKE_SPEED = 0.5;
    public static final double FLYWHEEL_SPEED = 0.5;
    public static final double INTERNAL_FEEDER_SPEED = 0.5;
    public static final double INTAKE_REVERSE_SPEED = 0.5;
    public static final double INTERNAL_FEEDER_REVERSE_SPEED = 0.5;
    public static final double DRIVE_SPEED_MULTIPLIER = 1;

    //distance variables
    public static final double LIMELIGHT_ANGLE_FROM_GROUND = 1;
    public static final double LIMELIGHT_HEIGHT_TO_GROUND = 1; 
    public static final double TARGET_HEIGHT_TOP_TO_GROUND = 1;

    //other
    public static final double OFFSET_TOLERANCE_INCHES = 2.3; //todo Goal is for this to be measure with inches
    public static final double LIMELIGHT_OFF_PIPELINE_MODE = 0;
    public static final double LIMELIGHT_FULL_ON_PIPELINE_MODE = 1;

    //velocity constants
    public static final double SHOOTER_LAUNCH_ANGLE = -0;
    public static final double GRAVITATIONAL_VELOCITY = 9.81; //in meters per second
    public static final double TARGET_HEIGHT = 108; //in inches
    public static final double MAX_FLYWHEEL_VELOCITY = -0;

    // public static final byte leftbuttonone = 1;
    // public static final byte leftbuttontwo = 2;
    // public static final byte leftbuttonthree = 3;
    // public static final byte leftbuttonfour = 4;
    // public static final byte leftbuttonfive = 5;
    // public static final byte leftbuttonsix = 6;
    // public static final byte leftbuttonseven = 7;
    // public static final byte leftbuttoneight = 8;
    // public static final byte leftbuttonnine = 9;
    // public static final byte leftbuttonten = 10;
    // public static final byte leftbuttoneleven = 11;
    // public static final byte button = 12;


    // public static final byte leftbuttonone = 1;
    // public static final byte leftbuttontwo = 2;
    // public static final byte leftbuttonthree = 3;
    // public static final byte leftbuttonfour = 4;
    // public static final byte leftbuttonfive = 5;
    // public static final byte leftbuttonsix = 6;
    // public static final byte leftbuttonseven = 7;
    // public static final byte leftbuttoneight = 8;
    // public static final byte leftbuttonnine = 9;
    // public static final byte leftbuttonten = 10;
    public static final byte LIMELIGHT_OFF_BUTTON = 11;
    public static final byte LIMELIGHT_ON_BUTTON = 12;

    public static final byte RIGHT_STICK_TRIGGER = 1;
    public static final byte HUMAN_OVERRIDE_BUTTON = 2;
    public static final byte FLYWHEEL_BUTTON = 3; //button when override active
    public static final byte TARGETING_LIMELIGHT_SIMULTANEOUS = 3;
    public static final byte INTAKEIN_BUTTON = 4;
    public static final byte YEET_THE_BALLS_OUT_THE_BACK_BUTTON = 5;
    public static final byte ANGLE_HOOK_UP_BUTTON = 6;
    public static final byte ANGLE_HOOK_DOWN_BUTTON = 7;
    public static final byte INTERNAL_MOVER_FORWARDS_BUTTON = 8; //button when override is active
    public static final byte LIMELIGHT_TARGETING_BUTTON = 8;
    //public static final byte no = 9;
    public static final byte VERT_HOOK_DOWN_BUTTON = 10;
    public static final byte VERT_HOOK_UP_BUTTON = 11;
    // public static final byte leftbuttoneleven = 12;
    public static final double VERT_HOOK_DISTANCE_DOWN = -0;
    public static final double ANGLED_HOOK_DEGREES_DOWN = -0;

}
