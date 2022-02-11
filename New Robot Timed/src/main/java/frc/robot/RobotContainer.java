package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.command.DoNotMove;
import frc.robot.command.ResetDriveTrainPosition;
import frc.robot.command.SetFlySpeed;
//import frc.robot.command.SetFlySpeedUsingCalculation;
import frc.robot.command.SetIntakeSpeed;
import frc.robot.command.SetInternalMoveSpeed;
import frc.robot.command.SetLimelightMode;
import frc.robot.command.SpitBalls;
import frc.robot.command.Targeting;
import frc.robot.command.OffTarmac;
import frc.robot.command.hookcommands.AngledHookJoystick;
import frc.robot.command.hookcommands.MoveCloserToNinetyDegrees;
import frc.robot.command.hookcommands.MoveCloserToZeroDegrees;
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
<<<<<<< Updated upstream
=======
  DoNotMove doNotMoveTAS = new DoNotMove(vroomVroom, pewPew);
  //TaxiAndShoot taxiAndShoot = new TaxiAndShoot(vroomVroom, pewPew, vision); taken out to see emily code
>>>>>>> Stashed changes
  AngledHookJoystick angledHookJoystick = new AngledHookJoystick(climber, rightStick);
  ReachVertHooksUp reachVertHooksUp = new ReachVertHooksUp(climber);
  PullVertHooksIn pullVertHooksIn = new PullVertHooksIn(climber);
  MoveCloserToNinetyDegrees moveCloserToNinetyDegrees = new MoveCloserToNinetyDegrees(climber);
  MoveCloserToZeroDegrees moveCloserToZeroDegrees = new MoveCloserToZeroDegrees(climber);
  SetFlySpeed setFlySpeed = new SetFlySpeed(pewPew);
  SetInternalMoveSpeed setInternalMoveSpeed = new SetInternalMoveSpeed(pewPew);
  ReachVertHooksUp reachVertHooksUpFONFR = new ReachVertHooksUp(climber);
  ReachVertHooksUp reachVertHooksUpMTNR = new ReachVertHooksUp(climber);
  PullVertHooksIn pullVertHooksInFONFR = new PullVertHooksIn(climber);
  PullVertHooksIn pullVertHooksInMTNR = new PullVertHooksIn(climber);
  MoveCloserToNinetyDegrees moveCloserToNinetyDegreesMTNR = new MoveCloserToNinetyDegrees(climber);
  MoveCloserToZeroDegrees moveCloserToZeroDegreesMTNR = new MoveCloserToZeroDegrees(climber);
  Targeting targeting = new Targeting(vroomVroom, vision);
  Targeting targetingTAS = new Targeting(vroomVroom, vision);
  SetFlySpeed setFlySpeedTAS = new SetFlySpeed(pewPew);
  SetIntakeSpeed setIntakeSpeed = new SetIntakeSpeed(pewPew);
  SetInternalMoveSpeed setInternalMoveSpeedTAS = new SetInternalMoveSpeed(pewPew);
  SpitBalls spitBalls = new SpitBalls(pewPew);
<<<<<<< Updated upstream
  ResetDriveTrainPosition resetDriveTrainPosition = new ResetDriveTrainPosition(vroomVroom);
  SetLimelightMode setLimelightModeOff = new SetLimelightMode(vision, Constants.LIMELIGHT_OFF_PIPELINE_MODE);
  SetLimelightMode setLimelightModeOn = new SetLimelightMode(vision, Constants.LIMELIGHT_FULL_ON_PIPELINE_MODE);
  Targeting limelightTargeting = new Targeting(vroomVroom, vision);
  OffTarmac offTarmac = new OffTarmac(vroomVroom);
  /**It is just basically a parallelCommandGroup with Sequential Command groups */
  Command taxiAndShoot = resetDriveTrainPosition.andThen(offTarmac.alongWith(setFlySpeed)
    .andThen(targeting).andThen(setInternalMoveSpeed).andThen(doNotMove));
    //SetFlySpeedUsingCalculation setFlySpeedUsingCalculation = new SetFlySpeedUsingCalculation(vision, pewPew);
  //Command getOnFirstRung = reachVertHooksUp.andThen(offTarmac).andThen(pullVertHooksIn);
  //Command moveToNextRung = moveCloserToZeroDegrees.andThen(moveCloserToNinetyDegrees).andThen(reachVertHooksUp).
  //alongWith(moveCloserToNinetyDegrees).andThen(pullVertHooksIn);
  ParallelCommandGroup  parallelGroupShootPrep = new ParallelCommandGroup(targeting,setFlySpeed);
  SequentialCommandGroup shootingGroup = new SequentialCommandGroup(parallelGroupShootPrep, setInternalMoveSpeed);
