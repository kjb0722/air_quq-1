package com.jhta.airqnq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.airqnq.dao.EP_ManagementDao;
import com.jhta.airqnq.vo.EP_ManagementVo;

@Service
public class EP_ManagementService {
	@Autowired private EP_ManagementDao dao;
	
	public int ep_inserting(String id){
		return dao.ep_inserting(id);
	}
	public List<EP_ManagementVo> ep_insertlist(int loginnum){
		return dao.ep_insertlist(loginnum);
	}
	public EP_ManagementVo ep_management(int hinum) {
		return dao.ep_management(hinum);
	}
	public int ep_list_delete(int hinum) {
		return dao.ep_list_delete(hinum);
	}
	public List<EP_ManagementVo> ep_imglimit(int memnum){
		return dao.ep_imglimit(memnum);
	}
	public List<EP_ManagementVo> epimglist(int hinum) {
		return dao.epimglist(hinum);
	}
}
