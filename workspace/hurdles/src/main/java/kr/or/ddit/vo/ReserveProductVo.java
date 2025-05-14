package kr.or.ddit.vo;

import lombok.Data;

@Data
public class ReserveProductVo {
	
	private int reserveProductNo;
	private int restaurantNo;
	private int fileNo;
	private String reserveProductName;
	private String reserveProductDes;
	private int reserveProductCount;
	private String delyn;
	private String createDate;

	private String fileSaveName;
}	
