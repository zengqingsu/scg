package com.zqs.scg.common.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体基类（实体表）
 * @author xiao
 *
 */
public class BaseEntity implements Serializable {
   
	private static final long serialVersionUID = 5020426414815989827L;

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
    
    //最后修改人
    private Integer lastModifiedBy;
    
    //最后修改人Code
    private String lastModifiedCode;
    
    //最后修改人名称
    private String lastModifiedName;
    
    //最后修改时间
    private Date lastModifiedDate;
    
    //删除标记
    private Integer delFlag;

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

	public Date getCreatedDate() {
//        /**todo 这个逻辑在更新时还是有些漏洞，需要再考虑下**/
//        /**正解是在update逻辑中不能更新相关字段，这个需要在框架层面考虑**/
//        if(createdDate == null){
//            return new Date();
//        }
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getLastModifiedBy() {
        return lastModifiedBy;
	}

	public void setLastModifiedBy(Integer lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Date getLastModifiedDate() {
        if(lastModifiedDate == null){
            return new Date();
        }
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getCreatedCode() {
//        if(createdCode == null){
//            return "011738";//todo 调试代码
//        }
		return createdCode;
	}

	public void setCreatedCode(String createdCode) {
		this.createdCode = createdCode;
	}

	public String getCreatedName() {
//        if(createdName == null){
//            return "娄宏"; //todo 调试代码
//        }
		return createdName;
	}

	public void setCreatedName(String createdName) {
		this.createdName = createdName;
	}

	public String getLastModifiedCode() {
		return lastModifiedCode;
	}

	public void setLastModifiedCode(String lastModifiedCode) {
		this.lastModifiedCode = lastModifiedCode;
	}

	public String getLastModifiedName() {
		return lastModifiedName;
	}

	public void setLastModifiedName(String lastModifiedName) {
		this.lastModifiedName = lastModifiedName;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((createdCode == null) ? 0 : createdCode.hashCode());
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((createdName == null) ? 0 : createdName.hashCode());
		result = prime * result + ((delFlag == null) ? 0 : delFlag.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastModifiedBy == null) ? 0 : lastModifiedBy.hashCode());
		result = prime * result + ((lastModifiedCode == null) ? 0 : lastModifiedCode.hashCode());
		result = prime * result + ((lastModifiedDate == null) ? 0 : lastModifiedDate.hashCode());
		result = prime * result + ((lastModifiedName == null) ? 0 : lastModifiedName.hashCode());
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
		BaseEntity other = (BaseEntity) obj;
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
		if (delFlag == null) {
			if (other.delFlag != null)
				return false;
		} else if (!delFlag.equals(other.delFlag))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastModifiedBy == null) {
			if (other.lastModifiedBy != null)
				return false;
		} else if (!lastModifiedBy.equals(other.lastModifiedBy))
			return false;
		if (lastModifiedCode == null) {
			if (other.lastModifiedCode != null)
				return false;
		} else if (!lastModifiedCode.equals(other.lastModifiedCode))
			return false;
		if (lastModifiedDate == null) {
			if (other.lastModifiedDate != null)
				return false;
		} else if (!lastModifiedDate.equals(other.lastModifiedDate))
			return false;
		if (lastModifiedName == null) {
			if (other.lastModifiedName != null)
				return false;
		} else if (!lastModifiedName.equals(other.lastModifiedName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BaseEntity{id=" + id + ", createdBy=" + createdBy + ", createdCode='" + createdCode + "', createdName='"
				+ createdName + "', createdDate='" + createdDate + "', lastModifiedBy=" + lastModifiedBy
				+ ", lastModifiedCode='" + lastModifiedCode + "', lastModifiedName='" + lastModifiedName
				+ "', lastModifiedDate='" + lastModifiedDate + "', delFlag=" + delFlag + "}";
	}

	
    
   
}
