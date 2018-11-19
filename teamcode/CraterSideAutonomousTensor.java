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
    private int path=0; //1=left, 2=middle, 3=right
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
        while(path==0){
            path=robot.getGold();
        }

        telemetry.addData("initialized",null);
        telemetry.update();
        waitForStart();

//        robot.unlock();
//        sleep(1000);
//        idle();
//        telemetry.addData("done unlocking","");
//        telemetry.update();
//        idle();


        if(path==1){
            robot.encoderRun(3,.2);
            sleep(1500);
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

            robot.encoderTurn(-21.8,.2);
            sleep(2000);
            robot.finishMovement();
            idle();
            telemetry.addData("run complete","");
            telemetry.update();
            idle();

            robot.encoderRun(41,.2);
            sleep(8000);
            idle();
            robot.finishMovement();
            idle();
            telemetry.addData("run complete","");
            telemetry.update();
            idle();

            robot.encoderRun(-14,.2);
            sleep(3000);
            robot.finishMovement();
            idle();
            telemetry.addData("run complete","");
            telemetry.update();
            idle();


            robot.encoderTurn(-68.2,.2);
            sleep(4000);
            robot.finishMovement();
            idle();
            telemetry.addData("run complete","");
            telemetry.update();
            idle();

            robot.encoderRun(34,.2);
            sleep(4000);
            robot.finishMovement();
            idle();
            telemetry.addData("run complete","");
            telemetry.update();
            idle();

        }
        else if(path==3){
            robot.encoderRun(3,.2);
            sleep(1500);
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

            robot.encoderTurn(21.8,.2);
            sleep(2000);
            robot.finishMovement();
            idle();
            telemetry.addData("run complete","");
            telemetry.update();
            idle();

            robot.encoderRun(41,.2);
            sleep(8000);
            idle();
            robot.finishMovement();
            idle();
            telemetry.addData("run complete","");
            telemetry.update();
            idle();

            robot.encoderRun(-14,.2);
            sleep(3000);
            robot.finishMovement();
            idle();
            telemetry.addData("run complete","");
            telemetry.update();
            idle();


            robot.encoderTurn(-111.8,.2);
            sleep(4000);
            robot.finishMovement();
            idle();
            telemetry.addData("run complete","");
            telemetry.update();
            idle();

            robot.encoderRun(55,.2);
            sleep(6000);
            robot.finishMovement();
            idle();
            telemetry.addData("run complete","");
            telemetry.update();
            idle();

        }
        else{
            robot.encoderRun(41,.2);
            sleep(6000);
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

            robot.encoderRun(-10,.2);
            sleep(3000);
            robot.finishMovement();
            idle();
            telemetry.addData("run complete","");
            telemetry.update();
            idle();


            robot.encoderTurn(-90,.2);
            sleep(4000);
            robot.finishMovement();
            idle();
            telemetry.addData("run complete","");
            telemetry.update();
            idle();

            robot.encoderRun(44,.2);
            sleep(4000);
            robot.finishMovement();
            idle();
            telemetry.addData("run complete","");
            telemetry.update();
            idle();

        }

        robot.encoderTurn(-45,.2);
        sleep(5000);
        robot.finishMovement();
        idle();
        telemetry.addData("run complete","");
        telemetry.update();
        idle();

        robot.encoderRun(62,.2);
        sleep(8000);
        robot.finishMovement();
        idle();
        telemetry.addData("run complete","");
        telemetry.update();
        idle();

        robot.encoderRun(-89,.2);
        sleep(10000);
        robot.finishMovement();
        idle();
        telemetry.addData("run complete","");
        telemetry.update();
        idle();

    }

}