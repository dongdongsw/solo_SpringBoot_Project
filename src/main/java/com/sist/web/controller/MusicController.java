package com.sist.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sist.web.service.MusicService;
import com.sist.web.vo.MusicVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/music")
public class MusicController {

	private final MusicService mService;
	
	@GetMapping("/list")
	public String music_list(@RequestParam(name = "page", required = false) String page, Model model) {
		
		if(page == null) {
			page ="1";
		}
		int curpage = Integer.parseInt(page);
		int start = (curpage*12)-12;
		
		List<MusicVO> list = mService.musicListData(start);
		int totalpage = mService.musicTotalPage();
		
		final int BLOCK=10;
		int startPage = ((curpage-1)/BLOCK*BLOCK)+1;
		int endPage = ((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		model.addAttribute("list",list);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		model.addAttribute("curpage",curpage);
		
		model.addAttribute("main_html", "music/list");
		return "main/main";
	}
	
	@GetMapping("/detail")
	public String music_detail(@RequestParam("no") int no, Model model) {
		
		MusicVO vo = mService.musicDetailData(no);
		model.addAttribute("vo", vo);
		
		model.addAttribute("main_html", "music/detail");
		return "main/main";
	}
	
}
