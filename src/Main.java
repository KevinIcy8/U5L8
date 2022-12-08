public class Main
    {
        public static void main(String[] args)
        {
            Employee employee1 = new Employee("Jim", "Mason");
            Employee.employeeTest(employee1);

            Employee employee2 = new Employee("Amy", "Adams");
            Employee.employeeTest(employee2);

            Employee employee3 = new Employee("Bob", "Ross");
            Employee.employeeTest(employee3);

            Employee employee4 = new Employee("Cindy", "Nox");
            Employee.employeeTest(employee4);

            System.out.println("==============================");
            Employee.employeeTest(employee1);
            Employee.employeeTest(employee2);
            Employee.employeeTest(employee3);
            Employee.employeeTest(employee4);
        }

    }
