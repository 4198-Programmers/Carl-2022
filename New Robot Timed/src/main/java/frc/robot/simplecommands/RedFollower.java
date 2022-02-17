package frc.robot.simplecommands;

import org.opencv.core.KeyPoint;
import org.opencv.core.Mat;
import org.opencv.core.MatOfKeyPoint;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.CvSink;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.GripPipelineRed;

public class RedFollower extends CommandBase{
    private GripPipelineRed redDetect = new GripPipelineRed();
    UsbCamera camera = CameraServer.startAutomaticCapture();
    CvSink sink = new CvSink("Sink Name");

    public RedFollower(UsbCamera cameraArg)
    {
        camera = cameraArg;
    }

    @Override
    public void execute() {
        Mat matImage = new Mat();
        if (sink.grabFrame(matImage) == 0)
        {
            redDetect.process(matImage);
            MatOfKeyPoint blobs = redDetect.findBlobsOutput();
            KeyPoint[] blobPoints = blobs.toArray();

            if (blobPoints.length > 0)
            {
                
            }
        }
    }
    
}
