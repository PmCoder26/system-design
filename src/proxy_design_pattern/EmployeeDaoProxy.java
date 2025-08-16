package proxy_design_pattern;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmployeeDaoProxy implements EmployeeDao {

    private final EmployeeDao employeeDao;

    @Override
    public void create(String client, Employee employee) throws Exception {
        if(client.equals("ADMIN")) employeeDao.create(client, employee);
        else throw new Exception("Access Denied");
    }

    @Override
    public Employee get(String client, int employeeId) throws Exception {
        if(client.equals("ADMIN") || client.equals("USER")) return employeeDao.get(client, employeeId);
        else throw new Exception("Access Denied");
    }

    @Override
    public void delete(String client, int employeeId) throws Exception {
        if(client.equals("ADMIN")) employeeDao.delete(client, employeeId);
        else throw new Exception("Access Denied");
    }

}
