package com.konvi.service.Impl;

import com.konvi.DAO.IUserDAO;
import com.konvi.service.IUserService;
import com.konvi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService
{
    @Autowired
    private IUserDAO userDAO;

    public boolean verifyUser(User user)
    {
        List<User> userList=userDAO.findByUsernameAndPassword
                (user.getUsername(),user.getPassword());


        return userList.size()>0;
    }

}

