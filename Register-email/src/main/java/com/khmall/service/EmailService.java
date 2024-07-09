package com.khmall.service;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //@Autowired = 변수 마다 하나씩 설정 안해도 밖에서 고정시킴.
// @RequiredArgsConstructor는 Autowired와 같지만 외부에서 전체적으로 설정해줌
public class EmailService {

	//java 에서 제공하는 이메일 보내기 기능 틀
	//틀만 제공 : 이메일을 전송하는데 어느 회사, 어느 규격 이메일인지 알 수 없기 때문에
	//이메일을 보낼 때 보내는이, 내용, 받는이
	private final JavaMailSender javaMailSender;
	
	private static final String senderEmail = "kulee728@gmail.com";
	//application properties 에 참조한 이메일 그대로
	private int number; //인증번호 저장

	public void authNumGenerator() {
		number = (int)(Math.random()*90000)+100000;
	}
	
	//메일 양식 작성
	public MimeMessage createMail(String mail) {
		//인증번호 생성
		// MimeMessage 생성된 인증번호 담는 변수
		authNumGenerator();
		MimeMessage msg = javaMailSender.createMimeMessage();
		try {
			msg.setFrom(senderEmail);
			msg.setRecipients(MimeMessage.RecipientType.TO,mail);
			//메세지.setRecipent >> address 타입의 메일을 넣어줘야함.
			//태그로 img src 이미지 등 보낼 수 있음
			//첨부파일 참조 태그 이용해서 같이 보낼 수 있음
			msg.setSubject("이메일 인증: Spring 배우는 "+senderEmail);
			String emailContent = "";
			emailContent += "<h3>"+"요청하신 인증 번호입니다."+"</h3>";
			emailContent += "<h1>"+"인증번호 : "+number+"</h1>";
			msg.setText(emailContent,"utf-8","html");
			
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return msg;		
	}
	
	//sendMail은 인증번호 이메일을 보내고 그 인증번호를 return 한다
	public int sendMail(String mail) {
		MimeMessage msg = createMail(mail);
		javaMailSender.send(msg);
		return number;
	}
	
	
	
}
