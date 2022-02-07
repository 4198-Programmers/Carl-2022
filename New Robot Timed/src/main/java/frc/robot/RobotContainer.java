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
import frc.robot.command.ResetDriveTrainPosition;
import frc.robot.command.SetFlySpeed;
import frc.robot.command.SetIntakeSpeed;
import frc.robot.command.SetInternalMoveSpeed;
import frc.robot.command.SpitBalls;
import frc.robot.command.Targeting;
import frc.robot.command.OffTarmac;
import frc.robot.command.hookcommands.AngledHookJoystick;
import frc.robot.command.hookcommands.MoveAngledHookDown;
import frc.robot.command.hookcommands.MoveCloserToNinetyDegrees;
import frc.robot.command.hookcommands.MoveCloserToZeroDegrees;
import frc.robot.command.hookcommands.MoveVerticalHookDown;
import frc.robot.command.hookcommands.MoveVerticalHookUp;
import frc.robot.command.hookcommands.MoveAngledHookUp;
import frc.robot.command.hookcommands.PullVertHooksIn;
import frc.robot.command.hookcommands.ReachVertHooksUp;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Hooks;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.ShooterPathMovement;

public class RobotContainer {
  Joystick leftStick = new Joystick(Constants.LEFT_STICK_PORT);
  Joystick midStick = new Joystick(Constants.MID_STICK_PORT);
  Joystick rightStick = new Joystick(Constants.RIGHT_STICK_PORT);

  // subsystems
  DriveTrain vroomVroom = new DriveTrain();
  ShooterPathMovement pewPew = new ShooterPathMovement();
  Hooks climber = new Hooks();
  Limelight vision = new Limelight();

  // commands
  DoNotMove doNotMove = new DoNotMove(vroomVroom, pewPew);
  AngledHookJoystick angledHookJoystick = new AngledHookJoystick(climber, rightStick);
  ReachVertHooksUp reachVertHooksUp = new ReachVertHooksUp(climber);
  PullVertHooksIn pullVertHooksIn = new PullVertHooksIn(climber);
  MoveCloserToNinetyDegrees moveCloserToNinetyDegrees = new MoveCloserToNinetyDegrees(climber);
  MoveCloserToZeroDegrees moveCloserToZeroDegrees = new MoveCloserToZeroDegrees(climber);
  Targeting targeting = new Targeting(vroomVroom, vision);
  SetFlySpeed setFlySpeed = new SetFlySpeed(pewPew);
  SetIntakeSpeed setIntakeSpeed = new SetIntakeSpeed(pewPew);
  SetInternalMoveSpeed setInternalMoveSpeed = new SetInternalMoveSpeed(pewPew);
  SpitBalls spitBalls = new SpitBalls(pewPew);
  MoveAngledHookUp moveAngledHookUp = new MoveAngledHookUp();
  MoveAngledHookDown moveAngledHookDown = new MoveAngledHookDown();
  MoveVerticalHookUp moveVerticalHookUp = new MoveVerticalHookUp();
  MoveVerticalHookDown moveVerticalHookDown = new MoveVerticalHookDown();
  ResetDriveTrainPosition resetTrainPosition = new ResetDriveTrainPosition(vroomVroom);
  OffTarmac offTarmac = new OffTarmac(vroomVroom);
  /**It is just basically a parallelCommandGroup with Sequential Command groups */
  Command taxiAndShoot = resetDriveTrainPosition.andThen(offTarmac.alongWith(setFlySpeed)
    .andThen(targeting).andThen(setInternalMoveSpeed).andThen(doNotMove));

  ParallelCommandGroup  parallelGroupShootPrep = new ParallelCommandGroup(targeting,setFlySpeed);
  SequentialCommandGroup shootingGroup = new SequentialCommandGroup(parallelGroupShootPrep, setInternalMoveSpeed);

  // buttons
  JoystickButton overrideButton = new JoystickButton(rightStick, Constants.HUMAN_OVERRIDE_BUTTON);
  JoystickButton verticalHookUpBTN = new JoystickButton(rightStick, Constants.VERT_HOOK_UP_BUTTON);
  JoystickButton verticalHookDownBTN = new JoystickButton(rightStick, Constants.VERT_HOOK_DOWN_BUTTON);
  JoystickButton angledHookUpBTN = new JoystickButton(rightStick, Constants.ANGLE_HOOK_UP_BUTTON);
  JoystickButton angledHookDownBTN = new JoystickButton(rightStick, Constants.ANGLE_HOOK_UP_BUTTON);
  JoystickButton manualIntakeForwardsBTN = new JoystickButton(rightStick, Constants.INTAKEIN_BUTTON);
  JoystickButton flywheelSpinUpBTN = new JoystickButton(rightStick, Constants.FLYWHEEL_BUTTON);
  JoystickButton internalFeederInBTN = new JoystickButton(rightStick, Constants.INTERNAL_MOVER_FORWARDS_BUTTON);
  JoystickButton spitBTN = new JoystickButton(rightStick, Constants.YEET_THE_BALLS_OUT_THE_BACK_BUTTON);
  JoystickButton fullFIREEEE = new JoystickButton(rightStick, Constants.RIGHT_STICK_TRIGGER);

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
    overrideButton.and(flywheelSpinUpBTN).whileActiveContinuous(setFlySpeed);
    overrideButton.and(manualIntakeForwardsBTN).whileActiveContinuous(setIntakeSpeed);
    overrideButton.and(internalFeederInBTN).whileActiveContinuous(setInternalMoveSpeed);
    overrideButton.and(spitBTN).whileActiveContinuous(spitBalls);
    fullFIREEEE.whenHeld(shootingGroup);

  
  
  }

  private void begin() {
    m_chooser.setDefaultOption("Default Auto", doNotMove);
    m_chooser.addOption("Taxi + Shoot One", taxiAndShoot);
    m_chooser.addOption("Taxi", offTarmac);
    SmartDashboard.putData("Auto choices", m_chooser);
  }

  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
  }

}
