package com.workwithbase.service;

import com.workwithbase.model.Address;
import com.workwithbase.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.workwithbase.repository.AddressReposiroty;
import com.workwithbase.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressReposiroty addressReposiroty;

    public Client saveClient(Client client) { // метод для создания и сохранения объекта в таблицу
        clientRepository.save(client);
        return client;
    }
    public List<Client> readAllClient() {
        return clientRepository.findAll();
    } // метод для чтения и поиска объекта в таблице

    public Optional<Client> findClientById(Long id) { // опционально возвращаем объект, для возможности работы с ним
        return clientRepository.findById(id);
    }
    public Address saveAddress(Address address){
        addressReposiroty.save(address);
        return address;
    }

    public void deleteClientId(Long id){
        clientRepository.deleteById(id);
    }

    public List<Address> readAllAddress() {
        return addressReposiroty.findAll();
    } // метод для чтения и поиска объекта в таблице

    public Optional<Address> findAddressById(Long id) { // опционально возвращаем объект, для возможности работы с ним
        return addressReposiroty.findById(id);
    }
    public List<Client> findAllByName(long id) {
        return clientRepository.findAllByName(id);
    }

}
