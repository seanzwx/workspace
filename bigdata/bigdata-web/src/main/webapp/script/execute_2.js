define(function(require, exports, module)
{
	if (window.T == null)
	{
		window.T = new Object();
	}

	require('./common');

	var execute_2 =
	{
		report : null,

		init : function()
		{
			var reportId = T.common.util.getParameter("reportId");
			execute_2.getReport(reportId);
		},

		getReport : function(reportId)
		{
			// 读取报表元数据
			var params =
			{
				reportId : reportId,
			};
			T.common.ajax.requestBlock("InquireReportAction", params, false, function(jsonstr, data, code, msg)
			{
				execute_2.report = data.reportDetail;
				execute_2.showTimeSelect();
			});
		},

		showTimeSelect : function()
		{
			// 计算日期
			var years = new Array();
			years[0] = new Date().getYear() + 1900;
			for (var i = 1; i < 5; i++)
			{
				years[i] = years[0] - i;
			}

			var tplData =
			{
				months : [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12],
				years : years,
				thisYear : years[0],
				thisMonth : new Date().getMonth() + 1,
			};
			var tpl = $('#tpl_timeSelect').html();
			var html = juicer(tpl, tplData);
			$('#right').html(html);

			$('.btn-group li').bind('click', function()
			{
				var li = $(this);
				var button = li.parent().parent().find('button');
				button.html($(li.children().get(0)).html() + ' <span class="caret"></span>');
				button.attr('time', li.attr('value'));

				execute_2.getExecuteList();
			});

			// 月统计
			if (execute_2.report.countType == 2)
			{
				$('#selectMonth').remove();
			}

			execute_2.getExecuteList();
		},

		getExecuteList : function()
		{
			$('#tbody').html('<div align="center"><img src="http://seanzwx.github.io/97igo/image/loading.gif"/></div>');
			var yearOrMonth = "";
			if (execute_2.report.countType == 1)
			{
				yearOrMonth = $('#selectYear').attr('time') + "" + $('#selectMonth').attr('time');
			}
			else if (execute_2.report.countType == 2)
			{
				yearOrMonth = $('#selectYear').attr('time');
			}

			// 读取报表列表
			var params2 =
			{
				reportId : execute_2.report.reportId,
				yearOrMonth : yearOrMonth,
			};
			T.common.ajax.requestBlock("InquireExecuteListAction", params2, false, function(jsonstr, data, code, msg)
			{
				var list = new Array();
				for (var i = 0; i < data.executeList.length; i++)
				{
					var it = data.executeList[i];
					list[list.length] =
					{
						executeTime : T.common.util.time.getYYYYMMDD(it.executeTime),
						success : 1,
						result : it.result,
					};
				}
				var tplData =
				{
					executeList : list
				};
				var tpl = $('#tpl_executeList').html();
				var html = juicer(tpl, tplData);
				$('#tbody').html(html);

				$('#tbody tr').bind('click', function()
				{
					var tr = $(this);
					tr.find('input').prop('checked', !(tr.find('input').prop('checked')));

					execute_2.showReport();
				});

				execute_2.showReport();
			});

			execute_2.showReport();
		},

		showReport : function()
		{
			var x = new Array();
			var series = new Array();
			var trs = $('#tbody tr');
			for (var i = 0; i < trs.length; i++)
			{
				var it = $(trs[i]);
				if (it.find('input').prop('checked'))
				{
					var result = JSON.parse(it.attr('result'));
					x = new Array();
					var y = new Array();
					for (var j = 0; j < result.length; j++)
					{
						x[x.length] = result[j].k;
						y[y.length] = parseFloat(result[j].v);
					}
					series[series.length] =
					{
						name : $(it.children().get(1)).html(),
						data : y
					};
				}
			}

			$('#report').highcharts(
			{
				chart :
				{
					type : 'line'
				},
				title :
				{
					text : execute_2.report.reportName,
					x : -20 //center
				},
				subtitle :
				{
					text : 'Source: WorldClimate.com',
					x : -20
				},
				xAxis :
				{
					title :
					{
						text : execute_2.report.xAxis
					},
					categories : x
				},
				yAxis :
				{
					title :
					{
						text : execute_2.report.yAxis
					},
					plotLines : [
					{
						value : 0,
						width : 1,
						color : '#808080'
					}]
				},
				legend :
				{
					layout : 'vertical',
					align : 'right',
					verticalAlign : 'middle',
					borderWidth : 0
				},
				plotOptions :
				{
					line :
					{
						dataLabels :
						{
							enabled : true
						},
					}
				},
				series : series,
			});
		},
	};

	var api =
	{
		init : execute_2.init,
	};

	exports.execute_2 = api;
	T.execute_2 = api;
});
