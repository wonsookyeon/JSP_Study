package com.ezen.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.ezen.vo.ProductVO;

import util.DBManager;


public class ProductDAO {
	private static ProductDAO instance = new ProductDAO();
	
	private ProductDAO() {}
	
	public static ProductDAO getInstance() {
		return instance;
	}
	
	// 데이터 크롤링해서 list에 받아서 return, list에 저장하면서 DB에도 저장
	public List<ProductVO> productAllSelect() {	
		
		List<ProductVO> list = new ArrayList<ProductVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into productlist values (?,?,?,?)";
		
		try {
			int k = 1;
			for(int i=1; i<=5; i++) {
				Document doc = Jsoup.connect("http://www.theskinfood.com/shop/shopbrand.html?type=P&xcode=019&sort=&page="+i).get();
				Elements images = doc.select("img.MS_prod_img_l");
				Elements name = doc.select("span.goods_name");
				Elements price = doc.select("span.sale_price");
				
				for(int j=0; j<images.size(); j++) {
					try {
//						System.out.println("번호 : " + k);
//						System.out.println("images : "	+ images.get(j).attr("src"));
//						System.out.println("name : " + name.get(j).text());
//						System.out.println("price : " + price.get(j).text());
						
						
						ProductVO vo = new ProductVO();
						vo.setCode(k);
						vo.setImage(images.get(j).attr("src"));
						vo.setName(name.get(j).text());
						vo.setPrice(price.get(j).text().substring(2).replace(",", "")); // DB에 number로 넣기 위해 통화기호랑 , 잘라내기
						
						list.add(vo);
						
						conn = DBManager.getConnection();
						
						pstmt = conn.prepareStatement(sql);
						pstmt.setInt(1, vo.getCode());
						pstmt.setString(2, vo.getName());
						pstmt.setInt(3, Integer.parseInt(vo.getPrice()));
						pstmt.setString(4, vo.getImage());
						
						pstmt.executeUpdate();
					
						k++;
						
					}catch(Exception e) {
						e.printStackTrace();
					}finally {
						try {
							DBManager.close(conn, pstmt);
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		}catch(Exception e) {
		e.printStackTrace();
		}
		return list;
	}
	
	
	// 데이터 1건 추출
	public ProductVO selectOneProductByNum(int num) {
		ProductVO vo= null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from productlist where num = ?";
		
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new ProductVO();
				vo.setCode(rs.getInt("id"));
				vo.setName(rs.getString("name"));
				vo.setPrice(""+rs.getInt("price"));
				vo.setImage(rs.getString("image"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return vo;
	}
	
}
