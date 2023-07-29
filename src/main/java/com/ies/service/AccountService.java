package com.ies.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ies.bindings.UnlockAccForm;
import com.ies.bindings.UserAccForm;

@Service
public interface AccountService {

	public boolean createUserAccount(UserAccForm accForm);

    public List<UserAccForm> fetchUserAccounts( );

    public UserAccForm getUserAccById(Integer accId);

    public String changeAccStatus(Integer accId, String status);

    public String unlockUserAccount(UnlockAccForm unlockAccForm);

}
