import java.util.Scanner;

public class Bloodbank {
        public static void main(String[] args)
        {

            int choice;
            String name,address,bg,sex;
            int age;
            double phno;

            Scanner sc=new Scanner(System.in);
            while (true)
            {
                System.out.println("Select an option");
                System.out.println("1. Add donor");
                System.out.println("2. view all donors");
                System.out.println("3. search a donor");
                System.out.println("4. update donor");
                System.out.println("5. Delete donor");
                System.out.println("6.Exit");

                choice=sc.nextInt();
                switch(choice)
                {
                    case 1:
                        System.out.println("Add donor selected");


                        break;
                    case 2:
                        System.out.println("view all donors selected");

                        break;
                    case 3:
                        System.out.println("search a donor selected");

                        break;
                    case 4:
                        System.out.println("update donor selected");
                        break;
                    case 5:
                        System.out.println("Delete a donor selected");

                        break;
                    case 6:
                        System.exit(0);
                    default:
                        System.out.println("Enter correct choice");
                }

            }
        }
    }

