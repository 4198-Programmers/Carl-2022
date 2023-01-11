// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.DriveCommandXbox;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.AutoCodeShape;
import frc.robot.commands.AutoCodeSquare;
import frc.robot.commands.AutoCodeRotation; 
import frc.robot.commands.AutoCodeSemiCircle;
import frc.robot.commands.AutoCodeShake;
import frc.robot.command.AutoCode;
import frc.robot.commands.AutoCodeCircle;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.WaitCommand;


public class RobotContainer {

  private double AutoCodeCircle;
  private double distance;
  private double angle;
  private double repeat;
  private double degree;
  private double timewanted;
  private boolean turnLeft;

  DriveTrain driveTrain = new DriveTrain();

  //contollers
  private XboxController xbox = new XboxController(Constants.RIGHT_JOYSTICK_ID);

  //joysticks
  private Joystick leftJoystick = new Joystick(Constants.LEFT_JOYSTICK_ID);
  private Joystick middlejoystick = new Joystick(Constants.MIDDLE_JOYSTICK_ID);
  private Joystick rightJoystick = new Joystick(Constants.RIGHT_JOYSTICK_ID);

  //commands
  private AutoCode AutoCode = new AutoCode(driveTrain);
  private AutoCodeCircle autoCodeCircle = new AutoCodeCircle(driveTrain, 0, false);
  private AutoCodeSemiCircle autoCodeSemiCircle = new AutoCodeSemiCircle(driveTrain, AutoCodeCircle, false);
  private AutoCodeRotation autoCodeRotation = new AutoCodeRotation(driveTrain, degree, turnLeft);
  private AutoCodeShape autoCodeShape = new AutoCodeShape(driveTrain, distance, angle, repeat);
  private AutoCodeShake autoCodeShake = new AutoCodeShake(driveTrain, timewanted, distance);
  private AutoCodeSquare autoCodeSquare = new AutoCodeSquare(driveTrain, distance); 
  private DriveTrain DriveTrain; 
  


  //went threw and renammed commands, must go threw and fix

  Command autoCommand = (new DriveCommand(driveTrain, 0, -1, 5))
  .andThen(new DriveCommand(driveTrain, 1, 0, 6));
  // go backwards 
  // spin 

  Command autoCommandshake1 =
    ( ( (new DriveCommand(driveTrain, 0, -1, 3))
  .andThen(new DriveCommand(driveTrain, 0, 1, 3)))
  .raceWith(new WaitCommand(2)));
  //go back 2 s
  // go farward 2 s

  Command autoCommandShake2 = 
  (new AutoCodeShake(driveTrain, 10, 5));

 Command autoCodeRotation180 = 
 (new AutoCodeRotation (driveTrain, 180, true));

 Command autoCodeCircleLeft = 
 (new AutoCodeCircle(driveTrain, 15, true));

 Command autoCodeCircleRight = 
 (new AutoCodeCircle(driveTrain, 15, false));

 Command autoCodeSquare1 = 
 (new DriveCommand(driveTrain, 0, 2, 3))
 .andThen (new DriveCommand(driveTrain, 2, 0, 3))
 .andThen (new DriveCommand(driveTrain, 0, 2, 3))
 .andThen (new DriveCommand(driveTrain, 2, 0, 3))
 .andThen (new DriveCommand(driveTrain, 0, 2, 3))
 .andThen (new DriveCommand(driveTrain, 2, 0, 3))
 .andThen (new DriveCommand(driveTrain, 0, 2, 3))
 .andThen (new DriveCommand(driveTrain, 2, 0, 3));
 //go in a square 
 //go strait
 //turn 
 //go strait 
//(DriveTrain drive,double sidetoside, double straight,double travelDistance)

 Command autoCodeSquare2 = 
 (new AutoCodeShape (driveTrain, 12, 90, 4));

 Command autoCodeSquare3 = 
 (new AutoCodeSquare (driveTrain, 12));




//I dont think this does anything???
  public void setAutoCodeCircleRight(Command autoCodeCircleRight) {
      this.autoCodeCircleRight = autoCodeCircleRight;
  }


  private DriveTrain driveTrain() {
    return null;
  }


  private AutoCode autoCode(DriveTrain driveTrain2) {
    return null;
  }

  private DriveCommand drive =
  new DriveCommand(leftJoystick, middlejoystick, driveTrain);
  private DriveCommandXbox driveX = new DriveCommandXbox(xbox, driveTrain);


  //acces modifyer, type varable will hold, name, assiment, 

  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  
  private final SendableChooser<Command> m_chooser = new SendableChooser<>();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    driveTrain.setDefaultCommand(driveX);
    m_chooser.addOption("180 turn", autoCodeRotation180);
    m_chooser.addOption("RightCicle", autoCodeCircleRight);
    m_chooser.addOption("LeftCircle", autoCodeCircleLeft); 
    m_chooser.addOption("square1", autoCodeSquare1);
    m_chooser.addOption("square2", autoCodeSquare2);
    m_chooser.setDefaultCommand (offTarmac);
    // Configure the button bindings
    configureButtonBindings();

  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  
  

 public Command getAutonomousCommand() {
  // An ExampleCommand will run in autonomous
  return m_chooser.getAutonomousCommand(); 

}
}
