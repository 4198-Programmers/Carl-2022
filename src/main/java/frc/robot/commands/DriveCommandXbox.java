package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;


public class DriveCommandXbox extends CommandBase {
    XboxController controller;
    private DriveTrain drive;

    public DriveCommandXbox(XboxController straight, DriveTrain drive)
    {
        this.controller = straight;
        this.drive = drive;
        addRequirements(drive);
    }

    @Override
    public void execute() {
        drive.drive(controller.getRawAxis(0), controller.getRawAxis(1));
        // TODO Auto-generated method stub
    }

}
