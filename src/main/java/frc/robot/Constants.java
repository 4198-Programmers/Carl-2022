// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final int FRONT_RIGHT_DEVICE_ID = 3;
    public static final int FRONT_LEFT_DEVICE_ID = 4;
    public static final int BACK_RIGHT_DEVICE_ID = 1;
    public static final int BACK_LEFT_DEVICE_ID = 2;

    public static final double CONVERSION_FACTOR = 1/12.75;

    public static final double LOOP_RAMP_RATE = 0.1;

    public static final double DRIVE_SPEED = 1;

    public static final int LEFT_JOYSTICK_ID = 1;
    public static final int MIDDLE_JOYSTICK_ID = 2;
    public static final int RIGHT_JOYSTICK_ID = 3;

    public static String drive = "Drive";

    public static final double WIDTH_OF_JAKE = 6.88976378;
    public static final double RADIUS_WHEELS = 4.94188591; 
    public static final double JAKE_WHEELS = 2.36220472;
    }

