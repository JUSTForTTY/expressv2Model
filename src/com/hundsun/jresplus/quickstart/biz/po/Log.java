package com.hundsun.jresplus.quickstart.biz.po;

import java.io.Serializable;
import java.util.Date;

 

 
public class Log implements Serializable {


	 
	private String lid;
 
	private String cmid;

	 
	private Integer bid;

	 
	private Double payment;

 
	private Double amount;
	
	 
	private Integer status;

	 
	private String payType;

	 
	private String payFlag;

	 
	private String createUser;

	 
	private Date createTime;

	 
	private String modifyUser;

 
	private Date modifyTime;


	public void setLid(String lid){
		this.lid = lid;
	}

		return this.lid;
	}

		this.cmid = cmid;
	}

		return this.cmid;
	}

		this.bid = bid;
	}

		return this.bid;
	}

		this.payment = payment;
	}

		return this.payment;
	}

		this.status = status;
	}

		return this.status;
	}

		this.payType = payType;
	}

		return this.payType;
	}

		this.payFlag = payFlag;
	}

		return this.payFlag;
	}

		this.createUser = createUser;
	}

		return this.createUser;
	}

		this.createTime = createTime;
	}

		return this.createTime;
	}

		this.modifyUser = modifyUser;
	}

		return this.modifyUser;
	}

		this.modifyTime = modifyTime;
	}

		return this.modifyTime;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
