package frc.robot.command;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Maths;
import frc.robot.subsystems.DriveTrain;
/**Autonomous movement used to exit the tarmac during Autonomous */
public class OffTarmac extends CommandBase{
    private DriveTrain vroomVroomOT;
    boolean youDone;
    double distanceOff;

    /**Pulls in the current DriveTrain instance to use in the specific class */
    public OffTarmac(DriveTrain driveTrainArg)
    {
        vroomVroomOT = driveTrainArg;
        addRequirements(vroomVroomOT);
    }

    @Override
    public void initialize()
    {
        vroomVroomOT.resetPosition();
        distanceOff = 40;
        youDone = false;
        vroomVroomOT.resetPosition();
    }

    @Override
    public void execute()
    {
        double rotations = Maths.rotationConversion(distanceOff);
        double position = vroomVroomOT.findPosition();

        if(Math.abs(position) < Math.abs(rotations)) //just reads the values, does not care about direction
        {
            vroomVroomOT.greenLight(0, -1);
        }
        else
        {
            vroomVroomOT.greenLight(0, 0);
            youDone = true;
            System.out.println("success mother");

        }
    }

    @Override
    public boolean isFinished()
    {
        return youDone;
    }
    
}
