insert into t_report values(1, '单值报表-日统计', '日期', '下载次数', null, 1, 1, 20141101000000, 1);
insert into t_execute values(1, 1, 20141105000000, '10');
insert into t_execute values(2, 1, 20141106000000, '13');
insert into t_execute values(3, 1, 20141107000000, '14');
insert into t_execute values(4, 1, 20141108000000, '15');
insert into t_execute values(5, 1, 20141109000000, '16');
insert into t_execute values(6, 1, 20141110000000, '17');
insert into t_execute values(7, 1, 20141111000000, '10');
insert into t_execute values(8, 1, 20141112000000, '9');
insert into t_execute values(9, 1, 20141113000000, '10');

insert into t_report values(2, '数值报表-日统计', '平台', '下载次数', null, 2, 1, 20141101000000, 1);
insert into t_execute values(11, 2, 20141105000000, '[{"k":"1", "v":"10"}, {"k":"4", "v":"5"}, {"k":"9", "v":"1"}]');
insert into t_execute values(12, 2, 20141106000000, '[{"k":"1", "v":"11"}, {"k":"4", "v":"9"}, {"k":"9", "v":"2"}]');
insert into t_execute values(13, 2, 20141107000000, '[{"k":"1", "v":"12"}, {"k":"4", "v":"15"}, {"k":"9", "v":"3"}]');
insert into t_execute values(14, 2, 20141108000000, '[{"k":"1", "v":"13"}, {"k":"4", "v":"25"}, {"k":"9", "v":"4"}]');
insert into t_execute values(15, 2, 20141109000000, '[{"k":"1", "v":"14"}, {"k":"4", "v":"15"}, {"k":"9", "v":"5"}]');
insert into t_execute values(16, 2, 20141110000000, '[{"k":"1", "v":"15"}, {"k":"4", "v":"9"}, {"k":"9", "v":"8"}]');
insert into t_execute values(17, 2, 20141111000000, '[{"k":"1", "v":"16"}, {"k":"4", "v":"5"}, {"k":"9", "v":"9"}]');
insert into t_execute values(18, 2, 20141112000000, '[{"k":"1", "v":"13"}, {"k":"4", "v":"8"}, {"k":"9", "v":"4"}]');
insert into t_execute values(19, 2, 20141113000000, '[{"k":"1", "v":"10"}, {"k":"4", "v":"5"}, {"k":"9", "v":"8"}]');