=======
  OffTarmac taxiTarmacTAS = new OffTarmac(vroomVroom);
  OffTarmac taxiTarmacGONFR = new OffTarmac(vroomVroom);
  PickLimelightMode setLimelightModeOff = new PickLimelightMode(vision, Constants.LIMELIGHT_OFF_PIPELINE_MODE);
  PickLimelightMode setLimelightModeOnLTGROUP = new PickLimelightMode(vision, Constants.LIMELIGHT_FULL_ON_PIPELINE_MODE);
  PickLimelightMode setLimelightModeOn = new PickLimelightMode(vision, Constants.LIMELIGHT_FULL_ON_PIPELINE_MODE);
  // SetFlySpeedUsingCalculation setFlySpeedUsingCalculation = new
  // SetFlySpeedUsingCalculation(vision, pewPew);
  ResetDriveTrainPosition resetDriveTrainPositionTAS = new ResetDriveTrainPosition(vroomVroom);
  Targeting targetingLLT = new Targeting(vroomVroom, vision);

  

  //commands
  Command limelightTargeting = setLimelightModeOnLTGROUP.andThen(targetingLLT);
  RunCommand driveSticks = new RunCommand(
    () -> vroomVroom.greenLight(midStick.getRawAxis(0), (-1) * leftStick.getRawAxis(1)), vroomVroom);
  Command manualDriveCheck = driveSticks.alongWith(new PrintCommand("driveSticks working"));

  //Nested Command Lines
   Command taxiAndShoot = resetDriveTrainPositionTAS.andThen(taxiTarmacTAS.alongWith(setFlySpeedTAS)
   .andThen(targetingTAS).andThen(setInternalMoveSpeedTAS).andThen(doNotMoveTAS));
  Command getOnFirstRung = reachVertHooksUpFONFR.andThen(taxiTarmacGONFR).andThen(pullVertHooksInFONFR);
  Command moveToNextRung = moveCloserToZeroDegreesMTNR.andThen(moveCloserToNinetyDegreesMTNR).andThen(reachVertHooksUpMTNR).
  alongWith(moveCloserToNinetyDegreesMTNR).andThen(pullVertHooksInMTNR);
>>>>>>> Stashed changes

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
    vroomVroom.setDefaultCommand(new RunCommand(
        () -> vroomVroom.greenLight(midStick.getRawAxis(0), (-1) * leftStick.getRawAxis(1)), vroomVroom));
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
    // limelightTargetingBTN.whileActiveContinuous(targeting);
    // limelightOffBTN.whenPressed(setLimelightModeOff);
    // limelightOnBTN.whenPressed(setLimelightModeOn);
    // fullFIREEEEBTN.whenHeld(shootingGroup);
  }

  private void begin() {
    m_chooser.setDefaultOption("Default Auto", doNotMove);
<<<<<<< Updated upstream
    m_chooser.addOption("Taxi + Shoot One", taxiAndShoot);
    m_chooser.addOption("Taxi", offTarmac);
=======
    //m_chooser.addOption("Taxi + Shoot One", taxiAndShoot);
    m_chooser.addOption("Taxi", taxiTarmacTAS);
>>>>>>> Stashed changes
    SmartDashboard.putData("Auto choices", m_chooser);
  }

  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
  }

}
