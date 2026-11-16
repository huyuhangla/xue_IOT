package org.xue.xue_iot.Service;

import org.xue.xue_iot.pojo.User;

public interface UserService {
    public User findByUsername(String username);
    public void register(String username,String password,String email);
    public User login(String username, String password);
}
