package com.example.welshcoding.testjiwon;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.welshcoding.domain.Member;
import com.example.welshcoding.domain.Temporary;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
public class TestTempoController {
	private final TestTemporaryService testTemporaryService;
	
//	@GetMapping("goTempForm")
	public String goForm(Model model) {
		return "/edit/tempController";
	}
	
//	@PostMapping("temporary")
	@ResponseBody
	public String home(HttpSession session,Model model, @RequestParam("temporaryTitle") String temporaryTitle ,
			@RequestParam("temporaryDetail") String temporaryDetail) throws IllegalAccessException {
		log.info("temporaryLog:"+temporaryDetail);
		int newpostId = (int) session.getAttribute("newPostId");
		String result="";
		try {
			Temporary temporary = testTemporaryService.findOne(newpostId);
			if(temporary == null) {
				log.info("개굴스");
				temporary = new Temporary();
				temporary.setTemporaryId((long)newpostId);
			}log.info("개굴스22");
			LocalDateTime localDateTime = LocalDateTime.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        String formattedDateTime = localDateTime.format(formatter);
			Member member = (Member)session.getAttribute("member");
//			Temporary temporary = new Temporary();
			temporary.setMember(member);
			temporary.setTemporaryTitle(temporaryTitle);
			temporary.setTemporaryDetail(temporaryDetail);
			temporary.setTemporaryDate(formattedDateTime);
			
			testTemporaryService.save(temporary);
			log.info("temporary sucesses");
			result="ok";
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("개굴스3");
		}
		
		return result;	// home.html 로 찾아간다.
	}
}