insert into t_report values(3, '列表报表-日统计', '日期', '下载次数', '项目;平台', 3, 1, 20141101000000, 1);
insert into t_execute values(21, 3, 20141105000000, '[{"v":"10", "c":[{"c":"1800"}, {"c":"1"}]}, {"v":"8", "c":[{"c":"1800"}, {"c":"4"}]}, {"v":"1", "c":[{"c":"2000"}, {"c":"1"}]}, {"v":"11", "c":[{"c":"2000"}, {"c":"4"}]}]');
insert into t_execute values(22, 3, 20141106000000, '[{"v":"11", "c":[{"c":"1800"}, {"c":"1"}]}, {"v":"9", "c":[{"c":"1800"}, {"c":"4"}]}, {"v":"2", "c":[{"c":"2000"}, {"c":"1"}]}, {"v":"12", "c":[{"c":"2000"}, {"c":"4"}]}]');
insert into t_execute values(23, 3, 20141107000000, '[{"v":"12", "c":[{"c":"1800"}, {"c":"1"}]}, {"v":"4", "c":[{"c":"1800"}, {"c":"4"}]}, {"v":"3", "c":[{"c":"2000"}, {"c":"1"}]}, {"v":"13", "c":[{"c":"2000"}, {"c":"4"}]}]');
insert into t_execute values(24, 3, 20141108000000, '[{"v":"13", "c":[{"c":"1800"}, {"c":"1"}]}, {"v":"6", "c":[{"c":"1800"}, {"c":"4"}]}, {"v":"4", "c":[{"c":"2000"}, {"c":"1"}]}, {"v":"14", "c":[{"c":"2000"}, {"c":"4"}]}]');
insert into t_execute values(25, 3, 20141109000000, '[{"v":"14", "c":[{"c":"1800"}, {"c":"1"}]}, {"v":"8", "c":[{"c":"1800"}, {"c":"4"}]}, {"v":"5", "c":[{"c":"2000"}, {"c":"1"}]}, {"v":"15", "c":[{"c":"2000"}, {"c":"4"}]}]');
insert into t_execute values(26, 3, 20141110000000, '[{"v":"15", "c":[{"c":"1800"}, {"c":"1"}]}, {"v":"8", "c":[{"c":"1800"}, {"c":"4"}]}, {"v":"6", "c":[{"c":"2000"}, {"c":"1"}]}, {"v":"16", "c":[{"c":"2000"}, {"c":"4"}]}]');
insert into t_execute values(27, 3, 20141111000000, '[{"v":"16", "c":[{"c":"1800"}, {"c":"1"}]}, {"v":"9", "c":[{"c":"1800"}, {"c":"4"}]}, {"v":"7", "c":[{"c":"2000"}, {"c":"1"}]}, {"v":"17", "c":[{"c":"2000"}, {"c":"4"}]}]');
insert into t_execute values(28, 3, 20141112000000, '[{"v":"17", "c":[{"c":"1800"}, {"c":"1"}]}, {"v":"7", "c":[{"c":"1800"}, {"c":"4"}]}, {"v":"8", "c":[{"c":"2000"}, {"c":"1"}]}, {"v":"18", "c":[{"c":"2000"}, {"c":"4"}]}]');
insert into t_execute values(29, 3, 20141113000000, '[{"v":"18", "c":[{"c":"1800"}, {"c":"1"}]}, {"v":"8", "c":[{"c":"1800"}, {"c":"4"}]}, {"v":"9", "c":[{"c":"2000"}, {"c":"1"}]}, {"v":"19", "c":[{"c":"2000"}, {"c":"4"}]}]');







insert into t_report values(4, '单值报表-月统计', '日期', '下载次数', null, 1, 2, 20141101000000, 1);
insert into t_execute values(31, 4, 20140101000000, '10');
insert into t_execute values(32, 4, 20140201000000, '13');
insert into t_execute values(33, 4, 20140301000000, '14');
insert into t_execute values(34, 4, 20140401000000, '15');
insert into t_execute values(35, 4, 20140501000000, '16');
insert into t_execute values(36, 4, 20140601000000, '17');
insert into t_execute values(37, 4, 20140701000000, '10');
insert into t_execute values(38, 4, 20140801000000, '9');
insert into t_execute values(39, 4, 20140901000000, '10');

insert into t_report values(5, '数值报表-月统计', '平台', '下载次数', null, 2, 2, 20141101000000, 1);
insert into t_execute values(41, 5, 20140101000000, '[{"k":"1", "v":"10"}, {"k":"4", "v":"5"}, {"k":"9", "v":"1"}]');
insert into t_execute values(42, 5, 20140201000000, '[{"k":"1", "v":"11"}, {"k":"4", "v":"9"}, {"k":"9", "v":"2"}]');
insert into t_execute values(43, 5, 20140301000000, '[{"k":"1", "v":"12"}, {"k":"4", "v":"15"}, {"k":"9", "v":"3"}]');
insert into t_execute values(44, 5, 20140401000000, '[{"k":"1", "v":"13"}, {"k":"4", "v":"25"}, {"k":"9", "v":"4"}]');
insert into t_execute values(45, 5, 20140501000000, '[{"k":"1", "v":"14"}, {"k":"4", "v":"15"}, {"k":"9", "v":"5"}]');
insert into t_execute values(46, 5, 20140601000000, '[{"k":"1", "v":"15"}, {"k":"4", "v":"9"}, {"k":"9", "v":"8"}]');
insert into t_execute values(47, 5, 20140701000000, '[{"k":"1", "v":"16"}, {"k":"4", "v":"5"}, {"k":"9", "v":"9"}]');
insert into t_execute values(48, 5, 20140801000000, '[{"k":"1", "v":"13"}, {"k":"4", "v":"8"}, {"k":"9", "v":"4"}]');
insert into t_execute values(49, 5, 20140901000000, '[{"k":"1", "v":"10"}, {"k":"4", "v":"5"}, {"k":"9", "v":"8"}]');

