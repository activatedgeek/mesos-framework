package com.activatedgeek.mesosframework;

import org.apache.mesos.MesosSchedulerDriver;
import org.apache.mesos.Scheduler;
import org.apache.mesos.SchedulerDriver;
import org.apache.mesos.Protos.FrameworkInfo;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

public class Main {
    private static String frameworkName = "mesos-framework";
    private static String frameworkVersion = "0.1.0";

    public static void main(String[] args) {
        CommandLineArgs cargs = new CommandLineArgs();
        JCommander cmd = new JCommander(cargs);
        cmd.setProgramName(frameworkName);
        
        try {
            cmd.parse(args);
        } catch (ParameterException e) {
            System.out.println(e.getMessage());
            cmd.usage();
            System.exit(1);
        }
        
        if (cargs.help) {
            cmd.usage();
            System.exit(0);
        }
        
        FrameworkInfo frameworkInfo = FrameworkInfo.newBuilder()
                .setUser("")
                .setName(frameworkName + "-" + frameworkVersion)
                .setFailoverTimeout(cargs.failoverTimeout)
                .build();
        
        Scheduler scheduler = new MainScheduler();
        
        SchedulerDriver driver = new MesosSchedulerDriver(
                scheduler, frameworkInfo, "zk://" + cargs.zookeeperUrl + "/mesos");
        
        driver.run();
    }
}
