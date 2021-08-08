package com.nextsaa.elm.mapper;

import com.nextsaa.elm.util.enums.EmployeeStatus;
import com.nextsaa.elm.util.enums.LeaveStatus;
import com.nextsaa.elm.util.enums.LeaveTypeStatus;
import com.nextsaa.elm.util.enums.OfficeStatus;

public class StatusMapper {

    public static EmployeeStatus mapEmployeeStatus(String status) {

        if(status == null){
            return EmployeeStatus.INACTIVE;
        }

        if (status.equals(String.valueOf(EmployeeStatus.ACTIVE))) {
            return EmployeeStatus.ACTIVE;
        } else {
            return EmployeeStatus.INACTIVE;
        }
    }

    public static LeaveStatus mapLeaveStatus(String status) {

        if(status == null){
            return LeaveStatus.PENDING;
        }

        if (status.equals(String.valueOf(LeaveStatus.APPROVED))) {
            return LeaveStatus.APPROVED;
        } else if (status.equals(String.valueOf(LeaveStatus.DENIED))) {
            return LeaveStatus.DENIED;
        } else {
            return LeaveStatus.PENDING;
        }
    }

    public static LeaveTypeStatus mapLeaveTypeStatus(String status) {

        if(status == null){
            return LeaveTypeStatus.INACTIVE;
        }

        if (status.equals(String.valueOf(LeaveTypeStatus.ACTIVE))) {
            return LeaveTypeStatus.ACTIVE;
        } else {
            return LeaveTypeStatus.INACTIVE;
        }
    }
    
    public static OfficeStatus mapOfficeStatus(String status) {

        if(status == null){
            return OfficeStatus.INACTIVE;
        }

        if (status.equals(String.valueOf(OfficeStatus.ACTIVE))) {
            return OfficeStatus.ACTIVE;
        } else {
            return OfficeStatus.INACTIVE;
        }
    }

}
