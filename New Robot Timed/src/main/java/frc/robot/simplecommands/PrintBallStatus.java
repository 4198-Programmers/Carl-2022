package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterPathMovement;

public class PrintBallStatus extends CommandBase{
    private ShooterPathMovement tummy;

    public PrintBallStatus(ShooterPathMovement tummyArg){
        tummy = tummyArg;
        addRequirements(tummyArg);
    }

    @Override
    public void execute() {
        if(tummy.ballIn() || tummy.ballOut()){
            System.out.println("In Status " + tummy.ballIn() + "\nOut Status " + tummy.ballOut());
        }
        else{
            System.out.println("No Balls");
        }

    }
}
