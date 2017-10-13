package club.wokao666.dto;

import java.util.List;

public class RegisterDto {

	private List<String> nameList;
	private List<Integer> idList;
	public RegisterDto() {
		super();
	}
	public RegisterDto(List<String> nameList, List<Integer> idList) {
		super();
		this.nameList = nameList;
		this.idList = idList;
	}
	public List<String> getNameList() {
		return nameList;
	}
	public void setNameList(List<String> nameList) {
		this.nameList = nameList;
	}
	public List<Integer> getIdList() {
		return idList;
	}
	public void setIdList(List<Integer> idList) {
		this.idList = idList;
	}
}
