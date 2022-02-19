// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ChooseLimelightLedMode;
import frc.robot.commands.Drive;
import frc.robot.commands.FeederMotor;
import frc.robot.commands.OffTarmac;
import frc.robot.commands.ResetDriveTrainPosition;
import frc.robot.commands.SetInternalMoveSpeed;
import frc.robot.commands.SpinUpFlyWheel;
import frc.robot.commands.Targeting;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Limelight.LedMode;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  Command m_autonomousCommand;
  Shooter shooter = new Shooter();
  SpinUpFlyWheel spinUpFlyWheel =  new SpinUpFlyWheel(shooter);
  SetInternalMoveSpeed setInternalMoveSpeed = new SetInternalMoveSpeed(shooter);
  FeederMotor feederMotor = new FeederMotor(shooter);
  DriveTrain vroomVroom = new DriveTrain();
  Limelight vision = new Limelight();
  Joystick leftStick = new Joystick(Constants.LEFT_STICK_PORT);
  Joystick midStick = new Joystick(Constants.MID_STICK_PORT);
  Joystick rightStick = new Joystick(Constants.RIGHT_STICK_PORT);
  ResetDriveTrainPosition resetDriveTrainPositionAuto = new ResetDriveTrainPosition(vroomVroom);
  OffTarmac offTarmacAuto = new OffTarmac(vroomVroom);
  Targeting targeting = new Targeting(vroomVroom, vision);
  Targeting targetingS = new Targeting(vroomVroom, vision);
  Command shoot = targetingS.alongWith(spinUpFlyWheel).andThen(setInternalMoveSpeed);
  ChooseLimelightLedMode turnLimelightLedModeOn = new ChooseLimelightLedMode(vision, LedMode.forceOn);
  ChooseLimelightLedMode turnLimelightLedModeOff = new ChooseLimelightLedMode(vision, LedMode.forceOff);
  ChooseLimelightLedMode AnnoyanceMode = new ChooseLimelightLedMode(vision, LedMode.forceBlink);


  //Drive drive = new Drive(leftStick.getRawAxis(1), midStick.getRawAxis(0), vroomVroom);
  ResetDriveTrainPosition resetDriveTrainPosition = new ResetDriveTrainPosition(vroomVroom);
  //Command move = resetDriveTrainPosition.andThen(drive);
  JoystickButton turnLimelightOnButton = new JoystickButton(rightStick, Constants.TURN_LIMELIGHT_ON_BUTTON);
  JoystickButton turnLimelightOffButton = new JoystickButton(rightStick, Constants.TURN_LIMELIGHT_OFF_BUTTON);
  JoystickButton targetTheHoop = new JoystickButton(midStick, Constants.TARGET_BUTTON);
  JoystickButton turnLimeLightOnButton = new JoystickButton(rightStick, Constants.TURN_LIMELIGHT_ON_BUTTON);
  JoystickButton turnLimeLightOffButton = new JoystickButton(rightStick, Constants.TURN_LIMELIGHT_OFF_BUTTON);
  JoystickButton turnOnAnnoyanceModeButton = new JoystickButton(rightStick, Constants.TURN_ON_ANNOYANCE_MODE_BUTTON);
  JoystickButton shootButton = new JoystickButton(midStick, Constants.SHOOT_BUTTON);
  // The robot's subsystems and commands are defined here...
 
  /** The container for the robot. Contains subsystems, OI devices, and commands. 
   * @return */
  public void initialize() {
    // Configure the button bindings
    configureButtonBindings();
    // vroomVroom.setDefaultCommand(new RunCommand(() -> vroomVroom.greenLight(midStick.getRawAxis(0), 
    // leftStick.getRawAxis(1)), vroomVroom));
    vroomVroom.setDefaultCommand(new Drive(midStick, leftStick, vroomVroom));
    m_autonomousCommand = resetDriveTrainPositionAuto.andThen(offTarmacAuto);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    turnLimelightOnButton.whileHeld(turnLimelightLedModeOn);
    turnLimelightOffButton.whenPressed(turnLimelightLedModeOn);
    turnOnAnnoyanceModeButton.whenPressed(AnnoyanceMode);
    targetTheHoop.whileHeld(targeting);
    shootButton.whenHeld(shoot);
  }


//Commands
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

  public Command getAutonomousCommand(){
    return m_autonomousCommand;
  }
}