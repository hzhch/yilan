package hzc.yilan.entity;

import java.util.List;

public class NationalNewsObject {
	private List<NationalNews> result;
	private int error_code;
	private String reason;
	
	
	
	public NationalNewsObject(List<NationalNews> result, int error_code,
			String reason) {
		super();
		this.result = result;
		this.error_code = error_code;
		this.reason = reason;
	}
	public List<NationalNews> getResult() {
		return result;
	}
	public void setResult(List<NationalNews> result) {
		this.result = result;
	}
	public int getError_code() {
		return error_code;
	}
	public void setError_code(int error_code) {
		this.error_code = error_code;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public NationalNewsObject() {
		super();
	}

	

}
