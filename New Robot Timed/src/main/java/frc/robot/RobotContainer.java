package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.simplecommands.DoNotMove;
import frc.robot.simplecommands.TaxiTarmac;
import frc.robot.simplecommands.PickLimelightMode;
//import frc.robot.simplecommands.RedFollower;
import frc.robot.simplecommands.SetFlySpeed;
import frc.robot.simplecommands.SetIntakeSpeed;
import frc.robot.simplecommands.SetInternalMoveSpeed;
import frc.robot.simplecommands.SpitBalls;
import frc.robot.simplecommands.Targeting;
import frc.robot.hookcommands.AngledHookJoystick;
import frc.robot.hookcommands.MoveCloserToNinetyDegrees;
import frc.robot.hookcommands.MoveCloserToZeroDegrees;
import frc.robot.hookcommands.PullVertHooksIn;
import frc.robot.hookcommands.ReachVertHooksUp;
//import frc.robot.ubernestedcommands.TaxiAndShoot;
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
  // UsbCamera ballFinder = CameraServer.startAutomaticCapture();

  // commands
  // RealizeBall realizeBall = new RealizeBall(ballFinder);
  DoNotMove doNotMove = new DoNotMove(vroomVroom, pewPew);
  DoNotMove doNotMoveTASGROUP = new DoNotMove(vroomVroom, pewPew);
  //TaxiAndShoot taxiAndShoot = new TaxiAndShoot(vroomVroom, pewPew, vision);
  AngledHookJoystick angledHookJoystick = new AngledHookJoystick(climber, rightStick);
  ReachVertHooksUp reachVertHooksUp = new ReachVertHooksUp(climber);
  ReachVertHooksUp reachVertHooksUpFRGROUP = new ReachVertHooksUp(climber);
  ReachVertHooksUp reachVertHooksUpTNRGROUP = new ReachVertHooksUp(climber);
  PullVertHooksIn pullVertHooksIn = new PullVertHooksIn(climber);
  PullVertHooksIn pullVertHooksInFRGROUP = new PullVertHooksIn(climber);
  PullVertHooksIn pullVertHooksInTNRGROUP = new PullVertHooksIn(climber);
  MoveCloserToNinetyDegrees moveCloserToNinetyDegrees = new MoveCloserToNinetyDegrees(climber);
  MoveCloserToNinetyDegrees moveCloserToNinetyDegreesTNRGROUP = new MoveCloserToNinetyDegrees(climber);
  MoveCloserToZeroDegrees moveCloserToZeroDegrees = new MoveCloserToZeroDegrees(climber);
  MoveCloserToZeroDegrees moveCloserToZeroDegreesTNRGROUP = new MoveCloserToZeroDegrees(climber);
  Targeting targeting = new Targeting(vroomVroom, vision);
  Targeting targetingTASGROUP = new Targeting(vroomVroom, vision);
  Targeting targetingLT = new Targeting(vroomVroom, vision);
  SetFlySpeed setFlySpeed = new SetFlySpeed(pewPew);
  SetFlySpeed setFlySpeedTASGROUP = new SetFlySpeed(pewPew);
  SetIntakeSpeed setIntakeSpeed = new SetIntakeSpeed(pewPew);
  SetInternalMoveSpeed setInternalMoveSpeed = new SetInternalMoveSpeed(pewPew);
  SetInternalMoveSpeed setInternalMoveSpeedTASGROUP = new SetInternalMoveSpeed(pewPew);
  SpitBalls spitBalls = new SpitBalls(pewPew);
  TaxiTarmac taxiTarmac = new TaxiTarmac(vroomVroom);
  TaxiTarmac taxiTarmacTASGROUP = new TaxiTarmac(vroomVroom);
  TaxiTarmac taxiTarmacFRGROUP = new TaxiTarmac(vroomVroom);
  PickLimelightMode setLimelightModeOff = new PickLimelightMode(vision, Constants.LIMELIGHT_OFF_PIPELINE_MODE);
  PickLimelightMode setLimelightModeOnLTGROUP = new PickLimelightMode(vision,
      Constants.LIMELIGHT_FULL_ON_PIPELINE_MODE);
  PickLimelightMode setLimelightModeOn = new PickLimelightMode(vision, Constants.LIMELIGHT_FULL_ON_PIPELINE_MODE);

  // command groups
  Command limelightTargeting = setLimelightModeOnLTGROUP.andThen(targetingLT);
  RunCommand driveSticks = new RunCommand(
      () -> vroomVroom.greenLight(midStick.getRawAxis(0), (-1) * leftStick.getRawAxis(1)), vroomVroom);

  // Nested Command Lines
  Command taxiAndShoot = (taxiTarmacTASGROUP.alongWith(setFlySpeedTASGROUP)).andThen(targetingTASGROUP).andThen(setInternalMoveSpeedTASGROUP).andThen(doNotMoveTASGROUP);
  Command getOnFirstRung = reachVertHooksUpFRGROUP.andThen(taxiTarmacFRGROUP).andThen(pullVertHooksInFRGROUP);
  Command moveToNextRung = moveCloserToZeroDegreesTNRGROUP.andThen(moveCloserToNinetyDegreesTNRGROUP)
      .andThen(reachVertHooksUpTNRGROUP).andThen(pullVertHooksInTNRGROUP);

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
  JoystickButton fullFIREEEEBTN = new JoystickButton(rightStick, Constants.RIGHT_STICK_TRIGGER);
  JoystickButton limelightOffBTN = new JoystickButton(midStick, Constants.LIMELIGHT_OFF_BUTTON);
  JoystickButton limelightOnBTN = new JoystickButton(midStick, Constants.LIMELIGHT_ON_BUTTON);
  JoystickButton limelightTargetingBTN = new JoystickButton(rightStick, Constants.LIMELIGHT_TARGETING_BUTTON);
  JoystickButton limelightOnThenTargetBTN = new JoystickButton(rightStick, Constants.TARGETING_LIMELIGHT_SIMULTANEOUS);

  // other
  private final SendableChooser<Command> m_chooser = new SendableChooser<>();

  public RobotContainer() {

  }

  public void initialize() {
    configureButtonBindings();
    begin();
    vroomVroom.setDefaultCommand(driveSticks);

    CommandScheduler.getInstance().onCommandExecute((command) -> {
      if (!command.getName().equals("RunCommand")) {
        System.out.println("running command " + command.getName());
      }
    });
    CommandScheduler.getInstance().onCommandFinish((command) -> {
      System.out.println("finished command " + command.getName());
    });
    CommandScheduler.getInstance().onCommandInterrupt((command) -> {
      System.out.println("interrupted command " + command.getName());
    });
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
    limelightOnThenTargetBTN.whenHeld(limelightTargeting);
    limelightOffBTN.whenPressed(setLimelightModeOff);
    limelightOnBTN.whenPressed(setLimelightModeOn);
    // fullFIREEEEBTN.whenHeld(shootingGroup);
  }

  private void begin() {
    m_chooser.setDefaultOption("Default- Frozen", doNotMove);
    m_chooser.addOption("Taxi + Shoot One", taxiAndShoot);
    m_chooser.addOption("Taxi", taxiTarmac);
    SmartDashboard.putData("Auto choices", m_chooser);
  }

  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
  }

}
