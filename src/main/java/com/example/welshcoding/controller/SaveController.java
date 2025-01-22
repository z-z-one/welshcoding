package com.example.welshcoding.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.welshcoding.service.TestMemberService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.welshcoding.service.TagService;
import com.example.welshcoding.service.BoardService;
import com.example.welshcoding.domain.Board;
import com.example.welshcoding.domain.Member;
import com.example.welshcoding.domain.Series;
import com.example.welshcoding.domain.Tags;
import com.example.welshcoding.exception.TagNullException;
import com.example.welshcoding.testjiwon.TestSService;
import com.example.welshcoding.testjiwon.TestTemporaryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
public class SaveController {

    private final BoardService boardService;
    private final TestMemberService testMemberService;
    private final TestSService testSService;
    private final TagService tagService;
    private final TestTemporaryService testTemporaryService;

    @RequestMapping("save")
    public String save() {     //여기서 시리즈 목록 가져오기
        log.info("save Controller");

        return "edit/save";    // home.html 로 찾아간다.
    }

    @RequestMapping("saveTemptoPost")
    public String saveTemptoPost() {     //여기서 시리즈 목록 가져오기
//		return "temporary/tempController";	// home.html 로 찾아간다.save
        return "temporary/save";
    }

    @RequestMapping("changesave")
    public String changesave() {

        return "edit/changeController";    // home.html 로 찾아간다.
    }

    @RequestMapping("controller")
    public String goController() {
        log.info("controller Controller");
        return "edit/controller";    // home.html 로 찾아간다.
    }

    @RequestMapping("controllertemp")
    public String goController2() {
        return "temporary/tempController";
    }

    @Transactional(rollbackFor = Exception.class, noRollbackFor = TagNullException.class)
    @PostMapping("/updateData")
    public String updateData(@RequestParam("gridData") String gridData, @RequestParam("gridtitle") String gridtitle,
                             @RequestParam("tag") String tagList, @RequestParam("boardId") long boardId, HttpSession session
                             ) throws Exception {
        Member member = (Member) session.getAttribute("member");
        LocalDateTime localDateTime = LocalDateTime.now();
        // 원하는 형식으로 시간 표시
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = localDateTime.format(formatter);
        System.out.println("로컬 시간: " + formattedDateTime);
        Board board = new Board();
        board.setBoardTitle(gridtitle);
        board.setBoardDate(formattedDateTime);
        board.setBoardCont(gridData);

        boardService.updateBoard(board, boardId, member.getMemberId());
        Board newBoard = boardService.findOne(boardId, member.getMemberId());
        
        //태그
        List<Tags> tags = new ArrayList<>();
        try {
        	String[] tagsArray = tagList.split(",");
            for (int i = 0; i < tagsArray.length; i++) {
                tags.add(new Tags());
                tags.get(i).setMember(member);
                tags.get(i).setTagsName(tagsArray[i]);
                tags.get(i).setBoard(newBoard);
            }
            tagService.updateTags(tags, boardId, member.getMemberId());
		} catch (TagNullException e) {
			log.error(e.getMessage());
		}
        return "redirect:/goPost/" + boardId;

    }

