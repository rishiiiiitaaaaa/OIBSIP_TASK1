import java.util.*;

class bank {
    String name, transactionHistory = "", transaction;
    int Acc_num, user_pin;
    float balance ;

    void info(String n, int a) {
        name = n;
        Acc_num = a;
    }

    void display() {

        System.out.println("Transaction Performed Successfully\n");
        System.out.println("----------------Thank You---------------");
    }

    void withdraw(int w) {
        if (w > balance) {
            System.out.println("Insufficient balance");
        } else {
            balance -= w;
            System.out.println("Updated  balance= " + balance);
        }
        String optr = ("withdraw of amount = " + w);
        transactionHistory = transactionHistory.concat(optr).concat("\n");
    }

    void deposit(int d) {
        balance += d;
        System.out.println("Updated  balance= " + balance);
        String optr = ("deposit of amount = " + d);
        transactionHistory = transactionHistory.concat(optr).concat("\n");
    }

    void transfer(int t) {
        balance -= t;

        System.out.println("Updated  balance= " + balance);
        String optr = ("transfer of amount = " + t );
        transactionHistory = transactionHistory.concat(optr).concat("\n");
    }

    void perform_transaction(Scanner x) {
        System.out.println("Please select the operations to be performed:\n 1)Transaction History\n 2)Withdraw\n 3)Deposit\n 4)Tranfer\n 5)Quit");
        int n = x.nextInt();

        info(name, Acc_num);
        switch (n) {

            case 1:
                System.out.println("Transactiona are :\n" + transactionHistory);

                break;
            case 2:
                System.out.println("Enter amount to be withdrawn: ");
                int w = x.nextInt();
                withdraw(w);
                break;
            case 3:
                System.out.println("Enter amount to be deposited: ");
                int d = x.nextInt();
                deposit(d);
                break;
            case 4:
                System.out.println("Enter amount to be Transferred: ");
                int t = x.nextInt();
                System.out.println("Enter username of the person : ");
                String t1 = x.next();
                System.out.println("Amount is Transferred to " + t1);
                transfer(t);
                break;
            case 5:
                System.out.println("Execution Completed \nThank You Visit Again ");
                break;
            default:
                System.out.println("Information of user: ");
                break;
        }

    }
}

class atm {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        System.out.println("----------- WELCOME TO ATM --------------");
        System.out.println("----------- ENTER LOGIN DETAILS --------------");
        System.out.println("Enter UserId: ");
        String name = x.nextLine();
        System.out.println("Enter Pin: ");
        String user_pin = x.nextLine();
        System.out.println("Enter Account number: ");
        int Acc_num = x.nextInt();
        System.out.println("------------Login Successful--------------");

        boolean quit = false;
        bank b = new bank();

        do {

            b.perform_transaction(x);

        } while (!quit);

        b.display();
    }
}