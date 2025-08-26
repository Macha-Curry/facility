package jp.te4a.app2.facility2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.te4a.app2.facility2.bean.UserBean;

//ユーザー作成処理
public interface UserRepository extends JpaRepository<UserBean, String>{
}
