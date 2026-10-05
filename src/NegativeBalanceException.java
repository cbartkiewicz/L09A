import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class NegativeBalanceException extends Exception {

    private double negativeBalance;
    
    public NegativeBalanceException() {
        super("Error: negative balance");
    }

    public NegativeBalanceException(double negativeBalance) {
        super("Amount exceeds balance by " + negativeBalance);
        this.negativeBalance = negativeBalance;

        try (PrintWriter out = new PrintWriter(new FileWriter("logfile.txt", true))) {
            out.println(getMessage());
        } catch (IOException ioe) {
            System.out.println("Could not write to log file: " + ioe.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Balance of " + negativeBalance + " not allowed";
    }
}
