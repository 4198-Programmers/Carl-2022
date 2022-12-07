// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.RunCommand;

public class RobotContainer {
  DriveTrain driveTrain = new DriveTrain();
  Joystick controller = new Joystick(0);

  RunCommand driving = new RunCommand(
      () -> driveTrain.greenLight(controller.getRawAxis(0), controller.getRawAxis(1),
          controller.getRawAxis(2)));

  public void initialize() {
    driveTrain.setDefaultCommand(driving);
    configureButtonBindings();
  }

  private void configureButtonBindings() {
  }

  // public Command getAutonomousCommand() {
  // return m_autoCommand;
  // }
}
