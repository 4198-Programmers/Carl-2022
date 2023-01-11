package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;


public class DriveCommand extends CommandBase {
    private double straight;
    private double sidetoside;
    private double travelDistance;


    private DriveTrain drive;

    public DriveCommand(DriveTrain drive,double sidetoside, double straight,double travelDistance)
    {
        this.straight = straight;
        this.sidetoside = sidetoside;
        this.drive = drive;
        this.travelDistance = travelDistance; 
        addRequirements(drive);
    }

    public DriveCommand(Joystick leftJoystick, Joystick middlejoystick, DriveTrain driveTrain) {
    }

    @Override
    public void execute() {
        drive.drive(sidetoside, straight);
        // TODO Auto-generated method stub
    }

    @Override
    public boolean isFinished() {
        return DriveTrain.getPosition() >= travelDistance; 
    }

    @Override
    public void initialize(){
        driveTrain.resetposition();
    }
}
