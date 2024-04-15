package com.example.demo.controller;

import com.example.demo.entity.Member;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {
    @GetMapping("show")
    public String showView(Model model) {
        Member member = new Member(1, "회원01");
        Member member1 = new Member(10, "KIM");
        Member member2 = new Member(20, "LEE");
        
        List<String> directions = new ArrayList<>();
        directions.add("동");
        directions.add("서");
        directions.add("남");
        directions.add("북");
        
        Map<String, Member> memberMap = new HashMap<>();
        memberMap.put("kim", member1);
        memberMap.put("lee", member2);
        
        List<Member> memberList = new ArrayList<>();
        memberList.add(member1);
        memberList.add(member2);
        
        model.addAttribute("name", "K-AKABANE");
        model.addAttribute("mb", member);
        model.addAttribute("list", directions);
        model.addAttribute("map", memberMap);
        model.addAttribute("members", memberList);
        
        return "useThymeleaf";
    }
    
    @GetMapping("a")
    public String showA() {
        return "pageA";
    }
}