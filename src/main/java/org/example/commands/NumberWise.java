package org.example.commands;
import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.util.concurrent.Callable;

@Command(name = "NumberWise", mixinStandardHelpOptions = true, version = "1.0.0",
        description = "Number Wise : is A Number Theory CLI %n" ,
        subcommands = {  global.class } ,
        optionListHeading = "This is The List of available commands %n"  ,
        commandListHeading = "This is The List of Subcommands %n"
)
public class NumberWise implements Callable<Integer>  {
    @Override
    public Integer call() throws Exception {
        return 0 ;
    }
    public static void main(String[] args) {
        int exitCode = new CommandLine(new NumberWise()).execute( args );
        System.exit(exitCode);
    }
}
