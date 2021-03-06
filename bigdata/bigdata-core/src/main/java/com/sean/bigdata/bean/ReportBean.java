package com.sean.bigdata.bean;

import java.util.ArrayList;
import java.util.List;

import com.sean.bigdata.entity.AclEntity;
import com.sean.bigdata.entity.ExecuteEntity;
import com.sean.bigdata.entity.ReportEntity;
import com.sean.common.ioc.BeanConfig;
import com.sean.common.util.TimeUtil;
import com.sean.persist.core.Dao;
import com.sean.persist.core.PageData;
import com.sean.persist.enums.OrderEnum;
import com.sean.persist.ext.Condition;
import com.sean.persist.ext.Order;

@BeanConfig("")
public class ReportBean
{
	public long createReport(ReportEntity report, long userId)
	{
		report.createTime = TimeUtil.getYYYYMMDDHHMMSSTime();
		report.creater = userId;
		Dao.persist(ReportEntity.class, report);
		return report.reportId;
	}

	public List<ReportEntity> getReportList(List<AclEntity> aclList)
	{
		List<Object> ids = new ArrayList<>(aclList.size());
		for (AclEntity it : aclList)
		{
			ids.add(it.reportId);
		}
		return Dao.loadByIds(ReportEntity.class, ids);
	}

	public PageData<ReportEntity> getReportList(long creater, int pageNo, int pageSize)
	{
		return Dao.getListByPage(ReportEntity.class, new Condition("creater", creater), new Order("reportId", OrderEnum.Desc), pageNo, pageSize, -1);
	}

	public ReportEntity getReportById(long reportId)
	{
		return Dao.loadById(ReportEntity.class, reportId);
	}

	public void deleteReport(long reportId)
	{
		Dao.remove(AclEntity.class, "reportId", reportId);
		Dao.remove(ExecuteEntity.class, "reportId", reportId);
		Dao.remove(ReportEntity.class, reportId);
	}
}
