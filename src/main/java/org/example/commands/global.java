package org.example.commands;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(name = "check", mixinStandardHelpOptions = true, version = "1.0.0",
        description = "Check an algorithm on any positive number",
        optionListHeading = "This is The List of available commands %n",
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
                "isPrime", "isPalindromic", "isFibonacci", "isLucas", "isTriangular", "isPronic",
                "isPolite", "isPerfect", "isPentatope", "isPentagonal", "isOctagonal", "isIcosahedral",
                "isHarshad", "isFermat", "isEven", "isDeficient", "isCullen", "isCatalan",
                "isAutomorphic", "isSphenic"
        };

        boolean flag = false;
        for (String validAlgo : algos) {
            if (algo.equals(validAlgo)) {
                flag = true;
                break;
            }
        }

        if (algo.equals("overview")) {
            printOverview(algos);
        } else if (!flag) {
            printErrorMessage();
        } else {
            String result = SpringClient.FlaskChack(number, algo);
            System.out.println(result);
        }

        return 0;
    }

    private void printOverview(String[] algos) {
        // Header
        System.out.println();
        System.out.println("╔══════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                        NumberWise CLI Overview                           ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════╣");
        System.out.println(String.format("║  Analyzing number: %-52s  ║", number));
        System.out.println("╚══════════════════════════════════════════════════════════════════════════╝");
        System.out.println();

        // Table header
        System.out.println("┌─────────────────────────────┬────────────────────────────────────────────┐");
        System.out.println("│ Algorithm                   │ Result                                     │");
        System.out.println("├─────────────────────────────┼────────────────────────────────────────────┤");

        // Table content
        for (String algorithm : algos) {
            String result = SpringClient.FlaskChack(number, algorithm);
            System.out.println(String.format("│ %-27s │ %-42s │", algorithm, result));
        }

        // Table footer
        System.out.println("└─────────────────────────────┴────────────────────────────────────────────┘");
        System.out.println();
        System.out.println("✓ Analysis completed successfully");
        System.out.println();
    }

    private void printErrorMessage() {
        System.out.println();
        System.out.println("❌ Error: Invalid algorithm specified");
        System.out.println(String.format("   '%s' is not a valid option.", algo));
        System.out.println();
        System.out.println("💡 To see all available algorithms, run:");
        System.out.println("   $ numberwise -h");
        System.out.println();
    }
}