package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.command.DoNotMove;
import frc.robot.command.SetIntakeSpeed;
import frc.robot.command.Shooter;
import frc.robot.command.Targeting;
import frc.robot.command.TaxiAndShoot;
import frc.robot.command.TaxiTarmac;
import frc.robot.command.hookcommands.AngledHookJoystick;
import frc.robot.command.hookcommands.MoveCloserToNinetyDegrees;
import frc.robot.command.hookcommands.MoveCloserToZeroDegrees;
import frc.robot.command.hookcommands.PullVertHooksIn;
import frc.robot.command.hookcommands.ReachVertHooksUp;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Hooks;
import frc.robot.subsystems.ShooterPathMovement;

public class RobotContainer {
  Joystick leftStick = new Joystick(Constants.LEFT_STICK_PORT);
  Joystick midStick = new Joystick(Constants.MID_STICK_PORT);
  Joystick rightStick = new Joystick(Constants.RIGHT_STICK_PORT);

  // subsystems
  DriveTrain vroomVroom = new DriveTrain();
  ShooterPathMovement pewPew = new ShooterPathMovement();
  Hooks climber = new Hooks();

  // commands
  DoNotMove doNotMove = new DoNotMove(vroomVroom, pewPew);
  TaxiAndShoot taxiAndShoot = new TaxiAndShoot(vroomVroom, pewPew);
  TaxiTarmac taxiTarmac = new TaxiTarmac(vroomVroom);
  AngledHookJoystick angledHookJoystick = new AngledHookJoystick(climber, rightStick);
  ReachVertHooksUp reachVertHooksUp = new ReachVertHooksUp(climber);
  PullVertHooksIn pullVertHooksIn = new PullVertHooksIn(climber);
  MoveCloserToNinetyDegrees moveCloserToNinetyDegrees = new MoveCloserToNinetyDegrees(climber);
  MoveCloserToZeroDegrees moveCloserToZeroDegrees = new MoveCloserToZeroDegrees(climber);
  Targeting targeting = new Targeting();
  Shooter shooter = new Shooter();
  SetIntakeSpeed setIntakeSpeed = new SetIntakeSpeed(pewPew);

  ParallelCommandGroup group = new ParallelCommandGroup(targeting,setIntakeSpeed);
  SequentialCommandGroup gRoup = new SequentialCommandGroup(group, shooter);

  // buttons
  JoystickButton overrideButton = new JoystickButton(rightStick, Constants.HUMAN_OVERRIDE_BUTTON);
  JoystickButton verticalHookUpBTN = new JoystickButton(rightStick, Constants.VERT_HOOK_UP_BUTTON);
  JoystickButton verticalHookDownBTN = new JoystickButton(rightStick, Constants.VERT_HOOK_DOWN_BUTTON);
  JoystickButton angledHookUpBTN = new JoystickButton(rightStick, Constants.ANGLE_HOOK_UP_BUTTON);
  JoystickButton angledHookDownBTN = new JoystickButton(rightStick, Constants.ANGLE_HOOK_UP_BUTTON);
  JoystickButton manualIntakeForwardsBTN = new JoystickButton(rightStick, Constants.INTAKEIN_BUTTON);
  JoystickButton flywheelSpinUpBTN = new JoystickButton(rightStick, Constants.FLYWHEEL_BUTTON);
  JoystickButton internalFeederInBTN = new JoystickButton(rightStick, Constants.INTERNAL_MOVER_FORWARDS_BUTTON);
  JoystickButton internalFeederOutBTN = new JoystickButton(rightStick, Constants.INTERNAL_MOVER_REVERSE_BUTTON);
  JoystickButton manualIntakeReverseBTN = new JoystickButton(rightStick, Constants.INTAKEOUT_BUTTON);

  // other
  private final SendableChooser<Command> m_chooser = new SendableChooser<>();

  public RobotContainer() {
    configureButtonBindings();
    begin();
    vroomVroom.setDefaultCommand(new RunCommand( () -> 
    vroomVroom.greenLight(leftStick.getRawAxis(0), rightStick.getRawAxis(0)), vroomVroom));
  }

  private void configureButtonBindings() {
    overrideButton.whileHeld(angledHookJoystick);
    overrideButton.and(verticalHookUpBTN).whileActiveContinuous(reachVertHooksUp);
    overrideButton.and(verticalHookDownBTN).whileActiveContinuous(pullVertHooksIn);
    overrideButton.and(angledHookUpBTN).whileActiveContinuous(moveCloserToNinetyDegrees);
    overrideButton.and(angledHookDownBTN).whileActiveContinuous(moveCloserToZeroDegrees);

    overrideButton.and(manualIntakeForwardsBTN).whileActiveContinuous(new RunCommand( () -> 
    pewPew.setIntakeSpeed(Constants.MANUAL_INTAKE_SPEED), pewPew));

    overrideButton.and(flywheelSpinUpBTN).whileActiveContinuous(new RunCommand( () -> 
    pewPew.setFlySpeed(Constants.FLYWHEEL_SPEED), pewPew));

    overrideButton.and(internalFeederInBTN).whileActiveContinuous(new RunCommand( () -> 
    pewPew.setMoverSpeed(Constants.INTERNAL_FEEDER_SPEED), pewPew));

    overrideButton.and(internalFeederOutBTN).whileActiveContinuous(new RunCommand( () -> 
    pewPew.setMoverSpeed(Constants.INTERNAL_FEEDER_REVERSE_SPEED), pewPew));

    overrideButton.and(manualIntakeReverseBTN).whileActiveContinuous(new RunCommand( () -> 
    pewPew.setIntakeSpeed(Constants.INTAKEOUT_BUTTON), pewPew));
  
  
  }

  private void begin() {
    m_chooser.setDefaultOption("Default Auto", doNotMove);
    m_chooser.addOption("Taxi + Shoot One", taxiAndShoot);
    m_chooser.addOption("Taxi", taxiTarmac);
    SmartDashboard.putData("Auto choices", m_chooser);
  }

  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
  }

}
