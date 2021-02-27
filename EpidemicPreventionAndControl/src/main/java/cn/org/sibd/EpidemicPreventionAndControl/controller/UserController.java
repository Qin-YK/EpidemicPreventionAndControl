package cn.org.sibd.EpidemicPreventionAndControl.controller;

import cn.org.sibd.EpidemicPreventionAndControl.entity.User;
import cn.org.sibd.EpidemicPreventionAndControl.entity.UserRecord;
import cn.org.sibd.EpidemicPreventionAndControl.repository.UserRecordRepository;
import cn.org.sibd.EpidemicPreventionAndControl.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

/**
 * 用户出行记录 Repository
 */
@Controller
@RequiredArgsConstructor
public class UserController {

    final UserRecordRepository userRecordRepository;
    final UserRepository userRepository;

    /**
     * 进入登记表单界面
     *
     * @return
     */
    @GetMapping("/")
    public String singForm(@ModelAttribute UserRecord userRecord) {
        return "sign";
    }

    /**
     * 提交登记信息
     *
     * @param userRecord
     * @return
     */
    @PostMapping("/submit")
    public String signSubmit(@ModelAttribute UserRecord userRecord) {
        String mobile = userRecord.getMobile();
        Optional<User> userOptional = userRepository.findByMobile(mobile);
        //先判断是不是第一次 如果是就录入个人信息
        if (!userOptional.isPresent()) {
            return "redirect:/user";
        }
        //获取用户信息
        User user = userOptional.get();
        //把用户的信息保存到出入记录
        userRecord.setName(user.getName());
        //保存登记信息
        userRecordRepository.save(userRecord);
        //返回成功视图
        return "success";
    }

    /**
     * 提交个人信息
     *
     * @param user
     * @return
     */
    @GetMapping("/user")
    public String userForm(@ModelAttribute User user) {
        return "user";

    }

    @PostMapping("/user")
    public String userSubmit(@ModelAttribute User user, Model model) {
        userRepository.save(user);
        model.addAttribute("type", "userSubmit");
        return "success";
    }
}
