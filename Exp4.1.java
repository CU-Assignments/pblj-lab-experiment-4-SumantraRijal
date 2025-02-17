Experiment 4.1: Employee Management System

The Employee Management System is a simple Java-based application that uses ArrayList to manage employee records. The system allows users to perform the following operations:

Add Employee → Store Employee ID, Name, and Salary.

Update Employee → Modify employee details based on their ID.

Remove Employee → Delete an employee using their ID.

Search Employee → Find employees by ID or Name.

Display All Employees → Show a complete list of employees.

Test Cases

Test Case 1: Adding Employees (No Employees Initially)
Display Employees
Expected Output:
No employees found.
  
Test Case 2: Add Employees
Input:
Add Employee (ID=101, Name="Anish", Salary=50000)
Add Employee (ID=102, Name="Bobby", Salary=60000)
Expected Output:
Employee Added: ID=101, Name=Anish, Salary=50000
Employee Added: ID=102, Name=Bobby, Salary=60000

Test Case 3: Update Employee Salary
Input:
Update Employee (ID=101, New Salary=55000)
Expected Output:
Employee ID 101 updated successfully.

Test Case 4: Search Employee by ID
Input:
Search Employee by ID=102
Expected Output:
Employee Found: ID=102, Name=Bobby, Salary=60000

Test Case 5: Remove Employee
Input:
Remove Employee (ID=101)
Expected Output:
Employee ID 101 removed successfully.

Test Case 6: Display All Employees
Input:
Display Employees
Expected Output:
ID: 102, Name: Bobby, Salary: 60000

Test Case 7: Adding Duplicate Employee ID
Input:
Add Employee (ID=101, Name="Charlie", Salary=70000)
Expected Output:
Error: Employee with ID 101 already exists.






CODE:


  import java.util.ArrayList;
import java.util.Scanner;

class Employee {
	private int id;
	private String name;
	private int age;
	private double salary;

	public Employee(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
}

class EmployeeManagementSystem {
	private ArrayList<Employee> employees = new ArrayList<Employee>();
	public void addEmployee(Employee e) {
		employees.add(e);
	}
	public void removeEmployee(int id) {
		for (int i = 0; i < employees.size(); i++) {
			Employee e = employees.get(i);
			if (e.getId() == id) {
				employees.remove(i);
				break;
			}
		}
	}
	public void displayEmployees() {
		for (Employee e : employees) {
			System.out.println(e);
		}
	}
}

public class employeeManagment {
	public static void main(String[] args) {
		EmployeeManagementSystem ems = new EmployeeManagementSystem();
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		while (choice != 4) {
			System.out.println("1. Add Employee");
			System.out.println("2. Remove Employee");
			System.out.println("3. Display Employees");
			System.out.println("4. Edit Employees Details");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				System.out.print("Enter Employee ID: ");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter Employee Name: ");
				String name = sc.nextLine();
				System.out.print("Enter Employee Salary: ");
				double salary = sc.nextDouble();
				sc.nextLine();
				Employee e = new Employee(id, name, salary);
				ems.addEmployee(e);
				System.out.println("Employee added successfully!");
				break;
			case 2:
				System.out.print("Enter Employee ID to remove: ");
				int removeId = sc.nextInt();
				sc.nextLine();
				ems.removeEmployee(removeId);
				System.out.println("Employee removed successfully!");
				break;
			case 3:
				System.out.println("List of Employees:");
				ems.displayEmployees();
				break;
			case 4:
			    System.out.println("Enter Employee ID to edit: ");
			    int newid = sc.nextInt();
			    System.out.print("Enter Employee Name: ");
				String newname = sc.nextLine();
				sc.nextLine();
				System.out.print("Enter Employee Salary: ");
				double newsalary = sc.nextDouble();
				sc.nextLine();
				Employee ed = new Employee(newid, newname, newsalary);
				ems.addEmployee(ed);
				System.out.println("Employee edited successfully!");
			    break;
			case 5:
				System.out.println("Exiting Employee Management System...");
				break;
			default:
				System.out.println("Invalid choice. Try again.");
				break;
			}
		}
		sc.close();
	}
}

