package jp.teamd.facility1.facilitysystem1.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import jp.teamd.facility1.facilitysystem1.bean.UserBean;
import jp.teamd.facility1.facilitysystem1.form.UserForm;
import jp.teamd.facility1.facilitysystem1.repository.UserRepository;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserForm create(UserForm userForm) {
        //ユーザ作成時にパスワードエンコード
        userForm.setPassword(new BCryptPasswordEncoder().encode(userForm.getPassword()));

        UserBean userBean = new UserBean();
        //画面用ユーザ情報(Form)DB用ユーザ情報(Bean)
        BeanUtils.copyProperties(userForm, userBean);
        
        //ユーザをDBに追加
        userRepository.save(userBean);
        return userForm;
    }
}