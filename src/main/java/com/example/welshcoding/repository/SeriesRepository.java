package com.example.welshcoding.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.welshcoding.dto.BoardDTO;
import com.example.welshcoding.domain.Board;
import com.example.welshcoding.domain.Series;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class SeriesRepository {
	
	private final EntityManager em;

	public List<Series> findSeriesAll(Long memberId) {
		String query = "select s from Series s INNER JOIN s.member m"
				+ " where m.memberId = :memberid";
		return em.createQuery(query, Series.class)
				 .setParameter("memberid", memberId)
				 .getResultList();
	}

	public List<Board> findBoardsBySeries(Long memberId,Long seriesId) {
		List<Board> boards = new ArrayList<>();
		Query query = em.createQuery("SELECT b FROM Board b WHERE b.series.seriesId = :seriesId AND b.member.memberId = :memberId  ", Board.class);
		query.setParameter("memberId", memberId);
        query.setParameter("seriesId", seriesId);
        boards = (List<Board>) query.getResultList();
        
		return boards;
	}

	public Series findById(Long seriesId) {
		return em.find(Series.class, seriesId);
	}

	@Transactional
	public void deleteSeries(Series series) {
		 em.remove(series);
	}

}
