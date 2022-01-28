package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Limelight extends SubsystemBase{
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    public NetworkTableEntry tx = table.getEntry("tx");
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

    public double distanceFromCenter()
    {
        return tx.getDouble(1);                             //default is 1 to cause robot to spin to find target
    }
}
