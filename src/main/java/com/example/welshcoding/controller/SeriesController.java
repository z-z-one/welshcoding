package com.example.welshcoding.controller;

import java.text.ParseException;
import java.util.List;

import com.example.welshcoding.service.MemberService;
import com.example.welshcoding.service.SeriesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.welshcoding.domain.Board;
import com.example.welshcoding.domain.Member;
import com.example.welshcoding.dto.BoardDTO;
import com.example.welshcoding.dto.SeriesListDTO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SeriesController {

	private final SeriesService seriesService;
	private final MemberService memberService;
	
//	@GetMapping("/kdy/series/{memberId}")
	public String seriesList(@PathVariable Long memberId, Model model) throws ParseException {
		
		List<SeriesListDTO> seriesList = seriesService.findSeriesAll(memberId);
		
		if(seriesList.size() == 0) {
			model.addAttribute("seriesSize", false);
		} else {
			model.addAttribute("seriesSize", true);
		}
		
		model.addAttribute("seriesList", seriesList);
		return "series/series";
	}
	
	@GetMapping("/series/{memberId}/{seriesId}")
	public String boardListOfSeries(
			@PathVariable(name = "memberId") Long memberId,
			@PathVariable(name = "seriesId") Long seriesId,
			@RequestParam(name = "seriesName", defaultValue = "") String seriesName,
			Model model
			) {
		
		if(!seriesName.equals("")) {
			seriesService.updateSeriesTitle(seriesId, seriesName);
			return "redirect:/series/"+memberId+"/"+seriesId;
		}
		
		List<Board> boardList = seriesService.findBoardsBySeries(seriesId,memberId);
		if(boardList.size() == 0) {
			model.addAttribute("boardsOfSeriesSize", false);
		} else {
			model.addAttribute("boardsOfSeriesSize", true);
		}
		
		Member recentMember = memberService.findOne(memberId);
		model.addAttribute("recentMember", recentMember);
		model.addAttribute("boardList",boardList);
		model.addAttribute("seriesName",seriesService.findSeriesById(seriesId).getSeriesName());
		return "series/seriesDetail";
	}
	@GetMapping("/series/{memberId}/{seriesId}/edit")
	public String editBoardListOfSeries(
			@PathVariable(name = "memberId") Long memberId,
			@PathVariable(name = "seriesId") Long seriesId,
			Model model
			) {
		
		List<Board> boardList = seriesService.findBoardsBySeries(seriesId,memberId);
		if(boardList.size() == 0) {
			model.addAttribute("boardsOfSeriesSize", false);
		} else {
			model.addAttribute("boardsOfSeriesSize", true);
		}
		model.addAttribute("boardList",boardList);
		model.addAttribute("seriesName",seriesService.findSeriesById(seriesId).getSeriesName());
		return "series/seriesUpdate";
	}
	@GetMapping("/series/{memberId}/{seriesId}/delete")
	public String deleteSeries(
			@PathVariable(name = "memberId") Long memberId,
			@PathVariable(name = "seriesId") Long seriesId,
			Model model
			) {
		
		seriesService.deleteById(seriesId);
		
		return "redirect:/mainBoard";
	}
}
