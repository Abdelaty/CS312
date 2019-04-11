package com.example.task1_abdelaty68472.Login;

import es.dmoral.toasty.Toasty;

class LoginPresenter {

    boolean auth(String userName, String password) {

        String DEFAULT_USER = "Admin";
        String DEFAULT_PASSWORD = "Admin";
        return userName.equals(DEFAULT_USER) && password.equals(DEFAULT_PASSWORD);

    }
}



