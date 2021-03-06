package com.sean.im.friend.action;

import com.sean.im.friend.constant.Params;
import com.sean.im.friend.service.GroupServiceImpl;
import com.sean.service.annotation.ActionConfig;
import com.sean.service.annotation.ResourceConfig;
import com.sean.service.core.Action;
import com.sean.service.core.Session;

@ActionConfig(description = "重命名分组", authenticate = false,
mustParams = { Params.groupId, Params.groupName })
public class RenameGroupAction extends Action
{
	@ResourceConfig
	private GroupServiceImpl gsi;

	@Override
	public void execute(Session session) throws Exception
	{
		long groupId = session.getLongParameter(Params.groupId);
		String groupName = session.getParameter(Params.groupName);

		gsi.renameGroup(groupId, groupName);
		session.success();
	}
}
