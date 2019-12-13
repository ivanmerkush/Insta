package com.netcracker.ivanmerkush.fapi.service;

import com.netcracker.ivanmerkush.fapi.models.User;
import com.netcracker.ivanmerkush.fapi.models.UserViewModel;

public interface UserViewModelService {
    UserViewModel getUserViewModel(Integer id);
}
