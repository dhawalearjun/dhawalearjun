package com.nextsaa.elm.dto;

import java.time.LocalDateTime;

public class OfficeDTO {

	private Long branchCode;
	
	private String branchName;
	
	private String branchAddress;
	
	private double branchLatitude;
	
	private double branchLongitude;
	
	private double allowedRadius;
	
	private String status;
	
	private LocalDateTime createdAt;
	
	private String createdBy;
	
	private String modifiedBy;
	
	private LocalDateTime modifiedAt;

	public Long getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(Long branchCode) {
		this.branchCode = branchCode;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}

	public double getBranchLatitude() {
		return branchLatitude;
	}

	public void setBranchLatitude(double branchLatitude) {
		this.branchLatitude = branchLatitude;
	}

	public double getBranchLongitude() {
		return branchLongitude;
	}

	public void setBranchLongitude(double branchLongitude) {
		this.branchLongitude = branchLongitude;
	}

	public double getAllowedRadius() {
		return allowedRadius;
	}

	public void setAllowedRadius(double allowedRadius) {
		this.allowedRadius = allowedRadius;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public LocalDateTime getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(LocalDateTime modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	@Override
	public String toString() {
		return "OfficeDTO [branchName=" + branchName + ", branchAddress=" + branchAddress + ", branchLatitude="
				+ branchLatitude + ", branchLongitude=" + branchLongitude + ", allowedRadius=" + allowedRadius
				+ ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(allowedRadius);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((branchAddress == null) ? 0 : branchAddress.hashCode());
		temp = Double.doubleToLongBits(branchLatitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(branchLongitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((branchName == null) ? 0 : branchName.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OfficeDTO other = (OfficeDTO) obj;
		if (Double.doubleToLongBits(allowedRadius) != Double.doubleToLongBits(other.allowedRadius))
			return false;
		if (branchAddress == null) {
			if (other.branchAddress != null)
				return false;
		} else if (!branchAddress.equals(other.branchAddress))
			return false;
		if (Double.doubleToLongBits(branchLatitude) != Double.doubleToLongBits(other.branchLatitude))
			return false;
		if (Double.doubleToLongBits(branchLongitude) != Double.doubleToLongBits(other.branchLongitude))
			return false;
		if (branchName == null) {
			if (other.branchName != null)
				return false;
		} else if (!branchName.equals(other.branchName))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	
	
}
