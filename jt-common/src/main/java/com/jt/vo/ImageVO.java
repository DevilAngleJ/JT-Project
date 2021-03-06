package com.jt.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class ImageVO {

	private Integer error;
	private String url;
	private Integer width;
	private Integer length;
	
	
	public static ImageVO fail() {
		return new ImageVO(1,null,null,null);
	}

	public static ImageVO success(String url) {
		return new ImageVO(0,url,null,null);
	}

	public static ImageVO sucess(String url,Integer width,Integer length) {
		return new ImageVO(0,url,width,length);
	}
}
