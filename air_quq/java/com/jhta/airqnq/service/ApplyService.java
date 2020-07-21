package com.jhta.airqnq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.airqnq.dao.ApplyDao;
import com.jhta.airqnq.vo.RentListVo;

@Service
public class ApplyService {
	@Autowired
	private ApplyDao dao;

	public List<RentListVo> applyList(int menum) {
		return dao.applyList(menum);
	}
}
