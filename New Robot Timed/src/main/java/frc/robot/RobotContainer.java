package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Subsystems.Limelight;
import frc.robot.Subsystems.ShooterSystem;
import frc.robot.Commands.AngledHooksMove;
import frc.robot.Commands.Drive;
import frc.robot.Commands.Feeder;
import frc.robot.Commands.OffTarmac;
import frc.robot.Commands.Shoot;
import frc.robot.Commands.Spin180;
import frc.robot.Commands.Targeting;
import frc.robot.Commands.VerticalHooksMove;
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
  VerticalHooks verticalHooks;
  Limelight limelight;
  AngledHooks angledHooks;
  FeederSub feederSub;
  ShooterSystem shooterSystem;
  // commands
  Drive drive =  new Drive(driveTrain, leftJoystick , leftJoystick);
  VerticalHooksMove verticalHooksMove = new VerticalHooksMove(verticalHooks, rightJoystick);
  AngledHooksMove angledHooksMove = new AngledHooksMove(angledHooks, rightJoystick);
  Targeting targeting = new Targeting(limelight, driveTrain);
  Command taxiAndShoot = (new OffTarmac(driveTrain))
    .alongWith(new Feeder(feederSub))
    .andThen(new Spin180(driveTrain))
    .andThen(new Targeting(limelight, driveTrain))
    .andThen(new Shoot(shooterSystem));
  // buttons
  JoystickButton targetingButton = new JoystickButton(middleJoystick, Constants.TARGETING_BUTTON);

  // other
  private final SendableChooser<Command> m_chooser = new SendableChooser<>();

  public RobotContainer() {
    configureButtonBindings();
    begin();
    driveTrain.setDefaultCommand(new Drive(driveTrain, leftJoystick, leftJoystick));
    verticalHooks.setDefaultCommand(new VerticalHooksMove(verticalHooks, rightJoystick));
    angledHooks.setDefaultCommand(new AngledHooksMove(angledHooks, rightJoystick));
  }

  private void configureButtonBindings() {
    targetingButton.whenHeld(new Targeting(limelight, driveTrain));
  }

  private void begin() {
    SmartDashboard.putData("Auto choices", m_chooser);
  }

  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
  }

}
