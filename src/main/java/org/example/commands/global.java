package org.example.commands;


import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(name = "check", mixinStandardHelpOptions = true, version = "1.0.0",
        description = "Check an algorithm on any positive number"  ,
        optionListHeading = "This is The List of available commands %n"  ,
        commandListHeading = "This is The List of Subcommands %n"
)
public class global implements Callable<Integer> {
    @Parameters(index = "1", description = "The number to check for primality.%n")
    String number;
    @Parameters(index = "0", description = "isPrime , isPalindromic , isFibonacci , isLucas %n , isTriangular , isPronic , isPolite , isPerfect %n , isPentatope , isPentagonal %n , isOctgonal , isIcosahedral , isHarshad %n , isFermat , isEven , isDeficient , isCullen , isCatalan %n , isAutomorphic , isSphenic ,  Overview%n")
    public String algo;

    @Override
    public Integer call() throws Exception {
        // Call the Flask API to check if the number is prime
        String[] algos = new String[]{
                "isPrime", "isPalindromic", "isFibonacci", "isLucas", "isTriangular", "isPronic", "isPolite", "isPerfect", "isPentatope", "isPentagonal", "isOctagonal", "isIcosahedral", "isHarshad", "isFermat", "isEven", "isDeficient", "isCullen", "isCatalan", "isAutomorphic", "isSphenic"
        };
        boolean flag = false;
        for (int i = 0; i < algos.length; ++i) {
            if (algo.equals(algos[i])) {
                flag = true;
                break;
            }
        }
        if (algo.equals("overview")) {
            System.out.println("      ******   The NumberWise CLI Overview   ******");
            System.out.println(String.format("      Checking properties for number: %s", number));
            System.out.println();

            System.out.println("      +-------------------------+-------------------------------------------");
            System.out.println("      | Algorithm               | Result                     ");
            System.out.println("      +-------------------------+-------------------------------------------");

            for (String a : algos) {
                String result = SpringClient.FlaskChack(number, a);
                // Format each result with consistent spacing
                System.out.println(String.format("      | %-23s | %-26s ", a, result));
            }

            System.out.println("      +-------------------------+--------------------------------------------");
            System.out.println();
            System.out.println("      *************   End of Overview   **********************");
        }
        else if (!flag) {
            System.out.println("You need To provide a valid algorithm");
            System.out.println( algo + "Is not a valid option You can check The available options via :");
            System.out.println("$ numberwise -h ");

        } else {
            String result = SpringClient.FlaskChack(number, algo);
            System.out.println(result);
        }

        return 0 ;
    }
}
