package jp.te4a.app2.facility2.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jp.te4a.app2.facility2.bean.UserBean;
import jp.te4a.app2.facility2.form.UserForm;
import jp.te4a.app2.facility2.repository.UserRepository;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserForm create(UserForm userForm) {
        // パスワードをエンコード
        userForm.setPassword(new BCryptPasswordEncoder().encode(userForm.getPassword()));

        UserBean userBean = new UserBean();
        BeanUtils.copyProperties(userForm, userBean);

        userRepository.save(userBean);
        return userForm;
    }
}