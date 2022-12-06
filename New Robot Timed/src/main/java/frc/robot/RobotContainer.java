package frc.robot;

import java.sql.Time;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.Constants;
import frc.robot.Commands.DriveCommand;
import frc.robot.Commands.IntakeSpeed;
import frc.robot.Commands.ShootCommand;
import frc.robot.Commands.StopAngledHooks;
import frc.robot.Commands.TunnelSpeed;
import frc.robot.Commands.VertHooksCommand;
import frc.robot.Commands.VerticalHookStop;
import frc.robot.Subsystems.AnglesHooks;
import frc.robot.Subsystems.Drivetrain;
import frc.robot.Subsystems.IntakeThing;
import frc.robot.Subsystems.ShootingThing;
import frc.robot.Subsystems.TunnelThing;
import frc.robot.Subsystems.VerticalHooks;
import frc.robot.Commands.AngleHookCommand;
import frc.robot.Commands.AutoDrive;
import frc.robot.Commands.AutoDriveForward;
import frc.robot.Commands.AutoDriveGoCrazyGoStupid;


public class RobotContainer {
  Joystick rightJoystick = new Joystick(Constants.RIGHT_JOYSTICK_THING_ID);
  Joystick middleJoystick = new Joystick(Constants.MIDDLE_JOYSTICK_THING_ID);
  Joystick leftJoystick = new Joystick(Constants.LEFT_JOYSTICK_THING_ID);

  // subsystems
  Drivetrain drivetrain;
  ShootingThing shootingthing;
  IntakeThing intakething;
  TunnelThing tunnelthing;
  ShootCommand shootcommand;
  AnglesHooks anglesHooks;
  VerticalHooks verticalHooks;

  // ungrouped commands
  
  AutoDrive autoDrive = new AutoDrive(4, drivetrain);
  IntakeSpeed intakein = new IntakeSpeed(intakething, Constants.INTAKE_SPEED_NOT_ID, 1);
  TunnelSpeed tunnelin = new TunnelSpeed(Constants.TUNNEL_SPEED_NOT_ID, 1, tunnelthing);
  ShootCommand shootout = new ShootCommand(Constants.SHOOT_SPEED_NOT_ID, 1, shootingthing);
  IntakeSpeed intakeout = new IntakeSpeed(intakething, Constants.INTAKE_SPEED_NOT_ID, -1);
  TunnelSpeed tunnelout = new TunnelSpeed(Constants.TUNNEL_SPEED_NOT_ID, -1, tunnelthing);
  ShootCommand shootin = new ShootCommand(Constants.SHOOT_SPEED_NOT_ID, -1, shootingthing);
  AutoDriveGoCrazyGoStupid forbiddenCommand = new AutoDriveGoCrazyGoStupid(3, drivetrain);
  AutoDriveForward forwardAuto = new AutoDriveForward(5, drivetrain);


  // command groups
//RunCommand drivesticks = new RunCommand(()-> drivetrain.driveBoy(middleJoystick.getRawAxis(0), leftJoystick.getRawAxis(1)), drivetrain);
  //Buttons
  JoystickButton autoButton = new JoystickButton(leftJoystick, Constants.AUTO_BUTTON_ID);
  JoystickButton intakeInButter = new JoystickButton(rightJoystick, Constants.INTAKE_IN_BUTTON_ID);
  JoystickButton intakeOutButter = new JoystickButton(rightJoystick, Constants.INTAKE_OUT_BUTTON_ID);
  JoystickButton tunnelInButton = new JoystickButton(rightJoystick, Constants.TUNNEL_IN_BUTTON_ID);
  JoystickButton tunnelOutButton = new JoystickButton(rightJoystick, Constants.TUNNEL_OUT_BUTTON_ID);
  JoystickButton shootOutButton = new JoystickButton(rightJoystick, Constants.SHOOT_OUT_BUTTON_ID);
  JoystickButton shootInButton = new JoystickButton(rightJoystick, Constants.SHOOT_IN_BUTTON_ID);
  JoystickButton vertHooksButton = new JoystickButton(rightJoystick, Constants.VERT_HOOKS_BUTTON);
  JoystickButton angleHooksButton = new JoystickButton(middleJoystick, Constants.ANGLE_HOOKS_BUTTON);
  JoystickButton forbiddenCommandButton = new JoystickButton(rightJoystick, Constants.SILLY_COMMAND_BUTTON_ID);
  JoystickButton forwardCommandButton = new JoystickButton(rightJoystick ,Constants.FORWARD_COMMAND_BUTTON_ID);
  
  
  
  // others
  private final SendableChooser<Command> m_chooser = new SendableChooser<>();

  public void initialize() {
    configureButtonBindings();
    begin();
    drivetrain.setDefaultCommand(new DriveCommand(()->leftJoystick.getRawAxis(1), ()->middleJoystick.getRawAxis(0), drivetrain));
  }

  private void configureButtonBindings() {

    autoButton.whenPressed(autoDrive);
    intakeInButter.whileHeld(intakein);
    intakeOutButter.whileHeld(intakeout);
    tunnelInButton.whileHeld(tunnelin);
    tunnelOutButton.whileHeld(tunnelout);
    shootOutButton.whileHeld(shootout);
    shootInButton.whileHeld(shootin);

    vertHooksButton.whenHeld(new VertHooksCommand(()->middleJoystick.getRawAxis(1), verticalHooks), false);
    angleHooksButton.whenHeld(new AngleHookCommand(anglesHooks, ()->rightJoystick.getRawAxis(1)), false);

    vertHooksButton.whenReleased(new VerticalHookStop(verticalHooks));
    angleHooksButton.whenReleased(new StopAngledHooks(anglesHooks));

    forbiddenCommandButton.whenPressed(forbiddenCommand);
    forwardCommandButton.whenPressed(forwardAuto);
   

}

  private void begin() {
  }

  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
  }

}
