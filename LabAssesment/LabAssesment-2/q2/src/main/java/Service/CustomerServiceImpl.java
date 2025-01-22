package Service;

import Dao.Customer;
import Dao.CustomerDao;
import Dao.CustomerDaoImpl;

public class CustomerServiceImpl implements CustomerService{
    CustomerDao cust = new CustomerDaoImpl();
    @Override
    public void addCustomer(Customer customer) {
           cust.addCustomer(customer);
    }

    @Override
    public void findCustomer(int id) {
        cust.findCustomer(id);
    }
}
