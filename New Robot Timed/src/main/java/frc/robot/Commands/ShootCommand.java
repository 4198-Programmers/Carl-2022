package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.ShootingThing;

public class ShootCommand extends CommandBase{

    double speed;
    ShootingThing shootingthing;
    double multiplier;

    public ShootCommand(double speed, double multiplier, ShootingThing shootingthing){

        this.speed = speed;
        this.shootingthing = shootingthing;
        this.multiplier = multiplier;

        addRequirements(shootingthing);

    }

    @Override
    public void execute() {
        
        shootingthing.flyWheelSpeed(speed * multiplier);

    }



}
