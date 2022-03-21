package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class Spin extends CommandBase{
    DriveTrain vroomVroom;
    public  Spin(DriveTrain vroomVroom){
        this.vroomVroom = vroomVroom;
        addRequirements(vroomVroom);
    }
    @Override
    public void execute() {
    }
}
