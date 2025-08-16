package proxy_design_pattern;

public interface EmployeeDao {

    void create(String client, Employee employee) throws Exception;
    Employee get(String client, int employeeId) throws Exception;
    void delete(String client, int employeeId) throws Exception;

}
