package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "TeleOp Practice")
public class TeleOpPractice extends OpMode {

    private Robot robot;
    private Controller controller1;
    private Controller controller2;
    private boolean arcadeMode = true;
    private int gyroCalibratedCount = 0;

    private double governor = 0.75;
    private double rotationGovernor = 0.3;
    private double lastHeading = 0.0;

    @Override
    public void init() {
        robot = new Robot(hardwareMap, telemetry);
        robot.runUsingEncoders();
        controller1 = new Controller(gamepad1);
        controller2 = new Controller(gamepad2);
    }

    @Override
    public void init_loop() {
        controller1.update();
        controller2.update();

        if (robot.isGyroCalibrated()) {
            robot.loop();
            lastHeading = robot.getHeading();
        }

        telemetry.addData("Gyro Ready?", robot.isGyroCalibrated() ? "YES" : "no.");
        telemetry.update();
    }

    @Override
    public void loop() {
        controller1.update();
        controller2.update();
        robot.loop();

        if (controller1.XOnce()) {
            robot.resetHeading();
        }

        double heading = robot.getHeading();
        double headingDelta = 0.0;

        double leftPower= controller1.left_stick_y;
        double rightPower=controller1.right_stick_y;

        robot.setMotors(leftPower, rightPower);




        telemetry.update();
    }
}