insert into t_report values(6, '列表报表-月统计', '日期', '下载次数', '项目;平台', 3, 2, 20141101000000, 1);
insert into t_execute values(51, 6, 20140101000000, '[{"v":"10", "c":[{"c":"1800"}, {"c":"1"}]}, {"v":"8", "c":[{"c":"1800"}, {"c":"4"}]}, {"v":"1", "c":[{"c":"2000"}, {"c":"1"}]}, {"v":"11", "c":[{"c":"2000"}, {"c":"4"}]}]');
insert into t_execute values(52, 6, 20140201000000, '[{"v":"11", "c":[{"c":"1800"}, {"c":"1"}]}, {"v":"9", "c":[{"c":"1800"}, {"c":"4"}]}, {"v":"2", "c":[{"c":"2000"}, {"c":"1"}]}, {"v":"12", "c":[{"c":"2000"}, {"c":"4"}]}]');
insert into t_execute values(53, 6, 20140301000000, '[{"v":"12", "c":[{"c":"1800"}, {"c":"1"}]}, {"v":"4", "c":[{"c":"1800"}, {"c":"4"}]}, {"v":"3", "c":[{"c":"2000"}, {"c":"1"}]}, {"v":"13", "c":[{"c":"2000"}, {"c":"4"}]}]');
insert into t_execute values(54, 6, 20140401000000, '[{"v":"13", "c":[{"c":"1800"}, {"c":"1"}]}, {"v":"6", "c":[{"c":"1800"}, {"c":"4"}]}, {"v":"4", "c":[{"c":"2000"}, {"c":"1"}]}, {"v":"14", "c":[{"c":"2000"}, {"c":"4"}]}]');
insert into t_execute values(55, 6, 20140501000000, '[{"v":"14", "c":[{"c":"1800"}, {"c":"1"}]}, {"v":"8", "c":[{"c":"1800"}, {"c":"4"}]}, {"v":"5", "c":[{"c":"2000"}, {"c":"1"}]}, {"v":"15", "c":[{"c":"2000"}, {"c":"4"}]}]');
insert into t_execute values(56, 6, 20140601000000, '[{"v":"15", "c":[{"c":"1800"}, {"c":"1"}]}, {"v":"8", "c":[{"c":"1800"}, {"c":"4"}]}, {"v":"6", "c":[{"c":"2000"}, {"c":"1"}]}, {"v":"16", "c":[{"c":"2000"}, {"c":"4"}]}]');
insert into t_execute values(57, 6, 20140701000000, '[{"v":"16", "c":[{"c":"1800"}, {"c":"1"}]}, {"v":"9", "c":[{"c":"1800"}, {"c":"4"}]}, {"v":"7", "c":[{"c":"2000"}, {"c":"1"}]}, {"v":"17", "c":[{"c":"2000"}, {"c":"4"}]}]');
insert into t_execute values(58, 6, 20140801000000, '[{"v":"17", "c":[{"c":"1800"}, {"c":"1"}]}, {"v":"7", "c":[{"c":"1800"}, {"c":"4"}]}, {"v":"8", "c":[{"c":"2000"}, {"c":"1"}]}, {"v":"18", "c":[{"c":"2000"}, {"c":"4"}]}]');
insert into t_execute values(59, 6, 20140901000000, '[{"v":"18", "c":[{"c":"1800"}, {"c":"1"}]}, {"v":"8", "c":[{"c":"1800"}, {"c":"4"}]}, {"v":"9", "c":[{"c":"2000"}, {"c":"1"}]}, {"v":"19", "c":[{"c":"2000"}, {"c":"4"}]}]');


insert into t_user values(1, '546806', '123456', '张伟旭', 1);
insert into t_user values(2, '130519', '123456', '张海', 2);

insert into t_acl values(1, 1, 1, 20141101000000);
insert into t_acl values(1, 1, 2, 20141101000000);
insert into t_acl values(1, 1, 3, 20141101000000);
insert into t_acl values(1, 1, 4, 20141101000000);
insert into t_acl values(1, 1, 5, 20141101000000);
insert into t_acl values(1, 1, 6, 20141101000000);