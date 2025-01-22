package com.example.welshcoding.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.welshcoding.repository.SeriesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.welshcoding.dto.BoardDTO;
import com.example.welshcoding.domain.Board;
import com.example.welshcoding.domain.Series;
import com.example.welshcoding.dto.SeriesListDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SeriesService {

	private final SeriesRepository seriesRepository;
	
	/* 아이디별 시리즈 리스트*/
	public List<SeriesListDTO> findSeriesAll(Long memberId) throws ParseException {
		
		List<Series> seriesList = seriesRepository.findSeriesAll(memberId);
		List<SeriesListDTO> seriesList_ = new ArrayList<>();
		
		for(Series series : seriesList) {
			SeriesListDTO dto = new SeriesListDTO();
			dto.setSeriesId(series.getSeriesId());
			dto.setSeriesName(series.getSeriesName());
			dto.setBoardCnt(series.getBoards().size());
			dto.setUpdateDateToNow(dateConvert(series.getUpdateDate()));
			dto.setSeriesImgUrl(series.getSeriesImgUrl());
			seriesList_.add(dto);
		}
		
		return seriesList_;
	}

	public String dateConvert(String str) throws ParseException {
		String date1 = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String date2 = str;

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		/* Date타입으로 변경 */
		
		Date d1 = format.parse( date1 );
		Date d2 = format.parse( date2 );
		long Sec = (d1.getTime() - d2.getTime()) / 1000; // 초
		long Days = Sec / (24*60*60); // 일자수
		
//		System.out.println(Days + "일 차이");
		
		return String.valueOf(Days);
	}

	public List<Board> findBoardsBySeries(Long seriesId,Long memberId) {
		return seriesRepository.findBoardsBySeries(memberId,seriesId);
	}

	@Transactional
	public void updateSeriesTitle(Long seriesId, String seriesName) {
		Series series = seriesRepository.findById(seriesId);
		series.setSeriesName(seriesName);
	}

	@Transactional
	public void deleteById(Long seriesId) {
		Series series = seriesRepository.findById(seriesId);
		seriesRepository.deleteSeries(series);
	}

	public Series findSeriesById(Long seriesId) {
		return seriesRepository.findById(seriesId);
	}

}
