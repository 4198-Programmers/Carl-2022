package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Maths;

public class Limelight extends SubsystemBase{
    public enum LimelightMode{
        forceOff(0),
        forceOn(1),
        invalid(-1);
        private double mode;
        private LimelightMode(double mode) {
            this.mode = mode;
        }
        public double getMode() {
            return mode;
        }

    }
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tx = table.getEntry("tx"); // TODO math to convert to inches SOON
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
    private NetworkTableEntry pipeline = table.getEntry("pipeline");

    public static double distanceToTarget(){
        double yAngle = ty.getDouble();
        double distance = Maths.distanceFromTarget(yAngle);
        return distance;
    }
    public double xOffsetTarget(){
        return tx.getDouble(1);
    }
    public boolean hasTarget(){
        return tv.getDouble(0) == 1;
    }
    public double getPipeLine(){
        return pipeline.getDouble(-1);
    }
    public void setPipelineMode(LimelightMode mode)
    {
    pipeline.setDouble(mode.getMode());     
    }
    public LimelightMode getLimelightMode() {
        double getMode = pipeline.getDouble(LimelightMode.invalid.getMode());
        LimelightMode pipeline = LimelightMode.invalid;
       if(getMode == 0){
           pipeline = LimelightMode.forceOff;
       }
       else if(getMode ==1){
           pipeline = LimelightMode.forceOn;
       }
        return pipeline;
    }
    }
