package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
  private Command autoSelected;
  RobotContainer container;

  @Override
  public void robotInit() {
    container = new RobotContainer();
    container.initialize();

  }



  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run(); 

    }



  @Override
  public void autonomousInit() {
    autoSelected = container.getAutonomousCommand();

    if (autoSelected != null) {
      autoSelected.schedule();
    }

  }



  @Override
  public void autonomousPeriodic() {}



  @Override
  public void teleopInit() {
    if (autoSelected != null) {
      autoSelected.cancel();
    }

  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  // @Override 
  // public void simulationInit() {}
  
}
