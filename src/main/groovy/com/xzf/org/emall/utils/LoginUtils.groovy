package com.xzf.org.emall.utils

import com.xzf.org.emall.domain.LoginUser
import spark.Request

class LoginUtils {

    private static LoginUser loginUser;

    static LoginUser LoginUser(Request request){
        if(!loginUser) {
            loginUser = (LoginUser) request.session().attribute("user");
        }
        loginUser
    }


}
