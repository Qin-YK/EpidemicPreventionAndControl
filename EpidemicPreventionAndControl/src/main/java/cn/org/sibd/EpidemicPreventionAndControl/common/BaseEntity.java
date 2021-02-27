package cn.org.sibd.EpidemicPreventionAndControl.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity  implements Serializable {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 添加时间
     */
    @Column(updatable = false)
    @CreationTimestamp
    private Date createTime;

    /**
     * 更新时间
     */
    @UpdateTimestamp
    private Date updateTime;
}
