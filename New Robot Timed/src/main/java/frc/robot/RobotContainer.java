package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Subsystems.Limelight;
import frc.robot.Subsystems.ShooterSystem;
import frc.robot.Subsystems.TunnelSub;
import frc.robot.Commands.MoveAngledHooks;
import frc.robot.Commands.ChooseLimelightMode;
import frc.robot.Commands.DanceAngledHooks;
import frc.robot.Commands.DanceVerticalHooks;
import frc.robot.Commands.DoNotDrive;
import frc.robot.Commands.Drive;
import frc.robot.Commands.FeederIn;
import frc.robot.Commands.FeederOut;
import frc.robot.Commands.OffTarmac;
import frc.robot.Commands.SetFlyWheelSpeed;
import frc.robot.Commands.StopFlyWheelSpeed;
import frc.robot.Commands.Spin180;
import frc.robot.Commands.Targeting;
import frc.robot.Commands.TunnelIn;
import frc.robot.Commands.TunnelOut;
import frc.robot.Commands.TunnelStop;
import frc.robot.Commands.MoveVerticalHooks;
import frc.robot.Subsystems.AngledHooks;
import frc.robot.Subsystems.DriveTrain;
import frc.robot.Subsystems.FeederSub;
import frc.robot.Subsystems.VerticalHooks;


public class RobotContainer {
  Joystick rightJoystick =  new Joystick(Constants.RIGHT_JOYSTICK_PORT);
  Joystick middleJoystick = new Joystick(Constants.MIDDLE_JOYSTICK_PORT);
  Joystick leftJoystick = new Joystick(Constants.LEFT_JOYSTICK_PORT);

  // subsystems
  DriveTrain driveTrain;
  ShooterSystem shooterSystem;
  VerticalHooks verticalHooks;
  AngledHooks angledHooks;
  Limelight limelight;
  FeederSub feederSub;
  TunnelSub tunnelSub;
  // commands
  Drive drive =  new Drive(driveTrain, () -> leftJoystick.getRawAxis(0), ()-> middleJoystick.getRawAxis(1));
  Targeting targeting = new Targeting(limelight, driveTrain);
  DoNotDrive doNotDrive = new DoNotDrive(driveTrain);
  OffTarmac offTarmac = new OffTarmac(driveTrain);
  ChooseLimelightMode limelightModeOn = new ChooseLimelightMode(limelight, 1);
  ChooseLimelightMode limelightModeOff = new ChooseLimelightMode(limelight, 0);
  Command taxiAndShoot = (new OffTarmac(driveTrain))
    .alongWith(new FeederIn(feederSub))
    .andThen(new Spin180(driveTrain))
    .andThen(new Targeting(limelight, driveTrain))
    .andThen(new SetFlyWheelSpeed(shooterSystem));
    Command shootWithTargeting = (new Targeting(limelight, driveTrain))
      .andThen(new SetFlyWheelSpeed(shooterSystem));
    Command dance = (new OffTarmac(driveTrain))
      .andThen(new Spin180(driveTrain))
      .alongWith(new DanceVerticalHooks(verticalHooks, 10))
      .alongWith(new DanceAngledHooks(angledHooks, 10))
      .andThen(new Targeting(limelight, driveTrain));
    Command autoShoot = (new Targeting(limelight, driveTrain))
      .andThen(new SetFlyWheelSpeed(shooterSystem))
      .alongWith(new TunnelIn(tunnelSub))
      .andThen(new StopFlyWheelSpeed(shooterSystem))
      .alongWith(new TunnelStop(tunnelSub));
    // buttons
  JoystickButton targetingButton = new JoystickButton(middleJoystick, Constants.TARGETING_BUTTON);
  JoystickButton shootingButton = new JoystickButton(rightJoystick, Constants.SHOOTING_BUTTON);
  JoystickButton limelightOnButton = new JoystickButton(middleJoystick, Constants.LIMELIGHT_ON_BUTTON);
  JoystickButton limelightOffButton = new JoystickButton(middleJoystick, Constants.LIMELIGHT_OFF_BUTTON);
  JoystickButton feederInButton = new JoystickButton(rightJoystick, Constants.FEEDER_IN_BUTTON);
  JoystickButton feederOutButton = new JoystickButton(rightJoystick, Constants.FEEDER_OUT_BUTTON);
  JoystickButton tunnelInButton = new JoystickButton(rightJoystick, Constants.TUNNEL_IN_BUTTON);
  JoystickButton tunnelOutButton = new JoystickButton(rightJoystick, Constants.TUNNEL_OUT_BUTTON);
  JoystickButton danceButton = new JoystickButton(middleJoystick, Constants.DANCE_BUTTON);
  JoystickButton angledOverRideButton = new JoystickButton(middleJoystick, Constants.ANGLED_OVERRIDE_BUTTON);
  JoystickButton verticalOverRideButton = new JoystickButton(middleJoystick, Constants.VERTICAL_OVERRIDE_BUTTON);

  // other
  private final SendableChooser<Command> m_chooser = new SendableChooser<>();

  public RobotContainer() {
    configureButtonBindings();
    begin();
    driveTrain.setDefaultCommand(new Drive(driveTrain, () -> leftJoystick.getRawAxis(0), () -> middleJoystick.getRawAxis(1)));

  }

  private void configureButtonBindings() {
    targetingButton.whenHeld(new Targeting(limelight, driveTrain));
    shootingButton.whenHeld(new SetFlyWheelSpeed(shooterSystem), false);
    limelightOnButton.whenPressed(new ChooseLimelightMode(limelight, 1));
    limelightOffButton.whenPressed(new ChooseLimelightMode(limelight, 0));
    feederInButton.whenHeld(new FeederIn(feederSub), false);
    feederOutButton.whenHeld(new FeederOut(feederSub), false);
    tunnelInButton.whenHeld(new TunnelIn(tunnelSub), false);
    tunnelOutButton.whenHeld(new TunnelOut(tunnelSub), false);
    danceButton.whenPressed(dance);
    angledOverRideButton.whenHeld(new MoveAngledHooks(angledHooks, () -> rightJoystick.getRawAxis(1)), false);
    verticalOverRideButton.whenHeld(new MoveVerticalHooks(verticalHooks, () -> middleJoystick.getRawAxis(0)), false);
    
  }

  private void begin() {
m_chooser.addOption("Auto-Do not Move", doNotDrive);  
m_chooser.setDefaultOption("Taxi and Shoot Two Balls", taxiAndShoot);
m_chooser.addOption("Taxi", offTarmac);
}

  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
  }

}