package com.sist.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.web.service.FoodService;
import com.sist.web.service.ShoesService;
import com.sist.web.vo.FoodVO;
import com.sist.web.vo.ShoesVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {

	private final ShoesService sService;
	private final FoodService fService;
	@GetMapping("/")
	public String main(Model model) {
		
		List<ShoesVO> list = sService.shoesTop3Data();
		List<FoodVO> flist = fService.foodTop5();
		
		model.addAttribute("list", list);
		model.addAttribute("flist", flist);
		model.addAttribute("main_html", "main/home");
		return "main/main";
	}
}
