package com.zqs.scg.manager.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体基类（关系表）
 * @author xiao
 *
 */
public class BaseRelation  implements Serializable {

	private static final long serialVersionUID = -7505052653682855106L;

	//主键
    private Integer id;
    
    //创建人
    private Integer createdBy;
    
    //创建人code
    private String createdCode;
    
    //创建人名称
    private String createdName;
    
    //创建时间
    private Date createdDate;
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedCode() {
		return createdCode;
	}

	public void setCreatedCode(String createdCode) {
		this.createdCode = createdCode;
	}

	public String getCreatedName() {
		return createdName;
	}

	public void setCreatedName(String createdName) {
		this.createdName = createdName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((createdCode == null) ? 0 : createdCode.hashCode());
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((createdName == null) ? 0 : createdName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		BaseRelation other = (BaseRelation) obj;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (createdCode == null) {
			if (other.createdCode != null)
				return false;
		} else if (!createdCode.equals(other.createdCode))
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (createdName == null) {
			if (other.createdName != null)
				return false;
		} else if (!createdName.equals(other.createdName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BaseRelation{id=" + id + ", createdBy=" + createdBy + ", createdCode='" + createdCode + "', createdName='"
				+ createdName + "', createdDate='" + createdDate + "'}";
	}

}
