package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;


@Autonomous(name = "Crater Tensor Flow")
public class CraterSideAutonomousTensor extends LinearOpMode{
    private Robot robot;

    private int gyroCalibratedCount = 0;
    private double lastHeading = 0;
    private int path=1; //1=left, 2=middle, 3=right
    private double distanceTraveled;

    @Override
    public void runOpMode() {
        robot= new Robot(hardwareMap, telemetry);
        robot.resetEncoders();
        robot.runUsingEncoders();
        while (!robot.isGyroCalibrated()) {
            sleep(50);
            idle();
        }
        //robot.startAccelerationIntegration(initialPosition, initialVelocity,5);
        robot.loop();
        lastHeading = robot.getHeading();
        double finalRuntime=robot.runtime.seconds()+5;
        while(path==0 && finalRuntime>robot.runtime.seconds()){
            path=robot.getGoldVertical();
        }
        sleep(1000);
        //path=robot.getGoldVertical();


        telemetry.addData("initialized",null);
        telemetry.update();
        waitForStart();
        robot.shutdownTensorFlow();

        robot.unlatch();
        sleep(150);
        idle();
        telemetry.addData("done unlatching","");
        telemetry.update();
        idle();

        robot.unlock();
        sleep(2500);
        idle();
        telemetry.addData("done unlocking","");
        telemetry.update();
        idle();

        if(path==1){
            robot.encoderRun(3,.25);
            sleep(500);
            robot.finishMovement();
            idle();
            telemetry.addData("run complete","");
            telemetry.update();
            idle();

            //        robot.moveDownToStart();
//        sleep(1000);
//        idle();
//        telemetry.addData("done unlocking","");
//        telemetry.update();
//        idle();

            robot.encoderTurn(-21.8,.3);
            sleep(1000);
            robot.finishMovement();
            idle();
            telemetry.addData("run complete","");
            telemetry.update();
            idle();

            robot.encoderRun(25,.3);
            sleep(2250);
            idle();
            robot.finishMovement();
            idle();
            telemetry.addData("run complete","");
            telemetry.update();
            idle();

            robot.encoderRun(-6,.25);
            sleep(1000);
            robot.finishMovement();
            idle();
            telemetry.addData("run complete","");
            telemetry.update();
            idle();


            robot.encoderTurn(-68.2,.3);
            sleep(2500);
            robot.finishMovement();
            idle();
            telemetry.addData("run complete","");
            telemetry.update();
            idle();

            robot.encoderRun(34,.3);
            sleep(3000);
            robot.finishMovement();
            idle();
            telemetry.addData("run complete","");
            telemetry.update();
            idle();

        }
        else if(path==3){
            robot.encoderRun(3,.25);
            sleep(500);
            robot.finishMovement();
            idle();
            telemetry.addData("run complete","");
            telemetry.update();
            idle();

            //        robot.moveDownToStart();
//        sleep(1000);
//        idle();
//        telemetry.addData("done unlocking","");
//        telemetry.update();
//        idle();

            robot.encoderTurn(21.8,.3);
            sleep(1000);
            robot.finishMovement();
            idle();
            telemetry.addData("run complete","");
            telemetry.update();
            idle();

            robot.encoderRun(25,.3);
            sleep(2250);
            idle();
            robot.finishMovement();
            idle();
            telemetry.addData("run complete","");
            telemetry.update();
            idle();

            robot.encoderRun(-6,.25);
            sleep(1000);
            robot.finishMovement();
            idle();
            telemetry.addData("run complete","");
            telemetry.update();
            idle();


            robot.encoderTurn(-111.8,.35);
            sleep(3500);
            robot.finishMovement();
            idle();
            telemetry.addData("run complete","");
            telemetry.update();
            idle();

            robot.encoderRun(55,.35);
            sleep(5000);
            robot.finishMovement();
            idle();
            telemetry.addData("run complete","");
            telemetry.update();
            idle();

        }
        else{
            robot.encoderRun(27,.25);
            sleep(2500);
//        robot.moveDownToStart();
//        sleep(3000);
//        idle();
//        telemetry.addData("done unlocking","");
//        telemetry.update();
//        idle();

            robot.finishMovement();
            idle();
            telemetry.addData("run complete","");
            telemetry.update();
            idle();

            robot.encoderRun(-4,.2);
            sleep(500);
            robot.finishMovement();
            idle();
            telemetry.addData("run complete","");
            telemetry.update();
            idle();

            robot.encoderTurn(-90,.25);
            sleep(2500);
            robot.finishMovement();
            idle();
            telemetry.addData("run complete","");
            telemetry.update();
            idle();

            robot.encoderRun(41,.2);
            sleep(4500);
            robot.finishMovement();
            idle();
            telemetry.addData("run complete","");
            telemetry.update();
            idle();

        }

        robot.encoderTurn(-45,.3);
        sleep(1250);
        robot.finishMovement();
        idle();
        telemetry.addData("run complete","");
        telemetry.update();
        idle();

        robot.encoderRun(37,.3);
        sleep(3000);
        robot.finishMovement();
        idle();
        telemetry.addData("run complete","");
        telemetry.update();
        idle();

        robot.encoderTurn(-90,.3);
        sleep(2000);
        robot.finishMovement();
        idle();
        telemetry.addData("run complete","");
        telemetry.update();
        idle();

        robot.deployTeamMarker();
        idle();
        sleep(500);
        telemetry.addData("Team Marker Deployed","");
        telemetry.update();
        idle();

        robot.encoderTurn(-115,.35);
        sleep(2500);
        robot.finishMovement();
        idle();
        telemetry.addData("run complete","");
        telemetry.update();
        idle();

        robot.encoderRun(60,.4);
        sleep(8000);
        robot.finishMovement();
        idle();
        telemetry.addData("run complete","");
        telemetry.update();
        idle();

        //Jason can I touch your face?
        //Type answer here:


    }

}