package jp.teamd.facility1.facilitysystem1.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacilityBean {
    Integer id;             //管理番号
    String product;         //品名
    String modelNumber;     //型番
    String manufacturer;    //メーカー
    String specification;   //仕様
    Integer serviceLife;    //耐用年数
    Integer purchaceDate;   //購入日
    Integer depreciation;   //減価償却
    Boolean notAvailable;   //使用不可
    Boolean rentAble;       //貸出可能
    String location;        //設置場所
    Integer expiry;         //使用期限
}
