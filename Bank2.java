import java.util.Scanner;

public class Bank2 {
        static final int ID = 0;
    static final int LOAN = 1;
    static double[][][] mBanks;
    public static void main(String[] args) {



        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of banks: ");
        int n = input.nextInt(); 
        System.out.print("Enter minimum limit: ");
        int limit = input.nextInt(); 

        mBanks = new double[n][][];


        for (int i = 0; i < mBanks.length; i++) {
            System.out.println("Enter bank #"+i+" > ");
            System.out.print("Enter the current balance: ");
            double balance = input.nextDouble();
            System.out.print("Enter number of banks who borrowed from bank "+i+" : ");
            int numBanks = input.nextInt();
            mBanks[i] = new double[++numBanks][2];
            mBanks[i][0][0] = balance; // banks balance
            
            for (int bank = 1; bank < mBanks[i].length; bank++) {
                System.out.print("Enter the bank who borrowed from bank "+i+" : ");
                mBanks[i][bank][ID] = input.nextDouble();
                System.out.print("Enter the amount borrowed from the bank : ");
                mBanks[i][bank][LOAN] = input.nextDouble();
            }

        }
        System.out.println("");
        displayMatrix(mBanks);
        boolean[] unsafeIndex = scanBanks(mBanks, limit);

        for (int i = 0; i < unsafeIndex.length; i++) {
            System.out.println("Bank# " + i + " unsafe: " +unsafeIndex[i] );
        }
        input.close();

    }

    public static boolean[] scanBanks(double[][][] m, int limit) {

        boolean[] indexUnsafeBanks = new boolean[m.length];
        double total;
        boolean isSafe = false;
       
        while (!isSafe) {
            isSafe = true; 
            for (int banks = 0; banks < m.length; banks++) {
                total = m[banks][0][0];
                for (int LoanedBanks = 1; LoanedBanks < m[banks].length; LoanedBanks++) {
                    int index = (int)m[banks][LoanedBanks][ID];
                    if (!indexUnsafeBanks[index])
                        total += m[banks][LoanedBanks][LOAN];
                }
                
                if (total < limit && !indexUnsafeBanks[banks]) {
                    indexUnsafeBanks[banks] = true;
                    isSafe = false;
                }
            }
        }
        return indexUnsafeBanks;
    }


    public static void displayMatrix(double[][][] m) {

        System.out.printf("%-5s%-5s%-5s%-5s%-5s%-5s%-5s\n",
                "bank # |", "balance |", "Loaned# |", "Bank ID |", "Amounts |", "Bank ID |", "Amounts |");
        for (int banks = 0; banks < m.length; banks++) {
            System.out.printf("%-7d|%8.2f|%8d|", banks, m[banks][0][0], m[banks].length -1);

            for (int LoanedBanks = 1; LoanedBanks < m[banks].length; LoanedBanks++) {
                System.out.printf("%8.0f|%8.2f|", m[banks][LoanedBanks][ID], m[banks][LoanedBanks][LOAN]);
            }
            System.out.println("");
        }
    }


}
