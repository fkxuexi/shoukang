drop table if exists activity_rule;
create table activity_rule(
	id int(11) unsigned primary key auto_increment comment "活动规则 自增主键",
	points int(11) unsigned not null default '0'	comment "参与活动的积分的限制",
	level int(11) unsigned not null default '0' comment "参与活动会员等级的限制",
	consume_money decimal(10,2) not null default '0' comment '参与活动消费金额限制',
	and_or int not null default 0 comment '组合条件,1:point,2:level,3:consume_money,12 则为12两个条件组合,13 则为13两个条件组合,23 则为23两个条件组合,123 则三个条件并列组合,如果为1,2,3 则只使用一个条件',
	create_time datetime not null comment '创建时间',
	descri varchar(100)  not null comment "简短的说明"
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 comment "活动规则";

drop table if exists activity_prize;
create table activity_prize(
	id int(11) unsigned primary key auto_increment comment "活动奖品类型 自增主键",
	discount decimal(10,2) comment '折扣',
	reback_money decimal(10,2) comment '返现券',
	reduce_money decimal(10,2) comment '减免',
	give_goods_id int(11) comment '赠送商品的id',
	give_score int(11) comment '赠送积分',
	prize_type int not null default 0 comment
	'1:discount,2:reback_money,3:reduce_money,4:give_goods_id,5:give_score,'
)engine=innodb default charset=utf8mb4 comment '活动奖品'; 

drop table if exists activity_setting;

create table activity_setting(
	id int(11) unsigned primary key auto_increment comment '活动设置 自增主键',
	start_time varchar(30) comment '活动开始时间',
	end_time varchar(30) comment '活动结束时间',
	user_can_take_times int comment '每人每次活动可参与的次数,值为0则默认无限参与',
	activity_times int  comment '活动 进行的总次数,例如仅限前100名参加等限制',
	is_forever int comment '是否为永久'
)engine=innodb default charset=utf8mb4 comment '活动设置';

drop table if exists activity_detail;
create table activity_detail(
	id int(11) unsigned primary key auto_increment comment '活动细节 自增主键',
	activity_type_id int(11) not null comment '活动类型id',
	activity_rule_id int(11) not null comment '活动规则id',
	activity_prize_type_id int(11) not null comment '活动奖品id',
	activity_setting_id int(11) not null comment '活动设置id',
	budget decimal(10,2) not null comment '此次活动的预算',
	used_budget decimal(10,2) not null comment '此次活动已使用的预算',
	activity_times int comment '活动参加的次数',
	activity_use_times int comment '已经参加的活动次数',
	is_on int not null comment '是否开启',
	state int comment '活动状态 1 正常,2 达到预算'
)engine=innodb default charset=utf8mb4 comment '活动细节';

-- 目前这张表要结合设计来
drop table if exists activity_announce;
create table activity_announce(
	id int(11) unsigned primary key auto_increment comment '活动说明表 自增主键'
)engine=innodb default charset=utf8mb4 comment '活动说明表 未完成';

-- 目前这张表的设计需要依据邀请函的设计来做模板
drop table if exists activity_invation;
create table activity_invation(
		id int(11) unsigned primary key auto_increment comment '邀请函表 自增主键'
)engine=innodb default charset=utf8mb4 comment '邀请函表 未完成';