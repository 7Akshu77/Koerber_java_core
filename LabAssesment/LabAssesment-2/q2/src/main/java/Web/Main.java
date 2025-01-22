package Web;
import Dao.Customer;
import Exception.CustomerException;
import Service.CustomerService;
import Service.CustomerServiceImpl;

public class Main {
    public static void main(String args[]) throws CustomerException {
        CustomerService ser = new CustomerServiceImpl();
        //ser.addCustomer(new Customer(2,"ram","banglore","1383667738"));
        ser.findCustomer(1);
    }
}
