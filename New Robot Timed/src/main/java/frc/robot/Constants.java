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
    public static final double LIMELIGHT_ANGLE_FROM_GROUND = 65;
    public static final double LIMELIGHT_HEIGHT_TO_GROUND = 25;
    public static final double TARGET_HEIGHT_TOP_TO_GROUND = 104;

    // other
    public static final double WIDE_OFFSET_TOLERANCE = 3.75;
    public static final double SLIM_OFFSET_TOLERANCE = 3;
    public static final double LIMELIGHT_OFF_PIPELINE_MODE = 0;
    public static final double LIMELIGHT_FULL_ON_PIPELINE_MODE = 1;
    public static final double WHEEL_DIAMTER = 5.875;
    public static final double WHEEL_CONVERSION_FACTOR = 12.75;
    public static final double MIDDLE_CIRCLE_CIRCUMFERENCE = (Math.PI) * 23.5; // 23.5 inches is distance between sheels

    // left joystick buttons
    public static final byte HUMAN_OVERRIDE_LBUTTON = 11;

    // middle stick buttons
    public static final byte TARGETING_LIMELIGHT_SIMULTANEOUSM = 1;
    public static final byte VERTICAL_HOOK_BUTTON = 2;
    public static final byte LIMELIGHT_OFF_MBUTTON = 11;
    public static final byte LIMELIGHT_ON_MBUTTON = 12;

    // right stick buttons
    public static final byte FLYWHEEL_RBUTTON = 1;
    public static final byte ANGLED_BUTTON = 2;
    public static final byte INTERNAL_MOVER_BACKWARDS_RBUTTON = 3;
    public static final byte FORCE_SPIT_RBUTTON = 4;
    public static final byte INTERNAL_MOVER_FORWARDS_RBUTTON = 5;
    public static final byte INTAKE_IN_RBUTTON = 7;
    public static final byte INTAKE_OUT_RBUTTON = 8;
    public static final byte ANGLE_HOOK_UP_RBUTTON = 11;
    public static final byte ANGLE_HOOK_DOWN_RBUTTON = 12;
    public static final byte VERT_HOOK_DOWN_RBUTTON = 9;
    public static final byte VERT_HOOK_UP_RBUTTON = 10;

    
    public static final double ANGLED_HOOK_UPPER_LIMIT = 250;
    public static final double ANGLED_HOOK_LOWER_LIMIT = 16;
    public static final double VERTICAL_HOOK_UPPER_LIMIT = 250;
    public static final double VERTICAL_HOOK_LOWER_LIMIT = -5;
    public static final double VERTICAL_HOOK_SPEED = 1;

}