package cn.org.sibd.EpidemicPreventionAndControl.entity;

import cn.org.sibd.EpidemicPreventionAndControl.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * 用户出行记录
 */
@Entity
@Data
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserRecord extends BaseEntity {

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 体温
     */
    private Double temperature;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

}
