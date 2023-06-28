package com.ezen.action;

import javax.servlet.RequestDispatcher;
import org.apache.catalina.connector.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.ezen.vo.ProductVO;

public class ProductList {

	public static void main(String[] args) {
		ProductList c = new ProductList();
		c.Product();
	}
	
	public void Product() {
		
		try {
			
			int k = 1;
			for(int i=1; i<=5; i++) {
				Document doc = Jsoup.connect("http://www.theskinfood.com/shop/shopbrand.html?type=P&xcode=019&sort=&page="+i).get();
				Elements images = doc.select("img.MS_prod_img_l");
				Elements name = doc.select("span.goods_name");
				Elements price = doc.select("span.sale_price");
				
				
//				Elements discount = doc.select("span.icon_solo_discount");
//				Elements dis = doc.select("span.icon_solo_discount");
//				Elements discount = null;
//				if(dcCheck.indexOf(dis) != -1) {
//					discount = doc.select("span.icon_solo_discount");
//				}else {
//					discount = null;
//				}

				for(int j=0; j<images.size(); j++) {
					try {
						System.out.println("번호 : " + k);
						System.out.println("images : "	+ images.get(j).attr("src"));
						System.out.println("name : " + name.get(j).text());
						System.out.println("price : " + price.get(j).text());
						
						ProductVO vo = new ProductVO();
						vo.setCode(k);
						vo.setImage(images.get(j).attr("src"));
						vo.setName(name.get(j).text());
						vo.setPrice(price.get(j).text());
						
						k++;
						
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
		}catch(Exception e) {
		e.printStackTrace();
		}
		
	}
}
