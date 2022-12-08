public class Employee {
    private String firstName;
    private String lastName;
    private int employerID;
    private static int recentEmployerID = 100;
    private static int numberOfEmployee = 0;

    public Employee(String fn, String ln){
        firstName = fn;
        lastName = ln;
        recentEmployerID++;
        employerID = recentEmployerID;
        numberOfEmployee++;
    }

    public static void employeeTest(Employee employee)
    {
        System.out.println("Employee's full name: " + employee.firstName + " " + employee.lastName);
        // finish writing me:
        System.out.println("Employee's ID number: " + employee.employerID);
        System.out.println("Most Recent Employee ID: " + recentEmployerID);
        System.out.println("Total Employees: " + numberOfEmployee);
        System.out.println("-----");
    }
}
