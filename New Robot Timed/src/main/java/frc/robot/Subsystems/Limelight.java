package frc.robot.Subsystems;

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

        private LimelightMode(double mode){
            this.mode = mode;
        }
        protected double getModeValue(){
            return mode;
        }
    }
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

    public double xOffset(){
        return(tx.getDouble(0));
    }
    public double distancefromTarget(){
        return(Maths.distanceFromTarget(ty.getDouble(0)));
    }
    public void setpipelineMode(LimelightMode limelightMode){
        pipeline.setDouble(limelightMode.getModeValue());
    }
    public LimelightMode getpipelineMode(){
        double mode = pipeline.getDouble(LimelightMode.invalid.getModeValue());
        LimelightMode pipeline = LimelightMode.invalid;
        if(pipeline == 0){
            pipeline = LimelightMode.forceOff;
        }
        else if( pipeline == 1){
            pipeline = LimelightMode.forceOn;
        }
        }
    public double hasTarget(){
        return(tx.getDouble(0));
    }
    }