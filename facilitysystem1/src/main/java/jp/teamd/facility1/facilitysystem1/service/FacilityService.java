package jp.teamd.facility1.facilitysystem1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.teamd.facility1.facilitysystem1.bean.FacilityBean;
import jp.teamd.facility1.facilitysystem1.form.FacilityForm;
import jp.teamd.facility1.facilitysystem1.repository.FacilityRepository;

@Service
public class FacilityService {
    
    //課題６参照
    @Autowired
    FacilityRepository facilityRepository;

    /*            課題８で削除 */
    /*
    //保存用メソッド
    public FacilityBean save(FacilityBean facilityBean) {
        return facilityRepository.save(facilityBean);
    }

    //全件取得用メソッド
    public List<FacilityBean> findAll() {
        return facilityRepository.findAll();
    }
    */

    //追加処理　データはFacilityFormで扱い、Repoを使う時はFacilityBeanに入れて渡す
    public FacilityForm create(FacilityForm facilityForm) {
        facilityForm.setId(facilityRepository.getFacilityId());
        FacilityBean facilityBean = new FacilityBean();
        BeanUtils.copyProperties(facilityForm, facilityBean);
        facilityRepository.save(facilityBean);
        return facilityForm;
    }

    //更新処理
    public FacilityForm update(FacilityForm facilityForm) {
        FacilityBean facilityBean = new FacilityBean();
        BeanUtils.copyProperties(facilityForm, facilityBean);
        facilityRepository.update(facilityBean);
        return facilityForm;
    }

    //削除処理
    public void delete(Integer id) { 
        facilityRepository.delete(id); 
    }

    //全件取得処理
    public List<FacilityForm> findAll() {
        List<FacilityBean> beanList = facilityRepository.findAll();
        List<FacilityForm> formList = new ArrayList<FacilityForm>();
        for(FacilityBean facilityBean: beanList) {
            FacilityForm facilityForm = new FacilityForm();
            BeanUtils.copyProperties(facilityBean, facilityForm);
            formList.add(facilityForm);
        }
        return formList;
    }

    //１件取得処理
    public FacilityForm findOne(Integer id) {
        FacilityBean facilityBean = facilityRepository.findOne(id);
        FacilityForm facilityForm = new FacilityForm();
        BeanUtils.copyProperties(facilityBean, facilityForm);
        return facilityForm;
    }
}
