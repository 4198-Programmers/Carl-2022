// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    // motor insersion locations definitely
    public static final byte FRONT_LEFT_INSERTION_THINGY = 3;
    public static final byte FRONT_RIGHT_INSERTION_THINGY = 4;
    public static final byte BACK_LEFT_INSERTION_THINGY = 1;
    public static final byte BACK_RIGHT_INSERTION_THINGY = 2;

    // joystick insersion locations
    public static final byte LEFT_JOYSTICK_ID = 0;
    public static final byte MID_JOYSTICK_ID = 1;
    public static final byte RIGHT_JOYSTICK_ID = 2;

    // motor crisis
    public static final double WHEEL_CONVERSION_FACTOR = 1/12.75;
    public static final double WHEEL_DIAMETER = 5.875;
    public static final double WHEEL_SPEED = 0.75;

    // joysticks

    // button bindings
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
    // public static final byte LIMELIGHT_OFF_BUTTON = 11;
    // public static final byte LIMELIGHT_ON_BUTTON = 12;

    // public static final byte RIGHT_STICK_TRIGGER = 1;
    // public static final byte HUMAN_OVERRIDE_BUTTON = 2;
    // public static final byte FLYWHEEL_BUTTON = 3; //button when override active
    // public static final byte TARGETING_LIMELIGHT_SIMULTANEOUS = 3;
    // public static final byte INTAKEIN_BUTTON = 4;
    // public static final byte YEET_THE_BALLS_OUT_THE_BACK_BUTTON = 5;
    public static final byte RESET = 6;
    public static final byte ROTATE_AUTO_BUTTON_ID = 7;
    public static final byte FORWARD_AUTO_BUTTON_ID = 8;
    // public static final byte LIMELIGHT_TARGETING_BUTTON = 8;
    public static final byte AUTO_STOP_BUTTON_ID = 9;
    // public static final byte VERT_HOOK_DOWN_BUTTON = 10;
    // public static final byte VERT_HOOK_UP_BUTTON = 11;
    // // public static final byte leftbuttoneleven = 12;
    // public static final double VERT_HOOK_DISTANCE_DOWN = -0;
    // public static final double ANGLED_HOOK_DEGREES_DOWN = -0;

}
