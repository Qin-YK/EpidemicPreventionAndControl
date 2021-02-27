package cn.org.sibd.EpidemicPreventionAndControl.repository;

import cn.org.sibd.EpidemicPreventionAndControl.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * 用户个人信息相关的 Repository
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 根据手机号查询用户信息
     *
     * @param mobile
     * @return
     */
    Optional<User> findByMobile(String mobile);

}
