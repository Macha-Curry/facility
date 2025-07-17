package jp.teamd.facility1.facilitysystem1.security;

import java.util.Collection;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import jp.teamd.facility1.facilitysystem1.bean.UserBean;
import lombok.Data;

@Data
public class LoginUserDetails extends User{
    //認証に使うユーザクラス
    private final UserBean user;
    //認証ユーザ作成(コンストラクタ)
    public LoginUserDetails(UserBean userBean,
    boolean accountNonExpried,      //アカウント無効
    boolean credenttialsNonExpired, //認証無効
    boolean accountNonLocked,       //ロック状態を設定可能　今回は全て該当なし(true)でユーザ認証
    Collection<GrantedAuthority> authorities) {
        super(userBean.getUsername(),userBean.getPassword(),true,true,true,true,authorities);
        this.user = userBean;
    }
}
