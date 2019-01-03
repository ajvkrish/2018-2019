package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;

import java.util.List;

@TeleOp(name = "Two Controller TeleOp", group = "Two controller")
public class TwoControllerTeleOp extends OpMode {

    private Robot robot;
    private Controller controller1;
    private Controller controller2;
    private int gyroCalibratedCount = 0;

    private boolean gyroRotate;
    private boolean tankDrive=false;
    private double targetAngle;
    private double currentAngle;
    private double angleDifference;
    private double angleDirection;
//    private Position initialPosition;
//    private Velocity initialVelocity;

    private double governor = 0.75;
    private double rotationGovernor = 0.3;
    private double lastHeading = 0.0;
//    private boolean accelerometerCalibrated=false;

//    private List<VuforiaTrackable> allTrackables=null;

    @Override
    public void init() {
        robot = new Robot(hardwareMap, telemetry);
        robot.runUsingEncoders();
        controller1 = new Controller(gamepad1);
        controller2 = new Controller(gamepad2);
//        initialPosition= new Position(DistanceUnit.METER,0,0,0,0);
//        initialVelocity= new Velocity(DistanceUnit.METER,0,0,0,0);
       // allTrackables=robot.vuforiaInit();
        robot.shutdownTensorFlow();
    }

    @Override
    public void init_loop() {
        controller1.update();
        controller2.update();

        if (robot.isGyroCalibrated()) {
            robot.loop();
            lastHeading = robot.getHeading();
        }

//        if (robot.isAccelerometerCalibrated() && !accelerometerCalibrated) {
//            robot.startAccelerationIntegration(initialPosition, initialVelocity, 5);
//            accelerometerCalibrated=true;
//        }
//        //robot.vuforiaLoop(allTrackables);
        telemetry.addData("Gyro Ready?", robot.isGyroCalibrated() ? "YES" : "no.");
       // telemetry.addData("Accelerometer Ready?", robot.isAccelerometerCalibrated() ? "YES" : "no.");
        telemetry.update();
    }

    @Override
    public void loop() {
        controller1.update();
        controller2.update();
        robot.loop();
        //robot.vuforiaLoop(allTrackables);
        if (controller1.XOnce()) {
            robot.resetHeading();
        }

        double heading = robot.getHeading();
        double headingDelta = 0.0;
//        if(controller1.dpadDown()){
//            robot.moveLifterDown();
//        } else if(controller1.dpadUp()) {
//            robot.moveLifterUp();
//        } else {
//            robot.stopLifter();
//        }
//
//    if (controller1.YOnce()){
//            robot.toggleLifter();
//    }

        /*if(controller2.rightBumperOnce())
            robot.faceSideCryptoBox();
        else if(robot.rotating)
            robot.rotatingTowardsCryptoBox();
        else*/

//        if(controller1.XOnce())
//            tankDrive=!tankDrive;
//
//        robot.rotation = controller1.left_stick_x;
//
//
//        final double speed = Math.min(governor, Math.abs(controller1.left_stick_y));
//        double direction = controller1.left_stick_y/Math.abs(controller1.left_stick_y);
//
//        if(controller1.right_stick_x>.05 || controller1.right_stick_x<(-.05) || controller1.right_stick_y>.05 || controller1.right_stick_y<(-.05))
//            gyroRotate=true;
//        else
//            gyroRotate=false;
//
//
//        targetAngle=Math.atan(controller1.right_stick_y/controller1.right_stick_x);
//        currentAngle=robot.getHeading();
//
//        if(currentAngle<(-1*Math.PI))
//            currentAngle+=2*Math.PI;
//        if(currentAngle>(Math.PI))
//            currentAngle-=2*Math.PI;
//        if(targetAngle<(-1*Math.PI))
//            targetAngle+=2*Math.PI;
//        if(targetAngle>(Math.PI))
//            targetAngle-=2*Math.PI;
//
//        angleDirection=Math.abs(targetAngle)/targetAngle;
//
//        if(gyroRotate=true)
//            robot.rotation= (targetAngle-currentAngle)/Math.PI;
//
//        double leftPower = speed*direction+robot.rotation*rotationGovernor;
//        double rightPower = speed*direction-robot.rotation*rotationGovernor;
//
//        telemetry.addData("Speed: ", speed);
//        telemetry.addData("Direction: ", direction);
//        telemetry.addData("Robot.Rotation: ",robot.rotation);
//        telemetry.addData("Is Blue on Left? ",robot.isBlueOnLeft());

        //if(tankDrive){
        double leftPower=Math.pow(controller1.left_stick_y,3);
        double rightPower=Math.pow(controller1.right_stick_y,3);
        //}
        if(robot.flippingOver()){
            leftPower=1;
            rightPower=1;
        }
        robot.setMotors(leftPower, rightPower);


        if(controller2.rightTriggerPressed())
            robot.moveSweeper(controller2.right_trigger);
        else
            robot.moveSweeper(-1*controller2.left_trigger);
        if(controller2.A())
            robot.moveSweeper(1);

        if(controller2.AOnce())
            robot.incrementTmUp();
        if(controller2.BOnce())
            robot.incrementTmDown();
        if(controller2.XOnce()) {
            if (robot.getTmPosition() == 0)
                robot.deployTeamMarker();
            else
                robot.undeployTeamMarker();
        }
        //telemetry.addData("Team Marker Position:",robot.getTmPosition());
//        if (controller1.right_trigger>.05)
//            robot.moveFlipper(controller1.right_trigger * .15 * -1);
//        else if (controller1.left_trigger>.05)
//            robot.moveFlipper(controller1.left_trigger * .15);
//        else
//            robot.moveFlipper(0);

//        if(controller1.Y())
//            robot.moveLifterUp();
//        else if(controller1.B())
//            robot.moveLifterDown();
//        else
//            robot.stopLifter();

//        if(controller1.XOnce())
//            robot.startFlip();
//        if(robot.isFlip())
//            robot.flip();
//        if(robot.doneFlip)
//            robot.doneFlip();
//        if(robot.finishingFlip)
//            robot.flippingBack();
//


//        if(controller2.YOnce())
//            robot.toggleLifter();
//        if(controller2.XOnce())
//            robot.customtoggleLifter();


        robot.moveLifter(controller2.left_stick_y);

        robot.setFlipperPower(controller2.right_stick_y);
//        telemetry.addData("Current Position: ",robot.currentPosition);
//        telemetry.addData("X: ",robot.currentPosition.x);
//        telemetry.addData("Y: ",robot.currentPosition.y);
//        telemetry.addData("Z: ",robot.currentPosition.z);
//        telemetry.addData("Current Velocity: ", robot.currentVeloity);
//        telemetry.addData("Current Acceleration: ", robot.currentAcceleration);
//        robot.getGold();
//        telemetry.addData("Lifter Ticks: ", robot.getLifterPosition());
//        telemetry.addData("Flipper Ticks: ", robot.getFlipperPosition());
//        telemetry.addData("Left Ticks: ", robot.getLeftPosition());
//        telemetry.addData("Right Ticks: ", robot.getRightPosition());
        telemetry.addData("Flipper Ticks: ",robot.getFlipperPosition());
        robot.getGyroGravity();
        telemetry.update();
    }
}

