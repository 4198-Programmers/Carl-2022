// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.MORELEGSGOAMNESIA;
import frc.robot.commands.MORELEGSGOBRRR;
import frc.robot.commands.MORELEGSGOBZZZ;
import frc.robot.commands.MORELEGSGONOMORE;
import frc.robot.subsystems.BRRR;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  //joysticks
  private Joystick wiggle = new Joystick(GUDNumbers.WIGGLE_INSERT_LOCATION);
  private Joystick wiggleWiggle = new Joystick(GUDNumbers.WIGGLE_WIGGLE_INSERT_LOCATION);
  private Joystick wiggleWiggleWiggle = new Joystick(GUDNumbers.WIGGLE_WIGGLE_WIGGLE_INSERT_LOCATION);

  //subsystem
  private BRRR brr = new BRRR();

  //joystick buttons
  JoystickButton morelegsgobrrrbutton = new JoystickButton(wiggleWiggleWiggle, GUDNumbers.MOVE_LEGS_GO_BRRR);
  JoystickButton morelegsgobzzzbutton = new JoystickButton(wiggleWiggleWiggle, GUDNumbers.MOVE_LEGS_GO_BZZZ);
  JoystickButton morelegsgoamnesiabuttion = new JoystickButton(wiggleWiggleWiggle, GUDNumbers.MOVE_LEGS_GO_AMNESIA);
  JoystickButton morelegsgonomorebutton = new JoystickButton(wiggleWiggleWiggle, GUDNumbers.MOVE_LEGS_GO_NO_MORE);

  //commands
  MORELEGSGOBRRR morelegsgobrrr = new MORELEGSGOBRRR(brr);
  MORELEGSGOBZZZ morelegsgobzzz = new MORELEGSGOBZZZ(brr);
  MORELEGSGOAMNESIA morelegsgoamnesia = new MORELEGSGOAMNESIA(brr);
  MORELEGSGONOMORE morelegsgonomore = new MORELEGSGONOMORE(brr);


  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    morelegsgobrrrbutton.whileHeld(morelegsgobrrr);
    morelegsgobzzzbutton.whileHeld(morelegsgobzzz);
    morelegsgoamnesiabuttion.whileHeld(morelegsgoamnesia);
    morelegsgonomorebutton.whileHeld(morelegsgonomore);
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
