package com.activatedgeek.mesosframework;

import com.beust.jcommander.Parameter;

public class CommandLineArgs {
    @Parameter(names = {"-h", "--help"}, description="Show usage", help = true)
    public boolean help;
}
