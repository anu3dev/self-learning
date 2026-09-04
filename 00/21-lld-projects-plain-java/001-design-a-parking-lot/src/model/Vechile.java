package model;

import enums.MembershipType;
import enums.VechileType;

public class Vechile {
	private int id;
	private VechileType type;
	private String vechileNumber;
	private MembershipType membershipType;
	private String vechileColor;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public VechileType getType() {
		return type;
	}
	public void setType(VechileType type) {
		this.type = type;
	}
	
	public String getVechileNumber() {
		return vechileNumber;
	}
	public void setVechileNumber(String vechileNumber) {
		this.vechileNumber = vechileNumber;
	}
	
	public MembershipType getMembershipType() {
		return membershipType;
	}
	public void setMembershipType(MembershipType membershipType) {
		this.membershipType = membershipType;
	}
	
	public String getVechileColor() {
		return vechileColor;
	}
	public void setVechileColor(String vechileColor) {
		this.vechileColor = vechileColor;
	}
	
	@Override
	public String toString() {
		return "Vechile [id=" + id + ", type=" + type + ", vechileNumber=" + vechileNumber + ", membershipType="
				+ membershipType + ", vechileColor=" + vechileColor + "]";
	}
}
