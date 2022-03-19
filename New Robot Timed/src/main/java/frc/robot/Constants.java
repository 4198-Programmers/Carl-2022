package frc.robot;

public class Constants {
    // all caps are established constants, all lowercase need an assignment
    // -0 means it has a numerical value to be assigned to it, normal 0 is meant to
    // be there
    // TODO set values
    public static final byte FRONT_RIGHT_MOTOR_DEVICE_ID = 10;
    public static final byte FRONT_LEFT_MOTOR_DEVICE_ID = 1;
    public static final byte BACK_LEFT_MOTOR_DEVICE_ID = 2;
    public static final byte BACK_RIGHT_MOTOR_DEVICE_ID = 9;
    public static final byte FLY_WHEEL_MOTOR_DEVICE_ID = 3;
    public static final byte BALL_MOVER_MOTOR_DEVICE_ID = 7;
    public static final byte VERT_HOOKS_OG_MOTOR_DEVICE_ID = 8;
    public static final byte ANGLE_HOOKS_MOTOR_DEVICE_ID = 5;
    public static final byte INTAKE_MOTOR_DEVICE_ID = 4;
    public static final byte VERT_HOOKS_FOLLOWER_MOTOR_DEVICE_ID = 6;

    public static final byte BALL_IN_SENSOR_PORT = 1;
    public static final byte BALL_OUT_SENSOR_PORT = 0;

    public static final byte LEFT_STICK_PORT = 0;
    public static final byte MID_STICK_PORT = 1;
    public static final byte RIGHT_STICK_PORT = 2;

    public static final double VERT_HOOK_SPEED = 0.5;
    public static final double ANGLE_HOOK_SPEED = 0.5;
    public static final double INTAKE_FORWARD_SPEED = -1;
    public static final double FLYWHEEL_SPEED = 1;
    public static final double INTERNAL_FEEDER_SPEED = 0.75;
    public static final double INTAKE_REVERSE_SPEED = 1;
    public static final double INTERNAL_FEEDER_REVERSE_SPEED = -0.75;
    public static final double DRIVE_SPEED_MULTIPLIER = 1;
    /** Wheel velocity = 0 */
    public static final double FREEZE = 0;

    // distance variables
    public static final double LIMELIGHT_ANGLE_FROM_GROUND = 28.25;
    public static final double LIMELIGHT_HEIGHT_TO_GROUND = 25;
    public static final double TARGET_HEIGHT_TOP_TO_GROUND = 104;

    // other
    public static final double WIDE_OFFSET_TOLERANCE = 3.75;
    public static final double MID_OFFSET_TOLERANCE = 2.75;
    public static final double SLIM_OFFSET_TOLERANCE = 1;
    public static final double LIMELIGHT_OFF_PIPELINE_MODE = 0;
    public static final double LIMELIGHT_FULL_ON_PIPELINE_MODE = 1;
    public static final double WHEEL_DIAMTER = 5.875;
    public static final double WHEEL_CONVERSION_FACTOR = 12.75;
    public static final double MIDDLE_CIRCLE_CIRCUMFERENCE = (Math.PI) * 23.5; // 23.5 inches is distance between sheels

    //velocity constants
    public static final double SHOOTER_LAUNCH_ANGLE = 70.5;
    public static final double GRAVITATIONAL_VELOCITY = 9.81; //in meters per second
    
    public static final double MAX_FLYWHEEL_VELOCITY = 10;
    public static final double MAX_FLYWHEEL_SPEED = 1;
    public static final double INCHES_TO_METERS = 0.0254;
    public static final double TARGET_HEIGHT = 108 * INCHES_TO_METERS; //in meters due to the conversion
    public static final double TARGET_RADIUS_INCHES = 24;
    public static final double SHOOTER_HEIGHT_TO_GROUND = 23.5 * INCHES_TO_METERS;

    // public static final byte leftbuttonone = 1;
    // public static final byte leftbuttontwo = 2;
    // public static final byte leftbuttonthree = 3;
    // public static final byte leftbuttonfour = 4;
    // public static final byte leftbuttonfive = 5;
    // left joystick buttons

    // public static final byte leftbuttonthree = 4;
    // public static final byte leftbuttonfour = 5;
    // public static final byte leftbuttonsix = 6;
    // public static final byte BALL_STATUS_BUTTON = 7;
    // public static final byte leftbuttoneight = 8;
    // public static final byte leftbuttonnine = 9;
    // public static final byte leftbuttonten = 10;
    //public static final byte HUMAN_OVERRIDE_BUTTON = 11;
    public static final byte CRUEL_BUTTON = 12;

    // middle stick buttons
    public static final byte TARGETING_LIMELIGHT_SIMULTANEOUS = 1;
    // public static final byte leftbuttonone = 1;
    // public static final byte leftbuttontwo = 2;
    // public static final byte leftbuttonthree = 3;
    // public static final byte leftbuttonfour = 4;
    // public static final byte leftbuttonfive = 5;
    // public static final byte leftbuttonsix = 6;
    // public static final byte leftbuttonseven = 7;
    // public static final byte leftbuttoneight = 8;
    // public static final byte leftbuttonnine = 9;
    public static final byte FLYWHEEL_VELOCITY_TEST_BUTTON = 10;
    public static final byte LIMELIGHT_OFF_BUTTON = 11;
    public static final byte LIMELIGHT_ON_BUTTON = 12;

    public static final byte RIGHT_STICK_TRIGGER = 1;
    public static final byte FLYWHEEL_VELOCITY_EQUATION_BUTTON = 1; //button when override is active
    public static final byte HUMAN_OVERRIDE_BUTTON = 2;
    public static final byte INTAKEIN_BUTTON = 4;
    public static final byte YEET_THE_BALLS_OUT_THE_BACK_BUTTON = 5;
    public static final byte ANGLE_HOOK_UP_BUTTON = 6;
    public static final byte ANGLE_HOOK_DOWN_BUTTON = 7;
    public static final byte LIMELIGHT_TARGETING_BUTTON = 8;
    //public static final byte no = 9;
    public static final byte VERT_HOOK_DOWN_BUTTON = 10;
    public static final byte VERT_HOOK_UP_BUTTON = 11;
    // public static final byte leftbuttoneleven = 12;
    public static final double VERT_HOOK_DISTANCE_DOWN = -0;
    public static final double ANGLED_HOOK_DEGREES_DOWN = -0;
    // start of mostly right stick buttons
    public static final byte FLYWHEEL_BUTTON = 1;
    public static final byte QUOTE_AUTO_UNQUOTE_SHOOTING_BUTTON = 2;
    public static final byte INTERNAL_MOVER_BACKWARDS_BUTTON = 3;
    public static final byte FORCE_SPIT_BUTTON = 4;
    public static final byte INTERNAL_MOVER_FORWARDS_BUTTON = 5;
    public static final byte ANGLE_JOYSTICK_BUTTON = 6;
    public static final byte INTAKE_IN_BUTTON = 7;
    public static final byte INTAKE_OUT_BUTTON = 8;
    //public static final byte ANGLE_HOOK_UP_BUTTON = 11;
    //public static final byte ANGLE_HOOK_DOWN_BUTTON = 12;
    //public static final byte VERT_HOOK_DOWN_BUTTON = 9;
    //public static final byte VERT_HOOK_UP_BUTTON = 10;

}
