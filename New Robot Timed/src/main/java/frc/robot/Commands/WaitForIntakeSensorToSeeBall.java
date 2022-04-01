package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Intake;
import frc.robot.Subsystems.Sensors;

public class WaitForIntakeSensorToSeeBall extends CommandBase{
    Intake intake;
    Sensors sensors;
    public WaitForIntakeSensorToSeeBall(Intake intake, Sensors sensors){
        this.sensors = sensors;
        this.intake = intake;
        addRequirements(intake);
    }
    @Override
    public boolean isFinished() {
        return(sensors.isBallInFeed());
    }
    @Override
    public void end(boolean interrupted) {
        intake.intake(0);
    }
}
