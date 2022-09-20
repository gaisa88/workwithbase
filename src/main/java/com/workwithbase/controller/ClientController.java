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

    @GetMapping("/search")
    public String indexWithQuery(@RequestParam("phone") String phone, Model model) {
        model.addAttribute("clientlist", clientsService.findAllByName(phone));
        return "index";
    }

}
