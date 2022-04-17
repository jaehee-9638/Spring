package com.test.mvc.controller;




import java.io.File;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.test.mvc.board.biz.MyBoardBiz;
import com.test.mvc.board.dto.MyBoardDto;
import com.test.mvc.utils.UploadFileUtils;

@Controller
public class MyBoardController {

	private Logger logger=LoggerFactory.getLogger(MyBoardController.class);
	
	@Autowired
	private MyBoardBiz biz;
	//
	@Autowired(required =true)
	private String uploadPath;
	
	@RequestMapping("/boardList.do")
	public String selectList(Model model) {
		model.addAttribute("list", biz.selectList());
		return "boardList";
	}
	
	@RequestMapping(value = "/boardSelectOne.do" )
	public String selectOne(Model model,int board_seq) {
		biz.viewCount(board_seq);	//조회수 카운트 
		model.addAttribute("dto", biz.selectOne(board_seq));
		return "boardSelectOne";
	}
	
	@RequestMapping("/boardInsert.do")
	public String insertform() {
		
		return "boardInsert";
	}
	
	@RequestMapping(value = "/boardInsertRes.do",method = RequestMethod.POST)
	public String insertRes(Model model,MyBoardDto dto,MultipartFile file ) throws IOException, Exception {
		String imgUploadPath = uploadPath + File.separator + "imgUpload";	//업로드 path
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);	//date form
		String fileName = null;
		if(file != null) {		
		 fileName =  UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(),
				 	file.getBytes(), ymdPath); //식별자_원본파일명 
		} else {	//view에서 파일첨부x or view에서 controller로 데이터 전송시 오류 
		 fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}
		//DB저장(이미지의 경로를 저장한다.)  ex)resources\imgUpload\날짜\식별자_원본파일명 
		dto.setBoard_thumbimg("resources"+File.separator + "imgUpload" 
				+ ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		dto.setBoard_gdsimg("resources"+File.separator + "imgUpload" 
				+ ymdPath + File.separator + fileName);
		
		
		int res = biz.insert(dto);
		if (res>0) {
			model.addAttribute("list", biz.selectList());
			return "boardList";
		}else {
			
			return "boardInsert";
		}
	}
	
	@RequestMapping("/boardUpdateform.do")
	public String udpateForm(Model model,int board_seq) {
		model.addAttribute("dto", biz.selectOne(board_seq));
		return "boardUpdate";
	}
	@RequestMapping(value = "/boardUpdateRes.do" ,method = RequestMethod.POST )
	public String updateRes(MyBoardDto dto ) {
		
		
		int res = biz.update(dto);
		System.out.println(res);
		
		if (res>0) {//성공시 selectOne으로 -> 글번호 챙겨가 
			
			return "redirect:boardSelectOne.do?board_seq="+dto.getBoard_seq();
		}else {//실패시 다시 업데이트 폼으로 -> 글번호 챙겨가 
			return "redirect:boardUpdateform.do?board_seq="+dto.getBoard_seq();
		}
		
	}
	
	@RequestMapping("/boardDeleteRes.do")
	public String deleteRes(int board_seq) {
		
		if (biz.delete(board_seq)>0) {
			System.out.println("삭제 성공");
			return "redirect:boardList.do";
		}else {
			System.out.println("삭제 실패");
			return "redirect:boardList.do";
		}
	}
	//트랜잭션 -> 게시글 보는거 트랜잭션 걸어서 인터셉터가 못뺏어감 
	@RequestMapping("/test.do")
	public String test() {
		logger.info("[Controller]: test.do");
		
		biz.test();
		
		return "redirect:boardList.do";
	}
	//앞에있던 게시글 목록 + 페이징 기능 구현한거임 
	
	/*
	 * @RequestMapping(value="/boardListPage.do", method = RequestMethod.GET) public
	 * void getListPage(Model model) { model.addAttribute("list", biz.selectList());
	 * //어디로갈지 지정안했는디 ? }
	 */
	//위에꺼 없애야함 .... + 어노테이션 메소드 체크하자 
	// 게시물 목록 + 페이징 추가
	@RequestMapping(value = "/boardListPage.do")
	public String getListPage(Model model,MyBoardDto dto, @RequestParam("num") int num) throws Exception {
	 //parameter로 들어온 num은 페이지 번호임 !
	
	
	 int count = biz.count();	// 게시물 총 갯수
	 int postNum = 10;			// 한 페이지에 출력할 게시물 갯수
	 // 하단 페이징 번호 ([ 게시물 총 갯수 ÷ 한 페이지에 출력할 갯수 ]의 올림)
	 int pageNum = (int)Math.ceil((double)count/postNum);
	 int page_cnt=10; 			//한번에 표시할 페이징 번호의 갯수 
	 //표시되는 페이지 번호 중 마지막 번호 ex) 1~10page=10,11~20page=20 
	 int end_page 
	 	= (int)(Math.ceil((double)num / (double)page_cnt) * page_cnt);
	 //표시되는 페이지 번호 중 첫번째 번호 
	 int first_page=end_page - (page_cnt - 1);
	 
	 //마지막 번호 재계산 : 정확한 마지막 페이지 
	 int endPageNum_tmp 
	 	= (int)(Math.ceil((double)count / (double)page_cnt));
	 if(end_page > endPageNum_tmp) {	
		 end_page = endPageNum_tmp;	
	 }
	 
	 
	 //첫번째 페이지가 1이면 false
	 boolean prev = first_page == 1 ? false : true;
	 //총게시물 보다 마지막페이지*10 이 크면 false
	 boolean next = end_page * page_cnt >= count ? false : true;
	 
	 
	//출력시작할 startNum = (현재 페이지 -1) * 한페이지에 출력할 게시물 갯수 +1 ;
	 int start_num = (num-1) * postNum +1;
	 //list조회하는 biz호출 (parameter: )
	 List<MyBoardDto> list = biz.selectListPage(start_num);
	 
	 
	 //rownum용 (총게시물수,한번에 표시할 페이징 번호의 갯수 )
	 model.addAttribute("count", count);
	 model.addAttribute("page_cnt", page_cnt);
	 
	 //db에서 가져온 화면에 출력할 내용, 페이지번호
	 model.addAttribute("list", list);  
	 model.addAttribute("pageNum", pageNum);	
	 //페이징(시작 및 끝 번호)
	 model.addAttribute("first_page", first_page);
	 model.addAttribute("end_page", end_page);

	 // 이전 및 다음 
	 model.addAttribute("prev", prev);
	 model.addAttribute("next", next);
	// 현재 페이지
	 model.addAttribute("select", num);
	 return "boardListPage";
	}
	
	
}
