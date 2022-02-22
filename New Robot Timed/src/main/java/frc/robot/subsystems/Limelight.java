package frc.robot.subsystems;


import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Limelight extends SubsystemBase{
    public enum LimelightMode{
        forceOff(1),
        forceBlink(2),
        forceOn(3),
        invalid(-1);
        private double mode;

        private LimelightMode(double mode){
            this.mode = mode;
        }
        protected double getModeValue(){
            return mode;
        }
    }
    private NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    /**Horizontal Offset From Crosshair To Target (LL1: -27 degrees to 27 degrees | LL2: -29.8 to 29.8 degrees)**/
    private NetworkTableEntry tx = table.getEntry("tx");
    /**Vertical Offset From Crosshair To Target (LL1: -20.5 degrees to 20.5 degrees | LL2: -24.85 to 24.85 degrees)*/
    // private NetworkTableEntry ty = table.getEntry("ty");
    // /**Whether the limelight has any valid targets (0 or 1) */
    private NetworkTableEntry tv = table.getEntry("tv");
    // /**Target Area (0% of image to 100% of image) */
    // private NetworkTableEntry ta = table.getEntry("ta");
    // /**Skew or rotation (-90 degrees to 0 degrees) */
    // private NetworkTableEntry ts = table.getEntry("ts");
    // /**Vertical sidelength of the rough bounding box (0 - 320 pixels) */
    // private NetworkTableEntry tvert = table.getEntry("tvert");
    // /**Sidelength of longest side of the fitted bounding box (pixels) */
    // private NetworkTableEntry tlong = table.getEntry("tlong");
    // /**Sidelength of shortest side of the fitted bounding box (pixels) */
    // private NetworkTableEntry tshort = table.getEntry("tshort");
    /**Sets limelight’s LED state
     *0	use the LED Mode set in the current pipeline 
     1	force off
     2	force blink
     3	force on*/
   // private NetworkTableEntry ledMode = table.getEntry("ledMode");
    /**camMode	Sets limelight’s operation mode
0	Vision processor
1	Driver Camera (Increases exposure, disables vision processing) */
//     private NetworkTableEntry camMode = table.getEntry("camMode");
// /**stream	Sets limelight’s streaming mode
// 0	Standard - Side-by-side streams if a webcam is attached to Limelight
// 1	PiP Main - The secondary camera stream is placed in the lower-right corner of the primary camera stream
// 2	PiP Secondary - The primary camera stream is placed in the lower-right corner of the secondary camera stream */
//     private NetworkTableEntry stream = table.getEntry("stream");
 /**pipeline	Sets limelight’s current pipeline
0 .. 9	Select pipeline 0..9 */
    private NetworkTableEntry pipeline = table.getEntry("pipeline");

    public double xOffsetTarget(){
        return tx.getDouble(1);
    }
    public boolean hasTarget(){
        return tv.getDouble(0) == 1;
    }
    public double getPipeLine(){
        return pipeline.getDouble(-1);
    }
    public void setLedMode(LimelightMode mode)
    {
    pipeline.setDouble(mode.getModeValue());     
    }
    public LimelightMode getLimelightMode() {
        double getMode = pipeline.getDouble(LimelightMode.invalid.getModeValue());
        LimelightMode pipeline = LimelightMode.invalid;
       if(getMode == 1){
           pipeline = LimelightMode.forceOff;
       }
       else if(getMode == 2){
           pipeline = LimelightMode.forceBlink;
       }
       else if(getMode ==3){
           pipeline = LimelightMode.forceOn;
       }
        return pipeline;
    }
    }