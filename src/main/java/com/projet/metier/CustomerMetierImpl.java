package com.projet.metier;

import com.projet.entities.Client;
import com.projet.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerMetierImpl implements  CustomerMetierInterface{
    @Autowired
    CustomerRepository customerRepository;


    @Override
    public void ajouterClient(Client clt) {

        customerRepository.save(clt);
    }

    @Override
    public List<Client> getActifCustomers() {
        return customerRepository.getActifCustomers();
    }

    @Override
    public List<Client> getNonActifCustomers() {
        return customerRepository.getNonActifCustomers();
    }

    @Override
    public List<Client> listeClients() {

        return customerRepository.findAll();
    }

    @Override
    public void deleteCustomer(Long cltId) {

        customerRepository.deleteById(cltId);
    }

    @Override
    public Client save(Client p) {
        Client savedCustomer = customerRepository.save(p);
        return savedCustomer;
    }


    @Override
    public Optional<Client> findCltId(Long id) {
        if (id != null) {
            return customerRepository.findById(id);
        } else {
            return Optional.empty();
        }
    }


    @Override
    public Client updateClient( Client clt) {
        return customerRepository.save(clt);
    }

    @Override
    public List<Client> searchCustomers(String keyword) {
        List<Client> customers=customerRepository.searchCustomer(keyword);
        return customers;
    }


    @Override
    public List<Client> searchCustomerByadd(String keyword) {

        return customerRepository.searchCustomerByadd( keyword);
    }

    @Override
    public List<Client> searchCustomerByNumTel(String keyword) {
        return customerRepository.searchCustomerByNumTel(keyword);
    }

    @Override
    public Double getTotalRevenueForClient(Client client) {
        return customerRepository.getTotalRevenueForClient(client);
    }

    @Override
    public List<Object[]> getTotalRevenueForAllClients() {
        return customerRepository.getTotalRevenueForAllClients();
    }

    @Override
    public List<Object[]> getRemainingAmountForAllClients() {
        return customerRepository.getRemainingAmountForAllClients();
    }

    @Override
    public Double getRemainingAmountForClient(Client client) {
        return customerRepository.getRemainingAmountForClient(client);
    }

    @Override
    public List<Object[]> getPaymentsStatusForAllClients() {
        return customerRepository.getPaymentsForAllClients();
    }

    @Override
    public List<Object[]> getRevenueByClientAndYear( Client client, String year){
        return customerRepository.getRevenueByClientAndYear(client,year);
    }

    @Override
    public List<Object[]> getRevenueByYear(String year) {
        return customerRepository.getRevenueByYear(year);
    }
}
