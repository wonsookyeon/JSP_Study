package com.ezen.dao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.ezen.vo.FaqVO;

public class FaqDAO {

	private static FaqDAO instance = new FaqDAO();

	private FaqDAO() {}

	public static FaqDAO getinstance() {
		return instance;
	}

	public List<FaqVO> goCrawling() throws IOException{

		List<FaqVO> list = new ArrayList<>();
		FaqVO fVo = null; 
		/*FAQ 스킨푸드 크롤링*/

		int k=1;
		//1페이지만 크롤링
		for(int i=1; i<=1; i++) {	

		
			Document doc = Jsoup.connect("https://www.theskinfood.com/shop/faq.html").get();		
			//	Elements subject = doc.select("span.default-board__item-title");		//1페이지에 있는 모든 제목들.
			Elements subjects = doc.getElementsByClass("default-board__item-title");//1페이지에 있는 모든 제목들.
			/*
			 * <span class="default-board__item-title"> <span class="cat">[회원정보/멤버십]</span> 포인트 유효기간은 어떻게 되나요?</span>
			<span class="default-board__item-title"> <span class="cat">[이벤트/쿠폰]</span> 포인트 소멸기간이 있나요?</span>
			<span class="default-board__item-title"> <span class="cat">[주문/결제/배송]</span> 배송일은 얼마나 걸리나요?</span>
			 * */

			Elements contents = doc.select("li.default-board__content.hide");//1페이지에 있는 모든 content들.

			//System.out.println(contents.text());
			//Element content = contents.get(1);
			//			System.out.println(content.text()); //하나만 불러오는것.


			for (int j=0; j<20; j++) {
				fVo = new FaqVO();
				fVo.setSubject(subjects.get(j).text());
				fVo.setContent(contents.get(j).text());

				list.add(fVo);
			}


		}
		return list;

	}
}
