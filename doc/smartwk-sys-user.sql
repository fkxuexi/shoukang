create table sys_user(
  id int UNSIGNED AUTO_INCREMENT primary key COMMENT '主键',
  login_identify varchar(50) unique not null COMMENT '登录标识(用户名,登录名,邮箱 必须唯一)',
  nike_name varchar(30) not null COMMENT '用户昵称',
  password varchar(32) not null COMMENT '用户密码',
  salt varchar(32) not null COMMENT '密码盐值',
  is_on int unsigned not null default 1 COMMENT '是否启用  Global 常量中的值，默认启用',
  phone varchar(11) COMMENT '电话',
  avatar varchar(100) COMMENT '用户图像',
  last_login_ip VARCHAR(80) not null COMMENT '最后一次登录的ip',
  last_login TIMESTAMP not null default current_timestamp on update current_timestamp COMMENT '最后一次登录时间,可以利用自动更新的特性',
  index login_index(login_identify,password),
  index get_user(login_identify)
) engine=Innodb default charset=utf8 comment '后台管理系统用户';

create table sys_role(
  id int UNSIGNED AUTO_INCREMENT primary key COMMENT '角色主键',
  role_name varchar(50) NOT NULL COMMENT '角色名',
  is_on int unsigned not null default 1 COMMENT '是否启用，Global 常量中的值，默认启用',
  role_desc VARCHAR(100) COMMENT '角色描述'
) engine=innodb default charset=utf8 COMMENT '后台角色表';

create table sys_menu(
  id int UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '菜单主键',
  name VARCHAR(50) unique not null COMMENT '菜单名称',
  url VARCHAR(100)  DEFAULT '' COMMENT '访问地址',
  auth_code VARCHAR(50) not null COMMENT '菜单权限码，配合shiro来使用',
  parent_id VARCHAR(32) NOT NULL  COMMENT '父级菜单id',
  sort INT UNSIGNED NOT NULL  COMMENT '组内排序',
  is_on INT UNSIGNED NOT NULL COMMENT '是否启用，Global 常量中的值，默认启用',
  type INT UNSIGNED NOT NULL DEFAULT 1 COMMENT '1 为link，2 为button，默认为1=link'
)engine=innodb default charset=utf8 COMMENT '角色权限表';

create table sys_role_user(
  id INT UNSIGNED AUTO_INCREMENT primary key COMMENT '用户角色主键',
  user_id INT UNSIGNED NOT NULL COMMENT '用户id',
  role_id INT UNSIGNED NOT NULL  COMMENT '角色id'
)ENGINE=innodb default charset=utf8 COMMENT '后台用户角色表';

create table sys_role_permission(
  id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '角色权限id',
  role_id INT UNSIGNED not null COMMENT '角色id',
  menu_id INT unsigned NOT NULL COMMENT '菜单主键'
)ENGINE=innodb default charset=utf8 COMMENT '角色权限表';


