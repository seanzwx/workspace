package com.sean.service.worker;

import com.sean.service.core.Action;
import com.sean.service.core.Session;
import com.sean.service.spi.FrameworkSpi;

/**
 * 权限验证工作节点
 * @author sean
 */
public class PermissionWorker implements Worker
{
	private FrameworkSpi userInterface;
	private Worker nextWorker;

	public PermissionWorker(FrameworkSpi userInterface, Worker nextWorker)
	{
		this.userInterface = userInterface;
		this.nextWorker = nextWorker;
	}

	@Override
	public void work(Session session, Action action) throws Exception
	{
		if (!userInterface.checkPermission(session, action.getActionEntity().getPermission()))
		{
			session.denied();
		}
		else
		{
			this.nextWorker.work(session, action);
		}
	}
}
