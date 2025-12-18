package com.sist.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sist.web.service.ShoesService;
import com.sist.web.vo.ShoesVO;

import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ShoesController {

	private final ShoesService sService;
	
	@GetMapping("/shoes/list")
	public String shoes_list(@RequestParam(name="page", required=false) String page, Model model) {
		
		if(page == null) {
			page = "1";
		}
		int curpage = Integer.parseInt(page);
		int start = (curpage*12)-12;
		List<ShoesVO> list = sService.shoesListData(start);
		int totalpage = sService.shoesTotalPage();
		
		final int BLOCK = 10;
		int startPage = ((curpage-1)/BLOCK*BLOCK)+1;
		int endPage = ((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		model.addAttribute("list", list);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("curpage", curpage);

		model.addAttribute("main_html", "shoes/list");
		return "main/main";
	}
	
	@GetMapping("/shoes/detail")
	public String shoes_detail(@RequestParam("goods_id") int goods_id, Model model) {
		
		ShoesVO vo = sService.shoesDetailData(goods_id);
		model.addAttribute("vo", vo);
		
		model.addAttribute("main_html", "shoes/detail");
		return "main/main";
	}
}
