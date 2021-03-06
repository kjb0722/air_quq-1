package com.jhta.airqnq.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhta.airqnq.pageUtil.PageUtilForMySql;
import com.jhta.airqnq.service.OnlineListServer;
import com.jhta.airqnq.vo.EP_ManagementVo;
import com.jhta.airqnq.vo.basketVo;

@Controller
public class OnlineListController {
	@Autowired private OnlineListServer service;
	
	@RequestMapping("/ep_OnlineList")
	public String Ep_OnlineList(Model model , HttpSession session) {
		
		

		
		int CookListC=service.onlineCookListC();
		PageUtilForMySql cookPageUtil=new PageUtilForMySql(1,CookListC,5,1);	
		List<EP_ManagementVo> cooklist=service.onlineCookList(cookPageUtil.getStartRow()); 
		model.addAttribute("CookList" ,cooklist);//요리
		model.addAttribute("cookPageUtil" ,cookPageUtil);//요리
		
		int sportlistC=service.onlineSportListC();
		PageUtilForMySql sportPageUtil=new PageUtilForMySql(1,sportlistC,5,1);	
		List<EP_ManagementVo> sportlist=service.onlineSportList(sportPageUtil.getStartRow());
		model.addAttribute("sportlist" ,sportlist);//스포츠
		model.addAttribute("sportPageUtil" ,sportPageUtil);//스포츠
		
		int regdatelistC=service.OnlineRegdateListC();
		PageUtilForMySql regdatePageUtil=new PageUtilForMySql(1,regdatelistC,5,1);
		List<EP_ManagementVo> regdatelist=service.OnlineRegdateList(regdatePageUtil.getStartRow());
		model.addAttribute("regdatelist" ,regdatelist);//신규
		model.addAttribute("regdatePageUtil" ,regdatePageUtil);// 갯수
		
		int OnlineAllList=service.OnlineAllListC();
		PageUtilForMySql AllListPageUtil=new PageUtilForMySql(1,OnlineAllList,15,1);
		List<EP_ManagementVo> Alllist=service.OnlineAlllList(AllListPageUtil.getStartRow());
		model.addAttribute("Alllist" ,Alllist);//전체
		model.addAttribute("AllListPageUtil" ,AllListPageUtil);// 전체
		return ".ep_SearchList.OnlineAllList";
	}
	
	@RequestMapping(value = "/ep_AllList" ,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String Ep_AllList(int pagenum, int AllListtotal) {
		
		JSONObject json=new JSONObject();
		PageUtilForMySql AllListPageUtil=new PageUtilForMySql(pagenum,AllListtotal,15,1);
		List<EP_ManagementVo> alllist=service.OnlineAlllList(AllListPageUtil.getStartRow());
	
		json.put("alllist", alllist);
		json.put("AllListPageUtil", AllListPageUtil);
		return  json.toString();
		
	}
	
	
	
	
	@RequestMapping(value = "/ep_cook" ,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String Ep_cook(int pagenum, int cooktotalR) {
		
		JSONObject json=new JSONObject();
		
		PageUtilForMySql cookPageUtil=new PageUtilForMySql(pagenum,cooktotalR,5,1);
		List<EP_ManagementVo> cooklist=service.onlineCookList(cookPageUtil.getStartRow());
		System.out.println(cooklist + "  쿡 list");
		json.put("cooklist", cooklist);
		return  json.toString();
		
	}
	
	@RequestMapping(value = "/test" ,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String test(int cooktotalR , int pagenum) {
		
		JSONObject json=new JSONObject();
		json.put("test","왜 안되니? page" + pagenum+ " 전체 " + cooktotalR);
		return  json.toString();
		
	}
	
	
	
	
	
	
	
	@RequestMapping(value = "/ep_sport" ,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String Ep_sport(int pagenum, int sporttotalR) {
		
		JSONObject json=new JSONObject();
		PageUtilForMySql sportPageUtil=new PageUtilForMySql(pagenum,sporttotalR,5,1);
		List<EP_ManagementVo> sportlist=service.onlineSportList(sportPageUtil.getStartRow());
			
		json.put("sportlist", sportlist);
		return  json.toString();	
	}
	
	@RequestMapping(value = "/ep_regdate" ,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String Ep_regdate(int pagenum, int regdatetotalR) {
		JSONObject json=new JSONObject();
		
		PageUtilForMySql regdatePageUtil=new PageUtilForMySql(pagenum,regdatetotalR,5,1);
		List<EP_ManagementVo> regdatelist=service.OnlineRegdateList(regdatePageUtil.getStartRow());	
		json.put("regdatelist", regdatelist);
		
		return  json.toString();
		
	}
	
	@RequestMapping(value = "/onlinePick" ,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String onlinePick(int hinum , int num , HttpSession session){
		int menum=(int)session.getAttribute("menum");
		JSONObject json=new JSONObject();
		
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("hinum", hinum);
		map.put("menum", menum);
		
		if(num==1) { // 찜하기
			service.onlineMyPickInsert(map);
			
			json.put("success", "찜 하 기 ");
		}
		if(num==2) { // 찜 취소
			service.onlineMyPickDelete(map);
			
			json.put("success", "찜 취 소 ");
		}
		
		return json.toString();
		
	}
}
