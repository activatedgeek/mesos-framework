package com.activatedgeek.mesosframework;

import org.apache.mesos.MesosSchedulerDriver;
import org.apache.mesos.Scheduler;
import org.apache.mesos.SchedulerDriver;
import org.apache.mesos.Protos.FrameworkInfo;

public class Main {
    private static String frameworkName = "mesos-framework";
    private static String frameworkVersion = "0.1.0";

    public static void main(String[] args) {
        FrameworkInfo frameworkInfo = FrameworkInfo.newBuilder()
                .setUser("")
                .setName(frameworkName + "-" + frameworkVersion)
                .setFailoverTimeout(3600 * 7)
                .build();
        
        Scheduler scheduler = new MainScheduler();
        
        SchedulerDriver driver = new MesosSchedulerDriver(
                scheduler, frameworkInfo, "zk://" + args[0] + "/mesos");
        driver.run();
    }
}
