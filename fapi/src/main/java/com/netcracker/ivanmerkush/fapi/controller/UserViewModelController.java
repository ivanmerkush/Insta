package com.netcracker.ivanmerkush.fapi.controller;
import com.netcracker.ivanmerkush.fapi.models.UserViewModel;
import com.netcracker.ivanmerkush.fapi.service.UserViewModelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/userview")
public class UserViewModelController {
    private UserViewModelService userViewModelService;

    public UserViewModelController(UserViewModelService userViewModelService) {
        this.userViewModelService = userViewModelService;
    }

    @GetMapping(value = "/{id}")
    public UserViewModel getUserViewModel(@PathVariable String id) {
        return userViewModelService.getUserViewModel(Integer.valueOf(id));
    }

}
