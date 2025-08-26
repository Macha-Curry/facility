package jp.te4a.app2.facility2.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//adminアカウントを一つ自動作成する（開発中のみ）

//DB対応ユーザクラス
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class UserBean {
    @Id
    private String username;

    @JsonIgnore
    private String password;
}
