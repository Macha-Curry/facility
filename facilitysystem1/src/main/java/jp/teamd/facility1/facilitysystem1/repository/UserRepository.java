package jp.teamd.facility1.facilitysystem1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.teamd.facility1.facilitysystem1.bean.UserBean;

//ユーザー作成処理
public interface UserRepository extends JpaRepository<UserBean, String>{
}
