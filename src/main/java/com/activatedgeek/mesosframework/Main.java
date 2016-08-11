package com.activatedgeek.mesosframework;

import com.activatedgeek.mesosframework.CommandLineArgs;
import com.beust.jcommander.JCommander;

public class Main {
    public static void main(String[] args) {
        CommandLineArgs cli = new CommandLineArgs();
        JCommander cmd = new JCommander(cli);
        
        try {
            cmd.parse(args);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            cmd.usage();
            System.exit(1);
        }
        
        if (cli.help == true) {
            cmd.usage();
        }
    }
}
