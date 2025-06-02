package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class Product1 {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
		private Integer id;
	    
	    private String username;
	    
	    private String productname;
	    
	    private Integer number;
	    
	    private Integer totalprice;
	    
	    private Integer issold;

	    
//	    public Integer getId() {
//			return id;
//		}
	    
		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getProductname() {
			return productname;
		}

		public void setProductname(String productname) {
			this.productname = productname;
		}

		public Integer getNumber() {
			return number;
		}

		public void setNumber(Integer number) {
			this.number = number;
		}

		public Integer getTotalprice() {
			return totalprice;
		}

		public void setTotalprice(Integer totalprice) {
			this.totalprice = totalprice;
		}

		public Integer getIssold() {
			return issold;
		}

		public void setIssold(Integer issold) {
			this.issold = issold;
		}
	    
	    
}
