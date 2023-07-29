package com.ies.service;

import com.ies.bindings.DashboardCard;
import com.ies.bindings.LoginForm;

public interface UserService {

	public  String login(LoginForm loginForm);

    public boolean recoverPwd(String email);

    public DashboardCard fetchDashboardInfo();
}
