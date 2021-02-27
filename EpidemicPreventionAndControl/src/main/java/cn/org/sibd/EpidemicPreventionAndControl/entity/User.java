package cn.org.sibd.EpidemicPreventionAndControl.entity;

import cn.org.sibd.EpidemicPreventionAndControl.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


/**
 * 用户信息
 */
@Entity
@Data
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {


    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 楼座
     */
    private String building;

    /**
     * 单元
     */
    private String unit;

    /**
     * 房号
     */
    private String room;

    public void setName(String name) {
        this.name = name;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public String getIdCard() {
        return idCard;
    }

    public String getBuilding() {
        return building;
    }

    public String getUnit() {
        return unit;
    }

    public String getRoom() {
        return room;
    }


}
