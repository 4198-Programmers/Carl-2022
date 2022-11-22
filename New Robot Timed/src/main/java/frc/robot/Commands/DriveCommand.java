package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Drivetrain;

public class DriveCommand extends CommandBase {
    /**This is a recipe.  As long as the thing it is called with has everything in the recipe, it can be used.  
     * The same ingrediants can use multiple resipes as long as they can complete every part of the recipe.
     */
    public interface speedRetriever{

        double getSpeed();
    }

    speedRetriever srForward;
    speedRetriever srTurning;
    Drivetrain drivetrain;

    public DriveCommand(speedRetriever srForward, speedRetriever srTurning, Drivetrain drivetrain){

        this.srForward = srForward;
        this.srTurning = srTurning;
        this.drivetrain = drivetrain;

        addRequirements(drivetrain);

    }

    @Override
    public void execute() {
        drivetrain.driveBoy(srTurning.getSpeed(), srForward.getSpeed());
    }

}
