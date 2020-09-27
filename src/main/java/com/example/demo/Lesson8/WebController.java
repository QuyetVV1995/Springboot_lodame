package com.example.demo.Lesson8;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

// Đánh dấu đây là một Controller
// Nơi tiếp nhận các reqquest từ phía người dùng
@Controller
public class WebController {

    // Đón nhận request GET
    @GetMapping("") // Nếu người dùng request tới địa chỉ "/"
    public String index() {
        return "index"; // Trả về file index.html
    }

    @GetMapping("/profile")
    public String profile(Model model){
        // Tạo ra thông tin
        List<Info> profile = new ArrayList<>();
        profile.add(new Info("fullname", "Vu Van Quyet"));
        profile.add(new Info("nickname", "QuyetVV"));
        profile.add(new Info("gmail", "quyeta2ubqn@gmail.com"));
        profile.add(new Info("facebook", "https://www.facebook.com/vu.vanquyet.50/"));
        profile.add(new Info("github", "https://github.com/QuyetVV1995"));

        // Đưa thông tin vào Model
        model.addAttribute("QuyetVVProfile", profile);

        // TRả về template profile.html
        return "profile";
    }

}