package io.renren.modules.word.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author wangYan
 * @email wangYanJava@gmail.com
 * @date 2018-07-25 18:07:56
 */
@TableName("tb_worker_project")
public class WorkerProjectEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 包工侠、劳务、劳务公司项目id 
	 */
	@TableId
	private Long wPId;
	/**
	 * 项目新增时间 
	 */
	private Date addTime;
	/**
	 * 合同id(对应合同表) 
	 */
	private Long ctId;
	/**
	 * 项目备案号 
	 */
	private String recordNumber;
	/**
	 * 类型（2.劳务公司、3.包工侠、4.劳务） 
	 */
	private Integer type;
	/**
	 * 推劳务（1是，0否） 
	 */
	private Integer wIsPushWorker;
	/**
	 * 发包方项目id 
	 */
	private Long wProjectId;
	/**
	 * 包工侠、劳务、劳务公司项目状态 
	 */
	private Integer wStatus;
	/**
	 * 包工侠、劳务、劳务公司id 
	 */
	private Long wWorkerId;
	/**
	 * 包工侠项目id 
	 */
	private Long wWorkerProjectId;
	/**
	 * 劳务公司项目id 
	 */
	private Long wsProjectId;

	public Long getwPId() {
		return wPId;
	}

	public void setwPId(Long wPId) {
		this.wPId = wPId;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Long getCtId() {
		return ctId;
	}

	public void setCtId(Long ctId) {
		this.ctId = ctId;
	}

	public String getRecordNumber() {
		return recordNumber;
	}

	public void setRecordNumber(String recordNumber) {
		this.recordNumber = recordNumber;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getwIsPushWorker() {
		return wIsPushWorker;
	}

	public void setwIsPushWorker(Integer wIsPushWorker) {
		this.wIsPushWorker = wIsPushWorker;
	}

	public Long getwProjectId() {
		return wProjectId;
	}

	public void setwProjectId(Long wProjectId) {
		this.wProjectId = wProjectId;
	}

	public Integer getwStatus() {
		return wStatus;
	}

	public void setwStatus(Integer wStatus) {
		this.wStatus = wStatus;
	}

	public Long getwWorkerId() {
		return wWorkerId;
	}

	public void setwWorkerId(Long wWorkerId) {
		this.wWorkerId = wWorkerId;
	}

	public Long getwWorkerProjectId() {
		return wWorkerProjectId;
	}

	public void setwWorkerProjectId(Long wWorkerProjectId) {
		this.wWorkerProjectId = wWorkerProjectId;
	}

	public Long getWsProjectId() {
		return wsProjectId;
	}

	public void setWsProjectId(Long wsProjectId) {
		this.wsProjectId = wsProjectId;
	}
}
