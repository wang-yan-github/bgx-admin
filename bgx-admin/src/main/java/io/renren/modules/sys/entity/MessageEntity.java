package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author wangYan
 * @email wangYanJava@gmail.com
 * @date 2018-07-11 10:40:49
 */
@TableName("sys_message")
public class MessageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 消息id
	 */
	@TableId
	private Integer id;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 消息内容
	 */
	private String content;

	/**
	 * 设置：消息id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：消息id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：消息内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：消息内容
	 */
	public String getContent() {
		return content;
	}
}
