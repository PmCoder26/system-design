package proxy_design_pattern;

public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public void create(String client, Employee employee) throws Exception {
        // creates a new row for new employee
        System.out.println("Employee created with id: " + employee.getId());
    }

    @Override
    public Employee get(String client, int employeeId) throws Exception {
        // fetch the employee's row
        System.out.println("Fetched employee with id: " + employeeId);
        return new Employee(employeeId, "", 0, "");
    }

    @Override
    public void delete(String client, int employeeId) throws Exception {
        // deletes the employee's row.
        System.out.println("Employee deleted with id: " + employeeId);
    }

}
