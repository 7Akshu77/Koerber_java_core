package Service;

import Dao.Customer;

public interface CustomerService {
    public void addCustomer(Customer customer);
    public void findCustomer(int id);
}
