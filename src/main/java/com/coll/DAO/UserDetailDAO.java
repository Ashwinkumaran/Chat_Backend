package com.coll.DAO;

import com.coll.Model.UserDetail;

public interface UserDetailDAO 
{
public boolean registerUser(UserDetail user);
public boolean updateProfile(UserDetail user);
public UserDetail getUser(String loginname);
public UserDetail checkUserValidation(String loginname,String password);
}

