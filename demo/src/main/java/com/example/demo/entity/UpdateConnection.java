package com.example.demo.entity;

public class UpdateConnection {
	 private String status;
	    private String planType;
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getPlanType() {
			return planType;
		}
		public void setPlanType(String planType) {
			this.planType = planType;
		}
		public UpdateConnection() {
			super();
		}
		public UpdateConnection(String status, String planType) {
			super();
			this.status = status;
			this.planType = planType;
		}
		@Override
		public String toString() {
			return "UpdateConnection [status=" + status + ", planType=" + planType + ", getStatus()=" + getStatus()
					+ ", getPlanType()=" + getPlanType() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
					+ ", toString()=" + super.toString() + "]";
		}
}
