package com.sean.service.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.sean.service.annotation.ActionConfig;
import com.sean.service.annotation.ParameterConfig;
import com.sean.service.config.ServiceConfig;
import com.sean.service.constant._P;
import com.sean.service.core.Action;
import com.sean.service.core.ApplicationContext;
import com.sean.service.core.Session;
import com.sean.service.enums.DataType;
import com.sean.service.enums.ReturnType;

@ActionConfig(authenticate = false, returnType = ReturnType.Js, description = "加载合并js脚本", 
mustParams = { _P.js })
@SuppressWarnings("unused")
public final class LoadJsAction extends Action
{
	private Map<String, String> cache = new HashMap<String, String>();
	private SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z");
	
	@Override
	public void execute(Session session) throws Exception
	{
		String js = deleteBlank(session.getParameter("js"));
		
		// 开发模式和伪实现模式开启实时脚本
		if (ServiceConfig.RunningMode_Develop || ServiceConfig.RunningMode_Pseudo)
		{
			String jsstr = this.readRTScripts(session.getRootPath(), js);
			session.setReturnJs(jsstr);
			return;
		}
		
		String ifModifiedSince = session.getHeader("If-Modified-Since");
		// 浏览器没有缓存
		if (ifModifiedSince == null)
		{
			String jsstr = this.readScripts(session.getRootPath(), js);
			session.setReturnJs(jsstr);	
		}
		// 浏览器有缓存，验证是否过期
		else
		{
			long time = 0;
			try
			{
				time = sdf.parse(ifModifiedSince).getTime();	
			}
			catch(Exception e)
			{
				// 转换时间异常
				time = 0;
			}
			long launchTime = ApplicationContext.CTX.getLaunchTime();
			if (time <= launchTime)
			{
				String jsstr = this.readScripts(session.getRootPath(), js);
				session.setReturnJs(jsstr);	
			}
		}
	}
	
	/**
	 * 读取js脚本
	 */
	private String readScripts(String rootPath, String js) throws Exception
	{
		// 读取js代码
		int totalLength = 0;
		String[] tmp = js.split(",");
		String code = null;
		File file = null;
		List<String> files = new ArrayList<String>(tmp.length);
		for (int i = 0; i < tmp.length; i++)
		{
			code = cache.get(tmp[i]);
			if (code == null)
			{
				file = new File(rootPath + tmp[i]);
				if (file.exists())
				{
					code = "\r\n/* " + tmp[i] + " */\r\n" + FileUtils.readFileToString(file);
					files.add(code);
					totalLength += code.length();

					cache.put(tmp[i], code);
				}
			}
			else
			{
				files.add(code);
			}
		}

		// 合并js代码
		StringBuilder sb = new StringBuilder(totalLength);
		int length = files.size();
		for (int i = 0; i < length; i++)
		{
			sb.append(files.get(i));
		}

		return sb.toString();
	}

	/**
	 * 开发模式和伪实现模式实时读取脚本
	 */
	private String readRTScripts(String rootPath, String js) throws Exception
	{
		StringBuilder sb = new StringBuilder(102400);
		String[] tmp = js.split(",");
		for (int i = 0; i < tmp.length; i++)
		{
			File file = new File(rootPath + tmp[i]);
			if (file.exists())
			{
				sb.append("\r\n/* ").append(tmp[i]).append(" */\r\n");
				sb.append(FileUtils.readFileToString(file));
			}
		}
		return sb.toString();
	}
	
	public String deleteBlank(String js)
	{
		StringBuilder sb = new StringBuilder(js.length());
		int length = js.length();
		char c;
		for (int i = 0; i < length; i++)
		{
			c = js.charAt(i);
			if (c != ' ')
			{
				sb.append(c);
			}
		}
		return sb.toString();
	}
}
