select distinct
dept_sn,
name,
room_name,
room_serial,
ip_addr,
fz_station_sn,
fz_flag,
fz_host_no,
fz_port_no,
windows_no,
charge_codes
from
VW_CIS_ROOM_CONFIG 
where ip_addr = /*ip*/'172.18.1.100'
order by dept_sn