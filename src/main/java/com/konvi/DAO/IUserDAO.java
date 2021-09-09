package com.konvi.DAO;


import com.konvi.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户DAO接口
 */
@Repository
public interface IUserDAO extends PagingAndSortingRepository<User, Long>
//public interface UserDAO extends CrudRepository<User,Long>
{
    /**
     * 验证用户用户
     */
    List<User> findByUsernameAndPassword(String name, String password);

}

