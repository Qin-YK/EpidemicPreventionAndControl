package cn.org.sibd.EpidemicPreventionAndControl.repository;

import cn.org.sibd.EpidemicPreventionAndControl.entity.UserRecord;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 用户出行记录 Repository
 */
@Repository
public interface UserRecordRepository extends JpaRepository<UserRecord, Long> {
    /**
     * 通过手机号查询用户出入记录
     *
     * @param mobile 手机号
     * @param sort 排序
     * @return
     */
    List<UserRecord> findByMobile(String mobile, Sort sort);
}
