package demo1.repository;

import demo1.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCustomerRepository {


        List<Customer> customers = new ArrayList<>();

        public List<Customer> findAll(){
            return customers;
        }


        public int create(Customer customer){
            int id = customers.size() + 1;
            customer.setId(id);
            customers.add(customer);
            return id;
        }


        public void update(Customer customer, int id){
            Customer c = getById(id);
            if(c != null){
                c.setEmail(customer.getEmail());
                c.setName(customer.getEmail());
            } else {
                throw new IllegalStateException("customer with this id was not found.");
            }
        }

        private Customer getById(int id){
            Customer c = customers.stream().filter(x -> x.getId() == id).findAny().orElse(null);
            return c;
        }


        public void delete(int id) {
            Customer c = getById(id);
            if(c != null){
                customers.remove(c);
            } else {
                throw new IllegalStateException("customer with this id was not found.");
            }
        }
    }
