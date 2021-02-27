package cn.org.sibd.EpidemicPreventionAndControl.controller;

import cn.org.sibd.EpidemicPreventionAndControl.entity.User;
import cn.org.sibd.EpidemicPreventionAndControl.entity.UserRecord;
import cn.org.sibd.EpidemicPreventionAndControl.repository.UserRecordRepository;
import cn.org.sibd.EpidemicPreventionAndControl.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 管理员相关的 Controller
 */
@Controller
@RequiredArgsConstructor
public class AdminController {

    final UserRepository userRepository;
    final UserRecordRepository userRecordRepository;

    public AdminController() {
    }

    /**
     * 管理员首页：用户出入记录列表
     * @param model
     * @return
     */
    @GetMapping("/admin")
    public String admin(Model model){
        // 按照记录生成时间倒序排序
        Sort sort = Sort.by(Sort.Order.desc("createTime"));
        List<UserRecord> list = userRecordRepository.findAll(sort);
        model.addAttribute("list", list);
        return "admin";
    }

    /**
     * 根据手机号，查看用户的详细信息
     * @param mobile 请求参数：手机号
     * @param model
     * @return
     */
    @GetMapping("/admin/userDetail")
    public String userDetail(@RequestParam("mobile") String mobile, Model model) {
        User user = userRepository.findByMobile(mobile).get();
        model.addAttribute("user", user);
        Sort sort = Sort.by(Sort.Order.desc("createTime"));
        List<UserRecord> records = userRecordRepository.findByMobile(mobile, sort);
        model.addAttribute("records", records);
        return "user-detail";
    }

    /**
     * 登录页面
     * @return
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
