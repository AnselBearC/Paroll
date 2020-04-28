/**
 * 功能描述: <br>
 * 〈$〉
 * <p>
 * $
 *
 * @return:$
 * @since: 1.0.0
 * @Author:Ansel
 * @Date: 2020/4/13$ 下午 04:21$
 */

package com.example.demo.service;

import com.example.demo.bean.Result;
import com.example.demo.bean.User;
import com.example.demo.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class UserService {

    @Autowired
    private UserMapper userMapper;
    /**
     * 注册
     * @param user 参数封装
     * @return Result
     */
    public Result regist(User user) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            User existUser = userMapper.findUserByName(user.getUsername());
            if (existUser !=null) {
                //如果用户名已存在
                result.setMsg("用户名已存在");
            }else {
                userMapper.regist(user);
                System.out.println(user.getId());
                result.setSuccess(true);
                result.setDetail(user);
            }

        }catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 登录
     * @param user 用户名和密码
     * @return Result
     */
    public Result login(User user) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            Long userId = userMapper.login(user);
            if(userId ==null) {
                result.setMsg("用户名或密码错误");
            }else {
                result.setMsg("登陆成功");
                result.setSuccess(true);
                user.setId(userId);
                result.setDetail(user);
            }
        }catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
