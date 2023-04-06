import java.util.*;

public class Main {
    public static void main(String[] args) {
        EmployeeMap staff = new EmployeeMap();
        staff.hireEmployee(new Employee("Harry", "Potter", 3, 11.0));
        staff.hireEmployee(new Employee("Hermoine", "Granger", 3, 55.5));
        staff.hireEmployee(new Employee("Ron", "Weasley", 3, 9.75));
        staff.hireEmployee(new Employee("Albus", "Dumbledore", 1, 100500.0));
        staff.hireEmployee(new Employee("Rubeus", "Hagrid", 2, 5.0));
        staff.hireEmployee(new Employee("Severus", "Snape", 2, 500.0));
        staff.hireEmployee(new Employee("Drako", "Malfoy", 4, 499.0));
        staff.hireEmployee(new Employee("Luna", "Lovegood", 5, 3.21));
        staff.hireEmployee(new Employee("Minerva", "Mcgonagall", 2, 750.0));
        staff.hireEmployee(new Employee("Remus", "Lupin", 2, 450.0));

        staff.showAllEmployees();

        System.out.println("Enter data to add new employee:");
        Scanner in = new Scanner(System.in);
        System.out.print("First name: ");
        String firstName = in.nextLine();
        System.out.print("Last name: ");
        String lastName = in.nextLine();
        /* another variant:
         * System.out.print("Enter full name: ");
         * String name = in.nextLine();
         * String[] tmp = name.split("\\s+");
         * and then condtracting Employee object we can use
         * new Employee(tmp[0], tmp[1], ...);
         */
        System.out.print("Enter department number (1 - 5): ");
        int deptNo = Integer.parseInt(in.nextLine());       // removing new line symbols :)
        while (deptNo < 1 || deptNo > 5) {
            System.out.print("You entered wrong department number. Try again (1 - 5): ");
            deptNo = in.nextInt();
        }
        System.out.print("Enter salary: ");
        double salary = Double.parseDouble(in.nextLine());

        staff.hireEmployee(new Employee(firstName, lastName, deptNo, salary));
        staff.showAllEmployees();
        System.out.println("============================================");

        System.out.print("What employee do you wnat to fire? Emter the full name: ");
        String nameToWork = in.nextLine();
        staff.fireEmployee(nameToWork);
        staff.showAllEmployees();
        System.out.println("============================================");

        System.out.print("What employee do you wnat to change salary? Emter the full name: ");
        nameToWork = in.nextLine();
        System.out.print("Enter new salary: ");
        salary = Double.parseDouble(in.nextLine());
        staff.changeSalary(nameToWork, salary);
        staff.showAllEmployees();
        System.out.println("============================================");

        System.out.print("What employee do you wnat to move in another department? Emter the full name: ");
        nameToWork = in.nextLine();
        System.out.print("Enter new department (1 - 5): ");     // hope department will be correct :) don't want to check it again
        deptNo = Integer.parseInt(in.nextLine());
        staff.changeSalary(nameToWork, deptNo);
        staff.showAllEmployees();
        System.out.println("============================================");

        in.close();

        System.out.println("Employees by department");
        staff.showEmployeesByDept();
    }
}
