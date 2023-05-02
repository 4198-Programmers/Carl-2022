package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;
import frc.robot.Maths;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class AutoCommandTurn extends CommandBase{ 
    private DriveTrain driveTrain;
    private boolean complete = false;
    public AutoCommandTurn(DriveTrain driveTrain){
        this.driveTrain = driveTrain;
        addRequirements(driveTrain);
    }

    @Override
    public void execute() {
        double position = Math.abs(driveTrain.findposition());
        double maxRotations = Maths.rotationConversion(50);
        if (position < maxRotations){
            driveTrain.drive(0, -1);
            
        } else {
            driveTrain.drive(0, 0);
            complete = true;
            }
        } 
        
        public void resetposition(){
            driveTrain.setPosition(0);
        }

    @Override
    public void execute() {
        double position = Math.abs(driveTrain.findposition());
        double maxRotations = Maths.rotationConversion(50);
        if (position < maxRotations){
            driveTrain.drive(1, -1);
            complete = true;

        } else {
            driveTrain.drive(0, 0);
            complete = true;
            }
        } 

     @Override
    public boolean isFinished() {
        return complete;
        }
    }
