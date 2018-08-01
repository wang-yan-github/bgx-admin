package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目类型
 * 
 * @author wangYan
 * @email wangYanJava@gmail.com
 * @date 2018-07-13 10:48:42
 */
@TableName("sys_protype")
public class ProtypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 类别id
	 */
	@TableId
	private Integer id;
	/**
	 * 类别
	 */
	private String type;
	/**
	 * 名称
	 */
	private String name;

	/**
	 * 设置：类别id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：类别id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：类别
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：类别
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：名称
	 */
	public String getName() {
		return name;
	}
}
