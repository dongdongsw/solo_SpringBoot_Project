package com.sist.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sist.web.service.ExerciseService;
import com.sist.web.vo.ExerciseVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ExerciseController {

	private final ExerciseService eService;
	
	@GetMapping("/exercise/list")
	public String exercise_list(@RequestParam(name="page", required=false)String page, Model model) {
		
		if(page== null) {
			page = "1";
		}
		int curpage = Integer.parseInt(page);
		int start = (curpage*12)-12;
		
		List<ExerciseVO> list = eService.exerciseListData(start);
		int totalpage = eService.exerciseTotalPage();
		
		final int BLOCK = 10;
		int startPage = ((curpage-1)/BLOCK*BLOCK)+1;
		int endPage = ((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage > totalpage) {
			endPage = totalpage;
		}
		
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		
		model.addAttribute("main_html","exercise/list");
		return "main/main";
	}
	
	@GetMapping("/exercise/detail")
	public String exercise_detail(@RequestParam("b_id") String b_id, Model model) {
		
		ExerciseVO vo = eService.exerciseDetailData(b_id);
		model.addAttribute("vo", vo);
		
		model.addAttribute("main_html","exercise/detail");
		return "main/main";
	}
}
