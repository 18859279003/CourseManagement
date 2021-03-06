package xmu.crms.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import xmu.crms.mapper.AuthMapper;

/**
 * 实现Spring Security的 UserDetailService
 * 用于登录时 从数据库里拿对应用户名的信息进行密码验证
 * @author LiuXuezhang
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired(required = false)
    AuthMapper authMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    	System.out.println(s);
        UserDetailsImpl userDetails = authMapper.getUserByNumber(s);
        if(userDetails == null){
            throw new UsernameNotFoundException("未找到用户");
        }
        return userDetails;
    }

    public UserDetails loadUserByOpenId(String openid) throws UsernameNotFoundException{
        UserDetailsImpl userDetails = authMapper.getUserByOpenId(openid);
        if(userDetails == null){
            throw new UsernameNotFoundException("未找到openId 对应用户");
        }
        return userDetails;
    }
}
