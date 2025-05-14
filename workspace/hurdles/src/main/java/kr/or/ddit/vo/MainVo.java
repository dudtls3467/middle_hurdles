package kr.or.ddit.vo;

import lombok.Data;

@Data
public class MainVo {
	private String localName;
	private int restaurantNo;
	private int cnt;
	private String createDate;
	private int payTotalPrice;
	
	private int memberNo;
}
