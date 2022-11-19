package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.ShootingThing;

public class ShootCommand extends CommandBase{

    double speed;
    ShootingThing shootingthing;

    public ShootCommand(double speed, ShootingThing shootingthing){

        this.speed = speed;
        this.shootingthing = shootingthing;

        addRequirements(shootingthing);

    }

    @Override
    public void execute() {
        
        shootingthing.flyWheelSpeed(speed);

    }

    @Override
    public void end(boolean interrupted) {
        
        shootingthing.flyWheelSpeed(0);

    }

}
