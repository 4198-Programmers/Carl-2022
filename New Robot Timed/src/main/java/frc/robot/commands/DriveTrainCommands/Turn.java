package frc.robot.commands.DriveTrainCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Maths;
import frc.robot.subsystems.DriveTrain;

public class Turn extends CommandBase{
    DriveTrain driveTrain;
    double degrees;
    public Turn(DriveTrain driveTrain, double degrees){
        this.driveTrain = driveTrain;
        this.degrees = degrees;
        addRequirements(driveTrain);
    }
    @Override
    public void initialize() {
        driveTrain.setPosition(0);
    }
    @Override
    public void execute() {
        driveTrain.drive(0, 0.5);
    }
    @Override
    public boolean isFinished() {
        return driveTrain.getPosition() >= Maths.spinDistanceByDegree(degrees);
    }
    @Override
    public void end(boolean interrupted) {
        driveTrain.drive(0, 0);
    }
}