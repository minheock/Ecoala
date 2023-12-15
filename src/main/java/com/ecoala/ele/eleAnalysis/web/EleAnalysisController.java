package com.ecoala.ele.eleAnalysis.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecoala.ele.eleAnalysis.service.EleAnalysisService;
import com.ecoala.ele.eleAnalysis.vo.EleAnalysisVO;
import com.ecoala.ele.mbrMember.vo.MngMemberVO;



@Controller
public class EleAnalysisController {

	

	@Autowired
	EleAnalysisService eleAnalysisService; 
	

	@RequestMapping("/eleAnalysisView")
	public String eleAnalysis(EleAnalysisVO user , HttpSession session) {
		//사용자 요청정보
		MngMemberVO memberVO = (MngMemberVO) session.getAttribute("login");
		String add = memberVO.getMemId();
		List <EleAnalysisVO> getMemWeather = eleAnalysisService.getMemWeather(add);
		System.out.println(getMemWeather);
		System.out.println("asdasdasdsa");
		System.out.println(add);
		
		//EleAnalysisVO user = new EleAnalysisVO(id,no,ht,mm,week,hum,tem);
		
		 
		
		//1  ~ 6일 정보 
		// 화면으로 고고 
		
		
		// 화면에서 -> flask 요청 1  ~6일정보에 + 예측값 
		// -> 그래프 그리기 
		
		return "user/eleAnalysis/eleAnalysisView";
	}
	

	@ResponseBody
	@PostMapping("/oneMonthEleDo")
	public  List<EleAnalysisVO>  oneMonthEleDo(@RequestBody EleAnalysisVO user) throws Exception {
		 List<EleAnalysisVO> result = eleAnalysisService.oneMonthEle(user);
		return result;
	}
	
	@ResponseBody
	@PostMapping("/comparisonEleDo")
	public  List<EleAnalysisVO>  comparisonEleDo(@RequestBody EleAnalysisVO user) throws Exception {
		 List<EleAnalysisVO> result = eleAnalysisService.comparisonEle(user);
		return result;
	}
	
	@ResponseBody
	@PostMapping("/weatherListDo")
	public  List<EleAnalysisVO>  weatherListDo(@RequestBody EleAnalysisVO user) throws Exception {
		 List<EleAnalysisVO> result = eleAnalysisService.weatherList(user);
		return result;

}
	
}
