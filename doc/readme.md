- timestamp :

默认为DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP，如果有多列为timestamp只有一列会自动的更新
如果只设置DEFAULT CURRENT_TIMESTAMP子句，而没有ON UPDATE子句，列值默认为当前时间戳但不自动更新。
