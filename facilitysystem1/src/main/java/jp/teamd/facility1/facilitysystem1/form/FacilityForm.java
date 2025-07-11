package jp.teamd.facility1.facilitysystem1.form;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
/*
    FacilityBeanはDBと連動
    FacilityFormは画面と連動
 */
public class FacilityForm {
    private Integer id;             //管理番号
    private String product;         //品名
    private String modelNumber;     //型番
    private String manufacturer;    //メーカー
    private String specification;   //仕様
    private Integer serviceLife;    //耐用年数
    private Integer purchaseDate;   //購入日
    private Integer depreciation;   //減価償却
    private Boolean notAvailable;   //使用不可
    private Boolean rentAble;       //貸出可能
    private String location;        //設置場所
    private Integer expiry;         //使用期限
}