    @Transactional(rollbackFor = Exception.class, noRollbackFor = TagNullException.class)
    @PostMapping("/save-data")
    public String saveData(@RequestParam("gridData") String gridData,
                           @RequestParam("gridtitle") String gridtitle,
                           @RequestParam("tag") String tagList,
                           @RequestParam("thumPath") String thumPath,
                           @RequestParam("selSeries") String selSeries,
                           HttpSession session,Model model)throws Exception{

        	// 현재 로컬 시간 받기
            LocalDateTime localDateTime = LocalDateTime.now();
            // 원하는 형식으로 시간 표시
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = localDateTime.format(formatter);
            System.out.println("로컬 시간: " + formattedDateTime);


            Member member = (Member) session.getAttribute("member");

            Board board = new Board();
            board.setBoardTitle(gridtitle);
            board.setBoardCont(gridData);
            board.setBoardDate(formattedDateTime);
            board.setBoardLike("3");
            board.setSeries(new Series());
            board.setThumbnailPath(thumPath);
            board.setMember(member);

            if ((!selSeries.isEmpty()) && (selSeries != null)) {
                Series series = null;
                if (testSService.isIn(selSeries) == null) {                                                        //새로운 시리즈일경우
                    series = new Series();
                    series.setSeriesName(selSeries);
                } else {
                    series = testSService.isIn(selSeries);
                }
                series.addBoard(board);
                series.setCreateDate(formattedDateTime);
                series.setUpdateDate(formattedDateTime);
                series.setMember(member);                                                                    /////여기가 문제
                testSService.save(series);
            } else {
                Series series = new Series();
                series.addBoard(board);
                testSService.save(series);
            }

            boardService.insertData(board);
            
            //태그 부분
	        try {
	        	String[] tagsArray = tagList.split(",");
	    		for (int i = 0; i < tagsArray.length; i++) {
	    		    Tags tags = new Tags();
			    	tags.setBoard(board);
	    		    tags.setMember(member);
			    	tags.setTagsName(tagsArray[i]);
			    	tagService.save(tags);
	    		}
			} catch (TagNullException e) {
				log.error(e.getMessage());
			}
        return  "redirect:/mainBoard";
    }

    @Transactional(rollbackFor = Exception.class, noRollbackFor = TagNullException.class)
    @PostMapping("/save-data-temp")
    public String saveData2(@RequestParam("gridData") String gridData, @RequestParam("gridtitle") String gridtitle,
                            @RequestParam("tag") String tagList, @RequestParam("selSeries") String selSeries, @RequestParam("tempId") long tempId
                            , HttpSession session,Model model)throws Exception{
        
	    	// 현재 로컬 시간 받기
	        LocalDateTime localDateTime = LocalDateTime.now();
	        // 원하는 형식으로 시간 표시
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        String formattedDateTime = localDateTime.format(formatter);
	        System.out.println("로컬 시간: " + formattedDateTime);
	
	
	        /* ... */
	        log.info("save-data Controller");
	//		Member member = new Member();
	//		member.setUserEmail("test");
	        Member member = (Member) session.getAttribute("member");
	
	        Board board = new Board();
	        board.setBoardTitle(gridtitle);
	        board.setBoardCont(gridData);
	        board.setBoardDate(formattedDateTime);
	        board.setBoardLike("3");
	//        board.setBoardTag(tagList);
	        board.setSeries(new Series());
	        board.setThumbnailPath("test");
	        board.setMember(member);
	
	        if ((!selSeries.isEmpty()) && (selSeries != null)) {
	            Series series = null;
	            if (testSService.isIn(selSeries) == null) {    //새로운 시리즈일경우
	                series = new Series();
	                series.setSeriesName(selSeries);
	            } else {
	                series = testSService.isIn(selSeries);
	            }
	            series.addBoard(board);
	            series.setCreateDate(formattedDateTime);
	            series.setUpdateDate(formattedDateTime);
	            series.setMember(member);                    /////여기가 문제
	            testSService.save(series);
	        } else {
	            Series series = new Series();
	            series.addBoard(board);
	            testSService.save(series);
	        }
	
	        boardService.insertData(board);
	
	
	        //태그 부분
	        try {
	        	String[] tagsArray = tagList.split(",");
	    		for (int i = 0; i < tagsArray.length; i++) {
	    		    Tags tags = new Tags();
			    	tags.setBoard(board);
	    		    tags.setMember(member);
			    	tags.setTagsName(tagsArray[i]);
			    	tagService.save(tags);
	    		}
			} catch (TagNullException e) {
				log.error(e.getMessage());
			}
	
	        testTemporaryService.deleteById(member, tempId);
        
        return "redirect:/mainBoard";
    }


}