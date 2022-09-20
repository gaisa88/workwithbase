package com.workwithbase.controller;

import com.workwithbase.model.Address;
import com.workwithbase.model.Client;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.workwithbase.service.ClientService;

import java.util.List;
import java.util.Optional;
@Controller
public class ClientController {
    private final ClientService clientsService;

    public ClientController(ClientService clientsService) {
        this.clientsService = clientsService;
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("clientlist", clientsService.readAllClient());
        return "index";
    }

    @GetMapping("/addnew")
    public String addNewClient(Model model) {
        Client client = new Client();
        model.addAttribute("client", client);
        return "newclient";
    }
    @GetMapping("/addrequest")
    public String myRequest(Model model) {
        return "myrequest";
    }

    @GetMapping("/search")
    public String indexWithQuery(@RequestParam("phone") String phone, Model model) {
        model.addAttribute("clientlist", clientsService.findAllByName(phone));
        return "index";
    }
//    @GetMapping("/search1/{id}")
//    public String indexWithQuery(@PathVariable(value = "id") long id, Model model) {
//        model.addAttribute("client", clientsService.findClientById(id));
//        return "index";
//    }


    @PostMapping("/save")
    public String saveClient(@ModelAttribute("client") Client newClient) {
        clientsService.saveClient(newClient);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") long id, Model model) {
        Client client = clientsService.findClientById(id).get();
        model.addAttribute("client", client);
        return "update";
    }

    @GetMapping("/deleteClient/{id}")
    public String deleteClient(@PathVariable(value="id") long id){
        clientsService.deleteClientId(id);
        return "redirect:/";
    }




    @RequestMapping("/clients") // объявляем rest запрос для получения списка сущностей
    public Iterable<Client> getClients() { // получаем иттерированный список
        List<Client> clientList = clientsService.readAllClient(); // объявлем переменную лист объектов, которые получаем сервиса прочитав данные из таблицы
        return clientList; // возвращаем лист сущностей
    }
    @RequestMapping("/address") // объявляем rest запрос для получения списка сущностей
    public Iterable<Address> getAddress() { // получаем иттерированный список
        List<Address> addressList = clientsService.readAllAddress(); // объявлем переменную лист объектов, которые получаем сервиса прочитав данные из таблицы
        return addressList; // возвращаем лист сущностей
    }
    @GetMapping("/clients/{id}") // объявлем запрос get для получения данных
    Optional<Client> one(@PathVariable Long id) { // получаем опциональную сущность, по id
        return clientsService.findClientById(id); // возвращаем сущность полученную сервисом через id
    }
    @GetMapping("/address/{id}") // объявлем запрос get для получения данных
    Optional<Address> two(@PathVariable Long id) { // получаем опциональную сущность, по id
        return clientsService.findAddressById(id); // возвращаем сущность полученную сервисом через id
    }

    @PostMapping("/clients") // объявлем запрос добавление данных
    Client newClient(@RequestBody Client newClient) { // добавляем нового клиента в таблицу
        return clientsService.saveClient(newClient); // передаем возвращенного объекта в таблицу
    }
    @PostMapping("/address") // объявлем запрос добавление данных
    Address newAddress(@RequestBody Address newAddress) { // добавляем нового клиента в таблицу
        return clientsService.saveAddress(newAddress); // передаем возвращенного объекта в таблицу
    }

    @PutMapping("/clients/{id}") // обновляем объект по id
    Client updateClient (@RequestBody Client newClient1, @PathVariable Long id) { // получаем объект newClient1 и возвращаем обновленый объект updateClient
        Optional<Client> updateClient = clientsService.findClientById(id); // опционально берем обновляемый объект, который получили через метод сервиса по id
        Client cki = updateClient.get(); // берем обновляемый объект и присваиваем переменной
        cki.setName(newClient1.getName()); // присваеваем обновляемому объекту новое значение поля name из получаемого объекта
        cki.setEmail(newClient1.getEmail()); // присваеваем обновляемому объекту новое значение поля email из получаемого объекта
        cki.setPhone(newClient1.getPhone()); // присваеваем обновляемому объекту новое значение поля phone из получаемого объекта
        return clientsService.saveClient(cki); // сохраняем уже обновленный объект и возвращаем его
    }
    @PutMapping("/clients/update")
    Client updateClient1 (@RequestBody Client newClient1) {
        return clientsService.saveClient(newClient1);
    } // получаем объект newClient1 и возвращаем обновленый объект updateClient1
    @PutMapping("/address/update")
    Address updateAddress (@RequestBody Address newAddress) {
        return clientsService.saveAddress(newAddress);
    } // получаем объект newClient1 и возвращаем обновленый объект updateClient1

    @PutMapping("/address/{id}") // обновляем объект по id
    Address updateAddress (@RequestBody Address newAddress, @PathVariable Long id) { // получаем объект newClient1 и возвращаем обновленый объект updateClient
        Optional<Address> updateAddress = clientsService.findAddressById(id); // опционально берем обновляемый объект, который получили через метод сервиса по id
        Address branch = updateAddress.get(); // берем обновляемый объект и присваиваем переменной
        branch.setKato_id(newAddress.getKato_id()); // присваеваем обновляемому объекту новое значение поля name из получаемого объекта
        branch.setStreet_place(newAddress.getStreet_place()); // присваеваем обновляемому объекту новое значение поля email из получаемого объекта
        branch.setApartment(newAddress.getApartment()); // присваеваем обновляемому объекту новое значение поля phone из получаемого объекта
        branch.setRegion_name(newAddress.getRegion_name()); // присваеваем обновляемому объекту новое значение поля phone из получаемого объекта
        return clientsService.saveAddress(branch); // сохраняем уже обновленный объект и возвращаем его
    }


    @GetMapping("/addresses/{id}")
    public Address findBranchById(@PathVariable Long id) {
        return clientsService.findAddressById(id).get();
    }

}
