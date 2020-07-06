package com.jhta.airqnq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.airqnq.dao.JoinDao;
import com.jhta.airqnq.vo.JoinVo;

@Service
public class JoinService {
	
	@Autowired
	private JoinDao dao;
	
	public int idChk(String id) {
		return dao.idChk(id);
	}
	
	public int insertJoin(JoinVo vo) {
		return dao.insertJoin(vo);
	}
}