package kh.servlet.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/ex1") // form 에서 action에 작성해주는 경로 연결
public class ExampleServlet2 extends HttpServlet {
	//private static final long serialVersionUID = 1L;
       
	
	@Override // HttpServlet 에 있는 doGet 메서드 재사용
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		/*
		 req, resp 에 대해
		 HttpServletRequest
		 - 클라이언트 요청 시 자동으로 생성되는 객체
		 - 요청시 전달된 데이터, 요청한 클라이언트 정보, 요청을 유연하게 처리하기 위한 객체 제공
		 
		  HttpServletResponse
		  - 클라이언트 요청 시 자동으로 생성되는 객체
		  - 서버가 클라이언트에게 응답 할 수 있는 방법을 제공
		  서버 -> 클라이언트 출력 스트림 (Print Writer)
		  -- index .html 파일을 만들어서 제출된 이름과 나이 얻어오기
		  --> 제출된 이름과 나이 = 전달 매개변수 == 전달된 값 보여줄 것
		  >>> 요청에 담긴 특정 파라미터 가져오는것은 name 속성을 통해
		  >>> String HttpServletRequest.getParameter("name 속성값")
		 */
		String inputName = request.getParameter("inputName");
		// 고객들이 작성된 값을 getParameter 에서 name에 지정한 별칭으로 가져오기
		//<input type='text' name='inputName'> 의 제출 값을 가져온다.
		String inputAge = request.getParameter("inputAge");
		System.out.println("[서버] / ex1 요청을 받음");
		System.out.println("전달 받은 inputName : " + inputName);
		System.out.println("전달 받은 inputAge : " + inputAge);
		
	//	1) 응답하는 문서 형식 및 문자 인코딩 지정
		response.setContentType("text/html;charset=utf-8");
		
		//	2) 출력용 스트림 얻어오기
		PrintWriter out = response.getWriter();
		
		//	3) 스트림을 이용해서 html 코드 출력하기
		StringBuilder sb = new StringBuilder();
		sb.append("<!Doctype html>");
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title> /ex1 응답페이지 </title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append(String.format("<h1> %s 님의 나이는 %s 입니다. </h1>",inputName,inputAge));
		
		sb.append("</body>");
		sb.append("</html>");
		out.print(sb.toString());
		
	} //GET 방식 요청. method="get" 인 html form tag 제출했을 때 처리하는 메서드 
	
	/*
	 	응답 처리 :
	 	1) HTML 문서 출력 > 응답 문서 형식 및 인코딩 지정
	 	2) 출력용 스트림 전달
	 	3) 스트림을 이용한 html 코드 출력
	 	
	 	
	 	
	 */
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
