package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Maths;

public class Limelight extends SubsystemBase {

    public enum LimelightMode {
        forceOff(0),
        forceOn(1),
        invalid(-1);

        private double mode;

        private LimelightMode(double mode) {
            this.mode = mode;
        }

        protected double GetModeValue() {
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
    NetworkTableEntry pipeline = table.getEntry("pipeline");

    public double xOffset() {
        return tx.getDouble(0);
    }

    public void setPipelineMode(LimelightMode limelightMode) {
        pipeline.setDouble(limelightMode.GetModeValue());
    }

    public LimelightMode getPipelineMode(LimelightMode limelightMode) {
        double mode = pipeline.getDouble(LimelightMode.invalid.GetModeValue());
        LimelightMode pipeline = LimelightMode.invalid;
        if (mode == 0) {
            pipeline = LimelightMode.forceOff;
        }
        if (mode == 1) {
            pipeline = LimelightMode.forceOn;
        }
        return pipeline;
    }

    public double distanceFromTarget() {
        return Maths.distanceFromTarget(ty.getDouble(0));
    }
}
