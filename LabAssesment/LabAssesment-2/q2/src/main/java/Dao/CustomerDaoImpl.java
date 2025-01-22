package Dao;

import FactoryConnection.FactoryConnect;
import Exception.CustomerException;
import java.awt.print.Book;
import java.sql.*;

public class CustomerDaoImpl implements CustomerDao{
    private static Connection connection ;
    public CustomerDaoImpl() {
        this.connection = FactoryConnect.getConnection();
    }

    @Override
    public void addCustomer(Customer customer)  {
        try{
            PreparedStatement ps = connection.prepareStatement(
                    "insert into Customer(id,name,address,phoneNumber)values(?,?,?,?)");
            ps.setInt(1, customer.getId());
            ps.setString(2, customer.getName());
            ps.setString(3,customer.getAddress());
            ps.setString(4,customer.getPhoneNumber());
            int res = ps.executeUpdate();

        } catch (SQLException e) {
            throw new CustomerException("something ",e);
        }
}

    @Override
    public void findCustomer(int id) {
        Customer customer = null;
        try{
            PreparedStatement ps = connection.prepareStatement("select * from Customer where id = ?");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                customer = new Customer(rs.getInt(1),rs.getString(2), rs.getString(3),
                        rs.getString(4));
                System.out.println(customer);
            }
        } catch (SQLException e) {
            throw new CustomerException("something ",e);
        }
    }

}
