package com.board.example.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import javax.activation.CommandMap;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;

import com.board.example.dto.BoardDTO;
import com.board.example.service.BoardServiceImpl;

@Controller
@RequestMapping("/board/*") 
public class BoardController{
	
	
	@Autowired
	BoardServiceImpl boardServiceImpl;
	
	@RequestMapping("list.do")
	public String boardList(Model model) throws Exception  {
		List<BoardDTO> list = boardServiceImpl.boardList();
		model.addAttribute("list", list); 
		return "board/list";
	}
	
	@RequestMapping("write")
	public String writePage() {
		return "board/write";
	}
	
	@RequestMapping(value="write.do", method=RequestMethod.POST)
	public String write(BoardDTO dto, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
	
		String userId = (String)session.getAttribute("userId");
		
		dto.setUserId(userId);
		boardServiceImpl.write(dto, request);
		return "redirect:list.do";
	}
	
	/*@RequestMapping(value="insert.do", method=RequestMethod.POST)
	public String insert(@ModelAttribute BoardDTO dto, HttpSession session, HttpServletRequest request) throws Exception{

		String userId = (String)session.getAttribute("userId");

		dto.setUserId(userId);
		boardServiceImpl.write(dto, request);
		return "redirect:list.do";
	}*/
	
	@RequestMapping(value="view.do", method=RequestMethod.GET)
	public String view(@RequestParam int boardId, Model model) throws Exception{
		BoardDTO dto = boardServiceImpl.view(boardId);
		model.addAttribute("dto", dto);	
		return "board/view";		
	}
	
	@RequestMapping(value="update", method=RequestMethod.GET)
	public String update(@RequestParam int boardId, Model model) throws Exception{
		BoardDTO dto = boardServiceImpl.view(boardId);	
		model.addAttribute("dto", dto);	
		return "board/update";	
	}
	
	@RequestMapping(value="update.do", method=RequestMethod.POST)
	public String updateSave(BoardDTO dto) throws Exception{
		boardServiceImpl.update(dto);
		return "redirect:list.do";
	}
	
	@RequestMapping(value="delete.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@RequestParam int boardId) throws Exception{
		boardServiceImpl.delete(boardId);
		return "redirect:list.do";
	}	
	

	// 다중파일업로드
    @RequestMapping(value = "/file_uploader_html5.do",
                  method = RequestMethod.POST)
    @ResponseBody
    public String multiplePhotoUpload(HttpServletRequest request) {
        // 파일정보
        StringBuffer sb = new StringBuffer();
        try {
            // 파일명을 받는다 - 일반 원본파일명
            String oldName = request.getHeader("file-name");
            // 파일 기본경로 _ 상세경로
            String filePath = "C:\\Users\\LG\\git\\board\\member\\src\\main\\webapp\\resources\\upload\\";
            String saveName = sb.append(new SimpleDateFormat("yyyyMMddHHmmss")
                          .format(System.currentTimeMillis()))
                          .append(UUID.randomUUID().toString())
                          .append(oldName.substring(oldName.lastIndexOf("."))).toString();
            InputStream is = request.getInputStream();
            OutputStream os = new FileOutputStream(filePath + saveName);
            int numRead;
            byte b[] = new byte[Integer.parseInt(request.getHeader("file-size"))];
            while ((numRead = is.read(b, 0, b.length)) != -1) {
                os.write(b, 0, numRead);
            }
            os.flush();
            os.close();
            // 정보 출력
            sb = new StringBuffer();
            sb.append("&bNewLine=true")
              .append("&sFileName=").append(oldName)
              .append("&sFileURL=").append("http://localhost:8081/member/resources/upload/")
        .append(saveName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}

