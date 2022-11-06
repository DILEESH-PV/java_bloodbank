import java.sql.*;
import java.util.Scanner;

public class Bloodbank {
        public static void main(String[] args)
        {

            int choice;
            String name,address,bg,gender;
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
                System.out.println("6. Search donor by specific letter in name ");
                System.out.println("7. Display donor details by blood bllod group category");
                System.out.println("8. Total number of donors by category");
                System.out.println("9. Display minimum donor age");
                System.out.println("10.Display maximum donor age");
                System.out.println("11.Exit\n");

                choice=sc.nextInt();
                switch(choice)
                {
                    case 1:
                        System.out.println("Enter the donor name");
                        name=sc.next();
                        System.out.println("Enter the address of donor");
                        address=sc.next();
                        System.out.println("Enter the phone number");
                        phno=sc.nextDouble();
                        System.out.println("Enter the age");
                        age=sc.nextInt();
                        System.out.println("Enter the gender");
                        gender=sc.next();
                        System.out.println("Enter the blood group");
                        bg=sc.next();
                        System.out.println("New donor added\n");
                        try
                        {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbankdb","root","");
                            String sql="INSERT INTO `donor`(`name`, `address`, `phno`, `age`, `sex`, `bloodgp`) VALUES (?,?,?,?,?,?)";
                            PreparedStatement stmt= con.prepareStatement(sql);
                            stmt.setString(1,name);
                            stmt.setString(2,address);
                            stmt.setDouble(3,phno);
                            stmt.setInt(4,age);
                            stmt.setString(5,gender);
                            stmt.setString(6,bg);
                            stmt.executeUpdate();
                        }
                        catch (Exception e)
                        {
                            System.out.println(e);
                        }


                        break;
                    case 2:
                        System.out.println("view all donors selected");
                        try{
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbankdb","root","");
                            String sql="SELECT `name`, `address`, `phno`, `age`, `sex`, `bloodgp` FROM `donor` ";
                            Statement stmt=con.createStatement();
                            ResultSet rs=stmt.executeQuery(sql);
                            while (rs.next())
                            {
                                String getName=rs.getString("name");
                                String getAddress=rs.getString("address");
                                String getPhno=rs.getString("phno");
                                String getAge=rs.getString("age");
                                String getGender=rs.getString("sex");
                                String getBg=rs.getString("bloodgp");
                                System.out.println("Donor Name     : "+getName);
                                System.out.println("Address        : "+getAddress);
                                System.out.println("Phone Number   : "+getPhno);
                                System.out.println("Age            : "+getAge);
                                System.out.println("Gender         : "+getGender);
                                System.out.println("Blood Group    : "+getBg+"\n");

                            }
                        }catch (Exception e){
                            System.out.println(e);}

                        break;
                    case 3:
                        System.out.println("Enter the donor name for seaching ");
                        String na=sc.next();
                        try {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbankdb", "root", "");
                            String sql = "SELECT `name`, `address`, `phno`, `age`, `sex`, `bloodgp` FROM `donor` WHERE `name`='"+na+"'";
                            Statement stmt = con.createStatement();
                            ResultSet rs = stmt.executeQuery(sql);
                            while (rs.next()) {
                                String getName=rs.getString("name");
                                String getAddress=rs.getString("address");
                                String getPhno=rs.getString("phno");
                                String getAge=rs.getString("age");
                                String getGender=rs.getString("sex");
                                String getBg=rs.getString("bloodgp");
                                System.out.println("Donor Name     : "+getName);
                                System.out.println("Address        : "+getAddress);
                                System.out.println("Phone Number   : "+getPhno);
                                System.out.println("Age            : "+getAge);
                                System.out.println("Gender         : "+getGender);
                                System.out.println("Blood Group    : "+getBg+"\n");

                            }
                        }
                        catch (Exception e)
                        {
                            System.out.println(e);
                        }


                        break;
                    case 4:
                        System.out.println("Enter the donor name");
                        String nam=sc.next();
                        System.out.println("Enter the address of donor to be updated");
                        address=sc.next();
                        System.out.println("Enter the phone number to be updated");
                        phno=sc.nextDouble();
                        System.out.println("Enter the age to be updated");
                        age=sc.nextInt();
                        try {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbankdb", "root", "");
                            String sql = "UPDATE `donor` SET `address`='"+address+"',`phno`='"+phno+"',`age`='"+age+"' WHERE `name`='"+nam+"'";
                            Statement stmt = con.createStatement();
                            stmt.executeUpdate(sql);
                            System.out.println("updated successfully");
                        }
                        catch (Exception e){
                            System.out.println(e);}

                        break;
                    case 5:
                        System.out.println("Enter the name for deleting a donor");
                        String name1=sc.next();
                        try {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbankdb", "root", "");
                            String sql = "DELETE FROM `donor` WHERE `name`='"+name1+"'";
                            Statement stmt = con.createStatement();
                            stmt.executeUpdate(sql);
                            System.out.println("deleted successfully");
                        }
                        catch (Exception e){
                            System.out.println(e);}

                        break;
                    case 6:
                        System.out.println("Enter the letter to search the donor");
                        String sl=sc.next();
                        try {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbankdb", "root", "");
                            String sql = "SELECT `name`, `address`, `phno`, `age`, `sex`, `bloodgp` FROM `donor` WHERE `name` LIKE '"+sl+"%'";
                            Statement stmt = con.createStatement();
                            ResultSet rs = stmt.executeQuery(sql);
                            while (rs.next()) {
                                String getName=rs.getString("name");
                                String getAddress=rs.getString("address");
                                String getPhno=rs.getString("phno");
                                String getAge=rs.getString("age");
                                String getGender=rs.getString("sex");
                                String getBg=rs.getString("bloodgp");
                                System.out.println("Donor Name     : "+getName);
                                System.out.println("Address        : "+getAddress);
                                System.out.println("Phone Number   : "+getPhno);
                                System.out.println("Age            : "+getAge);
                                System.out.println("Gender         : "+getGender);
                                System.out.println("Blood Group    : "+getBg+"\n");

                            }
                        }
                        catch (Exception e)
                        {
                            System.out.println(e);
                        }break;
                    case 7:
                        System.out.println("Enter the blood group");
                        String bg1=sc.next();
                        try {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbankdb", "root", "");
                            String sql ="SELECT `name`, `address`, `phno`, `age`, `sex`, `bloodgp` FROM `donor` WHERE `bloodgp`='"+bg1+"'";
                            Statement stmt = con.createStatement();
                            ResultSet rs = stmt.executeQuery(sql);
                            while (rs.next()) {
                                String getName=rs.getString("name");
                                String getAddress=rs.getString("address");
                                String getPhno=rs.getString("phno");
                                String getAge=rs.getString("age");
                                String getGender=rs.getString("sex");
                                String getBg=rs.getString("bloodgp");
                                System.out.println("Donor Name     : "+getName);
                                System.out.println("Address        : "+getAddress);
                                System.out.println("Phone Number   : "+getPhno);
                                System.out.println("Age            : "+getAge);
                                System.out.println("Gender         : "+getGender);
                                System.out.println("Blood Group    : "+getBg+"\n");

                            }
                        }
                        catch (Exception e)
                        {
                            System.out.println(e);
                        }
                        break;
                    case 8:
                        try {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbankdb", "root", "");
                            String sql = "SELECT COUNT(`id`) `id`,`bloodgp` FROM `donor` GROUP BY`bloodgp`";
                            Statement stmt = con.createStatement();
                            ResultSet rs = stmt.executeQuery(sql);
                            while (rs.next()) {
                                String getId = rs.getString("id");
                                String getBg = rs.getString("bloodgp");
                                System.out.println("Count : " + getId + "    " + getBg + "\n");
                            }
                        }
                        catch (Exception e)
                        {
                            System.out.println(e);}break;

                    case 9:
                        try {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbankdb", "root", "");
                            String sql = "SELECT MIN(`age`) `age`,`name`,`address`,`phno` FROM `donor`";
                            Statement stmt = con.createStatement();
                            ResultSet rs = stmt.executeQuery(sql);
                            while (rs.next()) {
                                String getAge = rs.getString("age");
                                String getName = rs.getString("name");
                                String getAddress=rs.getString("address");
                                String getPhno=rs.getString("phno");
                                //String getBg = rs.getString("bloodgp");
                                System.out.println("Younger donor details");
                                System.out.println("Name     : "+getName);
                                System.out.println("Age      :"+getAge);
                                System.out.println("Address  :"+getAddress);
                                System.out.println("Ph No    :"+getPhno+"\n");
                            }
                        }
                        catch (Exception e)
                        {
                            System.out.println(e);
                        }
                        break;
                    case 10:
                        try {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbankdb", "root", "");
                            String sql = "SELECT MAX(`age`) `age`,`name`,`address`,`phno` FROM `donor`";
                            Statement stmt = con.createStatement();
                            ResultSet rs = stmt.executeQuery(sql);
                            while (rs.next()) {
                                String getAge = rs.getString("age");
                                String getName = rs.getString("name");
                                String getAddress=rs.getString("address");
                                String getPhno=rs.getString("phno");
                                //String getBg = rs.getString("bloodgp");
                                System.out.println("Elder donor details");
                                System.out.println("Name     : "+getName);
                                System.out.println("Age      :"+getAge);
                                System.out.println("Address  :"+getAddress);
                                System.out.println("Ph No    :"+getPhno+"\n");
                            }
                        }
                        catch (Exception e)
                        {
                            System.out.println(e);
                        }
                        break;

                    case 11:
                        System.exit(0);
                    default:
                        System.out.println("Enter correct choice");
                }

            }
        }
    }

