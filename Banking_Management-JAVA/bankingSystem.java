import java.util.Scanner; 
 
public class bankingSystem { 
 public static void main(String[] args) { 
    Scanner sc = new Scanner(System.in); 
    account acc= new account();
    account[] accounts = new account[100];
    int count = 0;
    System.out.println("1. Create account:");
    System.out.println("2. View account details");
    System.out.println("3. Deposit");
    System.out.println("4. Withdraw");
    System.out.println("5. Check Balance");
    System.out.println("6. Exit");

    int accountnumber = 1000;
    
    while(true) {
    System.out.print("Enter your choice:");
    int choice = sc.nextInt();
    switch (choice) {
      case 1 :
         System.out.println("Creating account");
        accounts[count] = new account();

         sc.nextLine();
         System.out.print("Enter holder name:"); 
           String name = sc.nextLine(); 
            accounts[count].accountname = name;

         System.out.print("Enter your initial amount deposit:"); 
           double initial = sc.nextDouble();

         accounts[count].balance = initial;
         accountnumber++ ;
         accounts[count].accountnumber = accountnumber;
         System.out.println("your account number is :" + accounts[count].accountnumber);
         count++ ;
         break;
      case 2:
         System.out.println("view account details");
         System.out.print("Enter account number: ");
         int searchAccount = sc.nextInt();

         boolean found = false;

         for (int i = 0; i < count; i++) {
             if (accounts[i].accountnumber == searchAccount) {

               System.out.println("Account Number: " + accounts[i].accountnumber);
               System.out.println("Name: " + accounts[i].accountname);
               System.out.println("Balance: " + accounts[i].balance);

             found = true;
            break;
           }
        }

      if (!found) {
         System.out.println("No account found !!");
      }
      break;
     
      case 3 :
         System.out.println("deposit");
         System.out.print("Enter account number: ");
         int depositAccount = sc.nextInt();

         boolean depositFound = false;

         for (int i = 0; i < count; i++) {
            if (accounts[i].accountnumber == depositAccount) {
  
             System.out.print("Enter the amount to deposit: ");
             double deposit = sc.nextDouble();

            accounts[i].balance = accounts[i].balance + deposit;

            System.out.println("Deposited Successfully !!");
            System.out.println("Current amount: " + accounts[i].balance);

            depositFound = true;
           break;
           }
         }

         if (!depositFound) {
           System.out.println("No account found !!");
         }
         break;

      case 4 :
         System.out.println("withdraw"); 
         
         System.out.print("Enter account number: ");
         int withdrawAccount = sc.nextInt();

         boolean withdrawFound = false;

         for (int i = 0; i < count; i++) {
            if (accounts[i].accountnumber == withdrawAccount) {

              System.out.print("Enter the amount to withdraw: ");
              double withdraw = sc.nextDouble();

              if (withdraw <= accounts[i].balance) {
                 accounts[i].balance = accounts[i].balance - withdraw;

                 System.out.println("Withdraw Successfully !!");
                 System.out.println("Current amount: " + accounts[i].balance);
               } else {
                 System.out.println("Insufficient balance !!");
               }

               withdrawFound = true;
               break;
            }
          }

         if (!withdrawFound) {
           System.out.println("No account found !!");
          }

        break;
      case 5:
         System.out.println("check balance");

         System.out.print("Enter account number: ");
         int balanceAccount = sc.nextInt();

         boolean balanceFound = false;

        for (int i = 0; i < count; i++) {
           if (accounts[i].accountnumber == balanceAccount) {

            System.out.println("Current balance: " + accounts[i].balance);

            balanceFound = true;
            break;
        }
    }

         if (!balanceFound) {
           System.out.println("No account found !!");
    }

    break;
      case 6 :
         System.out.println("Thank you for being a part");
         System.exit(0);

      default:
         System.out.println("Invalid");
         break;
    }
   }
 } 
     
} 
