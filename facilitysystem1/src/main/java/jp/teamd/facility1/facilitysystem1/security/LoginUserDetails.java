package jp.teamd.facility1.facilitysystem1.security;

import java.util.Collection;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import jp.teamd.facility1.facilitysystem1.bean.UserBean;
import lombok.Data;

@Data
public class LoginUserDetails extends User{
    private final UserBean user;
    public LoginUserDetails(UserBean userBean,
    boolean accountNonExpried,
    boolean credenttialsNonExpired,
    boolean accountNonLocked,
    Collection<GrantedAuthority> authorities) {
        super(userBean.getUsername(),userBean.getPassword(),true,true,true,true,authorities);
        this.user = userBean;
    }
}
