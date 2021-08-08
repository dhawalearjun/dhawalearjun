package com.nextsaa.elm.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.nextsaa.elm.util.enums.OfficeStatus;

@Entity
@Table(name = "branch_offices")
public class Office {

	@Id
	@Column(name = "branch_code")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long branchCode;

	@Column(name = "branch_name")
	private String branchName;

	@Column(name = "branch_address")
	private String branchAddress;

	@Column(name = "latitude", nullable = false)
	private double latitude;

	@Column(name = "longitude", nullable = false)
	private double longitude;

	@Column(name = "radius", nullable = false)
	private double radius;

	@Column(name = "created_at", nullable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;

	@Column(name = "created_by", nullable = false)
	private String createdBy;

	@Column(name = "modified_at", nullable = false)
	@CreationTimestamp
	private LocalDateTime modifiedAt;

	@Column(name = "modified_by", nullable = false)
	private String modifiedBy;

	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.STRING)
	private OfficeStatus status;

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

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
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

	public LocalDateTime getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(LocalDateTime modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public OfficeStatus getStatus() {
		return status;
	}

	public void setStatus(OfficeStatus status) {
		this.status = status;
	}
}
