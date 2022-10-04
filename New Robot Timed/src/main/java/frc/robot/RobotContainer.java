// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.AutoStop;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.ForwardAuto;
import frc.robot.commands.Reset;
import frc.robot.commands.RotateAuto;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // joysticks
  private Joystick leftJoystick = new Joystick(Constants.LEFT_JOYSTICK_ID);
  private Joystick midJoystick = new Joystick(Constants.MID_JOYSTICK_ID);
  private Joystick rightJoystick = new Joystick(Constants.RIGHT_JOYSTICK_ID);

  // subsystem
  private Drivetrain drivetrain = new Drivetrain();

  // joystick buttons
  JoystickButton rotateAutoButton = new JoystickButton(rightJoystick, Constants.ROTATE_AUTO_BUTTON_ID);
  JoystickButton forwardAutoButton = new JoystickButton(rightJoystick, Constants.FORWARD_AUTO_BUTTON_ID);
  JoystickButton resetButton = new JoystickButton(rightJoystick, Constants.RESET);
  JoystickButton autoStopButton = new JoystickButton(rightJoystick, Constants.AUTO_STOP_BUTTON_ID);

  // commands
  RotateAuto rotateAuto = new RotateAuto(drivetrain);
  ForwardAuto forwardAuto = new ForwardAuto(drivetrain);
  Reset reset = new Reset(drivetrain);
  AutoStop autoStop = new AutoStop(drivetrain);

  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
   * it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    rotateAutoButton.whileHeld(rotateAuto);
    forwardAutoButton.whileHeld(forwardAuto);
    resetButton.whileHeld(reset);
    autoStopButton.whileHeld(autoStop);
    drivetrain.setDefaultCommand(new RunCommand(() -> drivetrain.Movement(leftJoystick.getX(), midJoystick.getY()), drivetrain));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
