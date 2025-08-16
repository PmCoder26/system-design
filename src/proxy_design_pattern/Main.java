package proxy_design_pattern;

public class Main {

    public static void main(String[] args) {

        EmployeeDaoProxy employeeDaoProxy = new EmployeeDaoProxy(new EmployeeDaoImpl());
        try {
            employeeDaoProxy.create("ADMIN", new Employee());
            employeeDaoProxy.create("USER", new Employee());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
