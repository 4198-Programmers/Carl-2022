package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Maths;

public class Limelight extends SubsystemBase{
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    public NetworkTableEntry tx = table.getEntry("tx"); //TODO math to convert to inches SOON
    NetworkTableEntry ty = table.getEntry("ty");
    NetworkTableEntry tv = table.getEntry("tv"); 
    NetworkTableEntry ta = table.getEntry("ta");
    NetworkTableEntry ts = table.getEntry("ts");
    NetworkTableEntry tvert = table.getEntry("tvert");
    NetworkTableEntry tlong = table.getEntry("tlong");
    NetworkTableEntry tshort = table.getEntry("tshort");
    NetworkTableEntry ledMode = table.getEntry("ledMode");
    NetworkTableEntry camMode = table.getEntry("camMode");
    NetworkTableEntry stream = table.getEntry("stream");
    NetworkTableEntry pipeline = table.getEntry("pipeline");

    public double xOffsetFromCenter()
    {
        /**Default is 1 to cause robot to spin to find target */
        return tx.getDouble(1);                             
    }

    public boolean hasTarget()
    {
        return tv.getDouble(0) == 1;
    }

    public double distanceToTarget()
    {
        double yAngle = ty.getDouble(0);
        return Maths.distanceFromTarget(yAngle);
    }
}
