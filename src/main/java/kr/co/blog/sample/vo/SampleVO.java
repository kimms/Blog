package kr.co.blog.sample.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class SampleVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1401626992031120653L;

	@ApiModelProperty(value = "샘플 아이디", example = "000111")
	private String sampleId;
	@ApiModelProperty(value = "샘플 이름", example = "홍길동")
	private String sampleName;
	public String getSampleId() {
		return sampleId;
	}
	public void setSampleId(String sampleId) {
		this.sampleId = sampleId;
	}
	public String getSampleName() {
		return sampleName;
	}
	public void setSampleName(String sampleName) {
		this.sampleName = sampleName;
	}
}
